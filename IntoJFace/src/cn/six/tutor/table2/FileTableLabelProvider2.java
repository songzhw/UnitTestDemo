package cn.six.tutor.table2;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import java.io.File;

/**
 * Created by songzhw on 2016/2/28.
 */
public class FileTableLabelProvider2 implements ITableLabelProvider {

    @Override
    public Image getColumnImage(Object o, int i) {
        if( i == 0){
            File file = (File) o;
            if(file.isDirectory()){
                return Table2Util.getImageRegister().get("folder");
            } else{
                return Table2Util.getImageRegister().get("file");
            }
        }
        return null;
    }

    @Override
    public String getColumnText(Object o, int i) {
        File file = (File) o;
        if(i == 0){
            return file.getName();
        } else {
            return ""+file.length();
        }
    }

    @Override
    public void addListener(ILabelProviderListener iLabelProviderListener) { }

    @Override
    public void dispose() { }

    @Override
    public boolean isLabelProperty(Object o, String s) { return false; }

    @Override
    public void removeListener(ILabelProviderListener iLabelProviderListener) {}
}
