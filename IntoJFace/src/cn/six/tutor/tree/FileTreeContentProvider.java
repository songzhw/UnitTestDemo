package cn.six.tutor.tree;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import java.io.File;

/**
 * Created by songzhw on 2016/2/27.
 */
public class FileTreeContentProvider implements ITreeContentProvider {
    @Override
    public Object[] getChildren(Object o) {
        Object[] kids = ((File)o).listFiles();
        return kids == null ? new Object[0] : kids;
    }

    @Override
    public Object getParent(Object o) {
        return ((File)o).getParent();
    }

    @Override
    public boolean hasChildren(Object o) {
        return getChildren(o).length > 0;
    }

    @Override
    public Object[] getElements(Object o) {
        return getChildren(o);
    }

    @Override
    public void dispose() { }

    @Override
    public void inputChanged(Viewer viewer, Object o, Object o1) { }
}
