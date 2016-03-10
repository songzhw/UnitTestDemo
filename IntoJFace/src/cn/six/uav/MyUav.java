package cn.six.uav;

import cn.six.uav.action.ScreenShotAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by songzhw on 2016/3/10.
 */
public class MyUav extends ApplicationWindow {

    public MyUav() {
        super(null);
        addToolBar(SWT.FLAT | SWT.WRAP);
    }

    @Override
    protected ToolBarManager createToolBarManager(int style) {
        ToolBarManager toolbar = new ToolBarManager(style);
        toolbar.add(new ScreenShotAction(this));
        return toolbar;
    }

    @Override
    protected Control createContents(Composite parent) {
        return super.createContents(parent);
    }

    public static void main(String[] args) {
        MyUav app = new MyUav();
        app.setBlockOnOpen(true);
        app.open();
        Display.getCurrent().dispose();
    }
}
