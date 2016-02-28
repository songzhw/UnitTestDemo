package cn.six.tutor.table;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import java.io.File;

/**
 * Created by songzhw on 2016/2/28.
 */
public class FileTableLabelProvider implements ITableLabelProvider {

    @Override
    public Image getColumnImage(Object o, int i) {
        return null;
    }

    @Override
    public String getColumnText(Object o, int i) {
        return ((File)o).getName();
    }

    @Override
    public void addListener(ILabelProviderListener iLabelProviderListener) { }

    @Override
    public void dispose() { }

    @Override
    public boolean isLabelProperty(Object o, String s) {
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener iLabelProviderListener) {}
}
