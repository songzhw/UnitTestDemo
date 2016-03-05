package cn.six.tutor.table2;

import cn.six.tutor.tree.FileTreeContentProvider;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;

import java.io.File;

/**
 * Created by songzhw on 2016/3/3.
 */
public class JTreeApp02 extends ApplicationWindow {

    public JTreeApp02() {
        super(null);
        addStatusLine();
    }

    @Override
    protected Control createContents(Composite parent) {
        getShell().setText("szw Title");
        SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL | SWT.NULL);

        TreeViewer tree = new TreeViewer(sashForm);
        tree.setContentProvider(new FileTreeContentProvider());
        tree.setLabelProvider(new FileTreeLabelProvider2());
        tree.setInput(new File("E:\\temp"));


        final TableViewer table = new TableViewer(sashForm, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
        table.setContentProvider(new FileTableContentProvider2());
        table.setLabelProvider(new FileTableLabelProvider2());
        table.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                setStatus("szw selected (right) "+selection.size());
            }
        });

        TableColumn column = new TableColumn(table.getTable(), SWT.LEFT);
        column.setText("Name");
        column.setWidth(200);

        TableColumn column2 = new TableColumn(table.getTable(), SWT.RIGHT);
        column2.setText("Size");
        column2.setWidth(100);

        table.getTable().setHeaderVisible(true);


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
        JTreeApp02 app = new JTreeApp02();
        app.setBlockOnOpen(true);
        app.open();
        Display.getCurrent().dispose();

    }
}
