package cn.six.tutor.jtree;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import java.io.File;

/**
 * Created by songzhw on 2016/2/28.
 */
public class FileTableContentProvider implements IStructuredContentProvider {
    @Override
    public Object[] getElements(Object o) {
        Object[] kids = null;
        kids = ((File) o).listFiles();
        return kids == null ? new Object[0] : kids;
    }

    @Override
    public void dispose() {    }

    @Override
    public void inputChanged(Viewer viewer, Object o, Object o1) { }
}
