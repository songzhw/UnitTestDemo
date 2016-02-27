package cn.six.tutor.actions;

import cn.six.tutor.util.ImageHelper;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.ApplicationWindow;

/**
 * Created by songzhw on 2016/2/27.
 */
public class AboutAction extends Action {
    ApplicationWindow app;

    public AboutAction(ApplicationWindow window) {
        super("&Me");
        app = window;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return ImageHelper.loadImageDesp("images/about.png");
    }

    @Override
    public void run() {
        System.out.println("Eclipse SWT/Jface Tutor v0.2");
    }
}
