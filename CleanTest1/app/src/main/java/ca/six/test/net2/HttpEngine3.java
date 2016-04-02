package ca.six.test.net2;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class HttpEngine3 {
    private static final int CONNECT_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 40000;


    private HttpURLConnection initHttpConnection(String url) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        HttpURLConnection http;

        URL urlInstance = new URL(url);
        if (url.startsWith("https")) {
            HttpsURLConnection https = (HttpsURLConnection) urlInstance.openConnection();

            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManager[] trustManagers = {new MyX509TrustManager()};
            sslContext.init(null, trustManagers, new SecureRandom());
            https.setSSLSocketFactory(sslContext.getSocketFactory());

            HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return "api.github.com".equals(hostname);
                }
            };
            https.setHostnameVerifier(hostnameVerifier);
            http = https;
        } else {
            http = (HttpURLConnection) urlInstance.openConnection();
        }
        http.setConnectTimeout(CONNECT_TIMEOUT);
        http.setReadTimeout(READ_TIMEOUT);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        return http;
    }

    private static class MyX509TrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
                throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            if (chain == null) {
                throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
            }

            if (!(chain.length > 0)) {
                throw new IllegalArgumentException("checkServerTrusted: X509Certificate is empty");
            }

            if (!(null != authType)) {
                throw new CertificateException("checkServerTrusted: AuthType is not RSA");
            }

            // 验证证书是否是CA颁发
            TrustManagerFactory tmf;
            try {
                tmf = TrustManagerFactory.getInstance("X509");
                tmf.init((KeyStore) null);
                for (TrustManager trustManager : tmf.getTrustManagers()) {
                    ((X509TrustManager) trustManager).checkServerTrusted(chain, authType);
                }
            } catch (Exception e) {
                throw new CertificateException(e);
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }


    // =========================================================
    public String sendHttpGetRequest(String url) {
        try {
            HttpURLConnection http = initHttpConnection(url);

            http.setRequestMethod("GET");
            int responseCode = http.getResponseCode();
            BufferedReader is = null;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                is = new BufferedReader(new InputStreamReader(http.getInputStream()));
            } else {
                is = new BufferedReader(new InputStreamReader(http.getErrorStream()));
            }

            StringBuilder s = new StringBuilder();
            char[] buf = new char[1024];
            int num = -1;
            while ((num = is.read(buf)) != -1) {
                s.append(buf, 0, num);
            }
            String str = s.toString();

            is.close();
            http.disconnect();
            return str;
        } catch (NoSuchAlgorithmException e) {
            Log.e("HttpEngine2", "Error on SSL init (NoSuchAlgorithmException)", e);
        } catch (KeyManagementException e) {
            Log.e("HttpEngine2", "Error on SSL init (KeyManagementException)", e);
        } catch (MalformedURLException e) {
            Log.e("HttpEngine2", "url format error", e);
        } catch (IOException e) {
            Log.e("HttpEngine2", "http IO error", e);
        }

        return "";
    }


}
