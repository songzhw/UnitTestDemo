package cn.six.uav.action;

import cn.six.tutor.table2.Table2Util;
import cn.six.uav.MyUav;
import cn.six.uav.UavModel;
import cn.six.uav.tree.BasicTreeNode;
import cn.six.uav.tree.UiHierarchyXmlLoader;
import cn.six.uav.util.CommandRunner;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

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
            // 1. screenshot
            List<String> cmds = initCmd("adb shell /system/bin/screencap -p /sdcard/test.png");
            CommandRunner runner = new CommandRunner();
            runner.run(cmds);

            // 2. get and draw the screenshot
            cmds.clear();
            cmds = initCmd("adb pull /sdcard/test.png E:/temp");
            runner.run(cmds);

            ImageData[] data = new ImageLoader().load("E:/temp/test.png");
            UavModel.image = new Image(app.getShell().getDisplay(), data[0]);


            // 3. delete the ol UI XML snapshot(?) (szw: 好像下一次会自动覆盖掉老的， 不用特意删除）

            // 4. Taking UI XML snapshot
            cmds.clear();
            cmds = initCmd("adb shell /system/bin/uiautomator dump /sdcard/test.xml");
            runner.run(cmds);

            // 5. get the UI XMl
            cmds.clear();
            cmds = initCmd("adb pull /sdcard/test.xml E:/temp");
            runner.run(cmds);

            // 6. run
            initNodes();

            app.redraw();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initNodes() {
        File xml = new File("E:/temp/test.xml");
        UiHierarchyXmlLoader xmlLoader = new UiHierarchyXmlLoader();
        BasicTreeNode rootNode = xmlLoader.parseXml(xml.getAbsolutePath());
        List<Rectangle> nafNodes = xmlLoader.getNafNodes();  // "Not Accessibility Friendly" node

        UavModel.xmlRootNode = rootNode;

    }

    private List<String> initCmd(String cmd){
        List<String> cmds = new ArrayList<>();
        String[] result = cmd.split(" ");
        for(String a : result){
            cmds.add(a);
        }
        return cmds;
    }
}
