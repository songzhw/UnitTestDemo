package cn.six.tutor.table3;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import java.io.File;

/**
 * Created by songzhw on 2016/3/5.
 */
public class MyDirectoryFilter extends ViewerFilter {
    @Override
    public boolean select(Viewer viewer, Object parent, Object element) {
        File file = (File) element;
        return file.isDirectory();
    }
}
