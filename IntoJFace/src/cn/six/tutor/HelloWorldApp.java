package cn.six.tutor;

import javafx.application.Application;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;
import sun.applet.Main;

/**
 * Created by songzhw on 2016/2/27.
 */
public class HelloWorldApp extends ApplicationWindow {

    public HelloWorldApp() {
        super(null);
    }

    @Override
    protected Control createContents(Composite parent) {
        Button btn = new Button(parent, SWT.PUSH);
        btn.setText("Hello World");
        btn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                System.out.println("szw Click Button!");
            }
        });
        return btn;
    }

    public static void main(String[] args) {
        HelloWorldApp app = new HelloWorldApp();
        app.setBlockOnOpen(true);
        app.open();
        Display.getCurrent().dispose();
    }
}
