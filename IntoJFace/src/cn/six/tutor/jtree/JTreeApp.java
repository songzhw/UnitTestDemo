package cn.six.tutor.jtree;

import cn.six.tutor.tree.FileTreeContentProvider;
import cn.six.tutor.tree.FileTreeLabelProvider;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.io.File;

/**
 * Created by songzhw on 2016/2/28.
 */
public class JTreeApp extends ApplicationWindow {
    public JTreeApp() {
        super(null);
    }

    @Override
    protected Control createContents(Composite parent) {
        SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL | SWT.NULL);

        TreeViewer tree = new TreeViewer(sashForm);
        tree.setContentProvider(new FileTreeContentProvider());
        tree.setLabelProvider(new FileTreeLabelProvider());
        tree.setInput(new File("E:\\temp"));

        final TableViewer table = new TableViewer(sashForm, SWT.BORDER);
        table.setContentProvider(new FileTableContentProvider());
        table.setLabelProvider(new FileTableLabelProvider());

        tree.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                Object selectedFile = selection.getFirstElement();
                table.setInput(selectedFile);
            }
        });

        return sashForm;

    }

    public static void main(String[] args) {
        JTreeApp app = new JTreeApp();
        app.setBlockOnOpen(true);
        app.open();
        Display.getCurrent().dispose();

    }
}
