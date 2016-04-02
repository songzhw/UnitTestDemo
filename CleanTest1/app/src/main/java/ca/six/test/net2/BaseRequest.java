package ca.six.test.net2;


public class BaseRequest extends AsyncTaskEx<String, Void, String> {
    private String url;
    private IRespListener listener;

    public void startRequest(String url, IRespListener alistener) {
        this.url = url;
        this.listener = alistener;
        this.execute();
    }

    @Override
    protected String doInBackground(String... params) {
        HttpEngine3 httpEngine = new HttpEngine3();
        return httpEngine.sendHttpGetRequest(url);
    }

    @Override
    protected void onPostExecute(String result) {
        if (listener != null) {
            listener.onResponsed(result);
        }
    }

}
