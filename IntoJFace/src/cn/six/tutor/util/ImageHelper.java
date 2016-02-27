package cn.six.tutor.util;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by songzhw on 2016/2/27.
 */
public class ImageHelper {

    public static ImageDescriptor loadImageDesp(String path) {
        try {
            InputStream is = new FileInputStream(path);
            if (is != null) {
                ImageData[] data = null;
                data = new ImageLoader().load(is);
                if (data != null && data.length > 0) {
                    return ImageDescriptor.createFromImageData(data[0]);
                }
            } else {
                System.out.println("Error : image is null");
            }
        } catch (Exception e) {
        }
        return null;
    }

}
