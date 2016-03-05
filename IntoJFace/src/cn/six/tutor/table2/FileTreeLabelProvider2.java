package cn.six.tutor.table2;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import java.io.File;

/**
 * Created by songzhw on 2016/2/27.
 */
public class FileTreeLabelProvider2 extends LabelProvider {

    @Override
    public String getText(Object element) {
        return ((File)element).getName();
    }

    @Override
    public Image getImage(Object element) {
        File file = (File) element;
        if(file.isDirectory()){
            return Table2Util.getImageRegister().get("folder");
        } else{
            return Table2Util.getImageRegister().get("file");
        }
    }
}
