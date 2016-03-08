package com.intalgent.addressbook.menubar;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Display;


public class AboutAction extends Action {
    ApplicationWindow window;

    public AboutAction(ApplicationWindow w) {
        window = w;
        this.setText("&About Address Book");
        this.setToolTipText("Exit the application");
    }

    public void run() {
        MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
                "About Address Book", "IBM developerWorks");
    }
}
