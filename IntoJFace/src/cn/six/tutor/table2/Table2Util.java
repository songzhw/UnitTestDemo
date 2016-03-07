package cn.six.tutor.table2;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by songzhw on 2016/3/5.
 */
public class Table2Util {

    private static ImageRegistry imgReg;

    public static URL newUrl(String urlName){
        try {
            return new URL(urlName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ImageRegistry getImageRegister() {
        if(imgReg == null){
            imgReg = new ImageRegistry();
            imgReg.put("folder", ImageDescriptor.createFromURL(newUrl("file:images/ic_box_16.png")));
            imgReg.put("file", ImageDescriptor.createFromURL(newUrl("file:images/ic_file_16.png")));
        }
        return imgReg;
    }

    public static ImageDescriptor getImageDesp(String url){
        return ImageDescriptor.createFromURL(Table2Util.newUrl(url));
    }

}
