package cn.six.uav;

import cn.six.uav.action.ScreenShotAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

/**
 * Created by songzhw on 2016/3/10.
 */
public class MyUav extends ApplicationWindow {
    private Image image;
    private Canvas canvas;

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
        canvas = new Canvas(getShell(), SWT.BORDER);
        canvas.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                if(image != null) {
                    e.gc.drawImage(image, 0, 0);
                }
            }
        });
        return canvas;
    }

    public void redraw(){
        image = UavModel.image;
        canvas.redraw();
    }

    public static void main(String[] args) {
        MyUav app = new MyUav();
        app.setBlockOnOpen(true);
        app.open();
        Display.getCurrent().dispose();
    }
}
