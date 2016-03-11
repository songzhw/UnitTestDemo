package cn.six.uav;

import cn.six.uav.action.ScreenShotAction;
import cn.six.uav.util.MathUtil;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
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
    protected Point getInitialSize() {
        return new Point(600, 800);
    }

    @Override
    protected Point getInitialLocation(Point initialSize) {
        return new Point(200, 30);
    }

    @Override
    protected Control createContents(Composite parent) {
        canvas = new Canvas(getShell(), SWT.NONE | SWT.NO_REDRAW_RESIZE);
        canvas.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                if(image != null) {
                    Rectangle canvasRect = canvas.getBounds();
                    float scale = MathUtil.getScale(canvasRect);

                    Transform transform = new Transform(e.gc.getDevice());
                    transform.scale(scale, scale);
                    e.gc.setTransform(transform);
                    e.gc.drawImage(image, 0, 0);
                    e.gc.setTransform(null);
                }
            }
        });
        return canvas;
    }

    public void redraw(){
        image = UavModel.image;
        canvas.redraw();
    }

    @Override
    public boolean close() {
        if(image != null) {
            image.dispose();
        }
        if(UavModel.image != null) {
            UavModel.image.dispose();
        }
        return super.close();
    }

    public static void main(String[] args) {
        MyUav app = new MyUav();
        app.setBlockOnOpen(true);
        app.open();
        Display.getCurrent().dispose();
    }
}
