package cn.six.tutor.actions;

import cn.six.tutor.table2.Table2Util;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.ApplicationWindow;

/**
 * Created by songzhw on 2016/3/7.
 */
public class ExitAction extends Action {

    ApplicationWindow app;

    public ExitAction(ApplicationWindow window) {
        app = window;
        setText("E&xit @Ctrl+Q");
        setToolTipText("Exit this app");
        setImageDescriptor(Table2Util.getImageDesp("file:images/ic_close_16.png"));
    }

    @Override
    public void run() {
        app.close();
    }
}
