package cn.six.tutor;

import cn.six.tutor.tree.FileTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import sun.applet.Main;

import java.io.File;

/**
 * Created by songzhw on 2016/2/27.
 */
public class ComplexerApp extends ApplicationWindow {
    private ComplexerApp self;

    public ComplexerApp() {
        super(null);
        self = this;
    }

    @Override
    protected Control createContents(Composite parent) {
        TreeViewer tree = new TreeViewer(parent);
        tree.setContentProvider(new FileTreeContentProvider());
        tree.setInput(new File("E:\\temp"));
        return tree.getTree();
    }

    public static void main(String[] args) {
        ComplexerApp app = new ComplexerApp();
        app.setBlockOnOpen(true);
        app.open();
        Display.getDefault().dispose();
    }

}
