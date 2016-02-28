package cn.six.tutor.tree;

import org.eclipse.jface.viewers.LabelProvider;

import java.io.File;

/**
 * Created by songzhw on 2016/2/27.
 */
public class FileTreeLabelProvider extends LabelProvider {

    @Override
    public String getText(Object element) {
        return ((File)element).getName();
    }

}
