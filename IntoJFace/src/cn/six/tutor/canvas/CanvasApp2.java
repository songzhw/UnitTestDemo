package cn.six.tutor.canvas;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

/**
 * Created by songzhw on 2016/3/9.
 */
public class CanvasApp2 extends ApplicationWindow {
    private Image image;

    public CanvasApp2() {
        super(null);
    }

    @Override
    protected Control createContents(Composite parent) {
        getShell().setText("Canvas Text");
        getShell().setSize(350, 150);

        Display display = Display.getCurrent();

        image = new Image(display, "images/about.png");

        Canvas canvas = new Canvas(getShell(), SWT.BORDER);
        canvas.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                e.gc.drawImage(image, 0, 0);
            }
        });

        return canvas;
    }

    @Override
    public boolean close() {
        System.out.println("szw close()");
        image.dispose();
        return super.close();
    }

    public static void main(String[] args) {
        CanvasApp2 app = new CanvasApp2();
        app.setBlockOnOpen(true);
        app.open();
        Display.getCurrent().dispose();
    }
}
