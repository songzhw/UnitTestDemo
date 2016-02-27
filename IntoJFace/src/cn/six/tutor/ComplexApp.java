package cn.six.tutor;

import cn.six.tutor.actions.AboutAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by songzhw on 2016/2/27.
 */
public class ComplexApp extends ApplicationWindow {
    private ComplexApp self;

    public ComplexApp() {
        super(null);
        self = this;
    }

    @Override
    protected Control createContents(Composite parent) {
        parent.setLayout(new GridLayout(2, false));

        Button btn = new Button(parent, SWT.PUSH);
        btn.setText("Hello World 22");
        btn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                System.out.println("szw Click Button 22!");
            }
        });

        ToolBarManager toolbarMgr = new ToolBarManager(SWT.FLAT);
        toolbarMgr.add(new AboutAction(self));
        toolbarMgr.add(new Action("Exit") {
            @Override
            public void run() {
                self.close();
            }
        });
        toolbarMgr.add(new Action("Nothing"){});
        toolbarMgr.createControl(parent);

        return parent;
    }

    public static void main(String[] args) {
        ComplexApp app = new ComplexApp();
        app.setBlockOnOpen(true);
        app.open();
        Display.getCurrent().dispose();
    }
}
