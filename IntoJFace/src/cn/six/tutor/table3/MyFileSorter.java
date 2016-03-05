package cn.six.tutor.table3;

import org.eclipse.jface.viewers.ViewerSorter;

import java.io.File;

/**
 * Created by songzhw on 2016/3/5.
 */
public class MyFileSorter extends ViewerSorter {

    @Override
    public int category(Object element) {
        File file = (File) element;
        return file.isDirectory() ? 0 : 1 ;
    }
}
