package cn.six.tutor;

import cn.six.tutor.tree.FileTreeContentProvider;
import cn.six.tutor.tree.FileTreeLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import java.io.File;

/**
 * Created by songzhw on 2016/2/27.
 */
public class Tree04App extends ApplicationWindow {
    private Tree04App self;

    public Tree04App() {
        super(null);
        self = this;
    }

    @Override
    protected Control createContents(Composite parent) {
        TreeViewer tree = new TreeViewer(parent);
        tree.setContentProvider(new FileTreeContentProvider());
        tree.setInput(new File("E:\\temp"));
        tree.setLabelProvider(new FileTreeLabelProvider());
        return tree.getTree();
    }

    public static void main(String[] args) {
        Tree03App app = new Tree03App();
        app.setBlockOnOpen(true);
        app.open();
        Display.getDefault().dispose();
    }

}
