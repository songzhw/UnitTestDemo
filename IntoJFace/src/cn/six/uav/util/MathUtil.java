package cn.six.uav.util;

import cn.six.uav.UavModel;
import org.eclipse.swt.graphics.Rectangle;

/**
 * Created by songzhw on 2016/3/11.
 */
public class MathUtil {
    public static float getScale(Rectangle canvasRect){
        if(UavModel.image == null ){ return 1;}

        Rectangle imageRect = UavModel.image.getBounds();
        float sx = canvasRect.width * 1.0f / imageRect.width ;
        float sy = canvasRect.height * 1.0f / imageRect.height;
        float scale = Math.min(sx, sy);
        return scale;
    }
}
