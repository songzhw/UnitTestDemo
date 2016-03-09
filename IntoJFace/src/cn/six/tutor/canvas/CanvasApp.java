package cn.six.tutor.canvas;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

/**
 * Created by songzhw on 2016/3/9.
 */
public class CanvasApp extends ApplicationWindow {

    public CanvasApp() {
        super(null);
    }

    @Override
    protected Control createContents(Composite parent) {
        getShell().setText("Canvas Text");
        getShell().setSize(350, 150);


        Canvas canvas = new Canvas(getShell(), SWT.NONE);

        // Create a button on the canvas
        Button button = new Button(canvas, SWT.PUSH);
        button.setBounds(10, 10, 300, 40);
        button.setText("You can place widgets on a canvas");

        // Create a paint handler for the canvas
        canvas.addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent e) {
                // Do some drawing
                Rectangle rect = ((Canvas) e.widget).getBounds();
                e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_RED));
                e.gc.drawFocus(5, 5, rect.width - 10, rect.height - 10);
                e.gc.drawText("You can draw text directly on a canvas", 60, 60);
            }
        });

        return canvas;
    }

    public static void main(String[] args) {
        CanvasApp app = new CanvasApp();
        app.setBlockOnOpen(true);
        app.open();
        Display.getCurrent().dispose();
    }
}
