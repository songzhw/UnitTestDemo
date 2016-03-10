package cn.six.uav.action;

import cn.six.tutor.table2.Table2Util;
import cn.six.uav.MyUav;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by songzhw on 2016/3/10.
 */
public class ScreenShotAction extends Action {

    private final MyUav app;

    public ScreenShotAction(MyUav app) {
        setText("ScreenShot...");
        this.app = app;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return Table2Util.getImageDesp("file:images/screenshot.png");
    }

    @Override
    public void run() {
        super.run();

        try {

            ProgressMonitorDialog dialog = new ProgressMonitorDialog(app.getShell());
            dialog.run(true, false, new IRunnableWithProgress() {
                @Override
                public void run(IProgressMonitor iProgressMonitor) throws InvocationTargetException, InterruptedException {
                    System.out.println("sze test... test...");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
