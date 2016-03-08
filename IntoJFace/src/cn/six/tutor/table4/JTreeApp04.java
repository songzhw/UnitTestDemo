package cn.six.tutor.table4;

import cn.six.tutor.actions.ExitAction;
import cn.six.tutor.actions.OpenAction;
import cn.six.tutor.table2.FileTableContentProvider2;
import cn.six.tutor.table2.FileTableLabelProvider2;
import cn.six.tutor.table2.FileTreeLabelProvider2;
import cn.six.tutor.table3.MyDirectoryFilter;
import cn.six.tutor.table3.MyFileSorter;
import cn.six.tutor.tree.FileTreeContentProvider;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
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
public class JTreeApp04 extends ApplicationWindow implements ITableSelection{

    private TableViewer table;

    public JTreeApp04() {
        super(null);
        addStatusLine();
        addMenuBar();
        addToolBar(SWT.FLAT | SWT.WRAP);
    }

    @Override
    protected MenuManager createMenuManager() {
        MenuManager menuMgr = new MenuManager();
        MenuManager fileMenu = new MenuManager("&File");
        menuMgr.add(fileMenu);
        fileMenu.add(new ExitAction(this));
        fileMenu.add(new OpenAction(this));
        return menuMgr;
    }

    @Override
    protected ToolBarManager createToolBarManager(int style) {
        ToolBarManager toolbar = new ToolBarManager(style);
        toolbar.add(new ExitAction(this));
        toolbar.add(new OpenAction(this));
        return toolbar;
    }

    @Override
    protected Control createContents(Composite parent) {
        getShell().setText("szw Title");
        SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL | SWT.NULL);

        TreeViewer tree = new TreeViewer(sashForm);
        tree.setContentProvider(new FileTreeContentProvider());
        tree.setLabelProvider(new FileTreeLabelProvider2());
        tree.setInput(new File("E:\\temp"));
        tree.addFilter(new MyDirectoryFilter());


        this.table = new TableViewer(sashForm, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
        this.table.setContentProvider(new FileTableContentProvider2());
        this.table.setLabelProvider(new FileTableLabelProvider2());
        this.table.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                setStatus("szw selected (right) "+selection.size());
            }
        });

        TableColumn column = new TableColumn(this.table.getTable(), SWT.LEFT);
        column.setText("Name");
        column.setWidth(200);

        TableColumn column2 = new TableColumn(this.table.getTable(), SWT.RIGHT);
        column2.setText("Size");
        column2.setWidth(100);

        this.table.getTable().setHeaderVisible(true);
        this.table.setSorter(new MyFileSorter());

        tree.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                Object selectedFile = selection.getFirstElement();
                table.setInput(selectedFile);
            }
        });

        MenuManager tableMenu = new MenuManager();
        table.getTable().setMenu(tableMenu.createContextMenu(table.getTable()));
        tableMenu.add(new OpenAction(this));

        return sashForm;

    }

    @Override
    public IStructuredSelection getTableSelection(){
        return (IStructuredSelection) table.getSelection();
    }

    public static void main(String[] args) {
        JTreeApp04 app = new JTreeApp04();
        app.setBlockOnOpen(true);
        app.open();
        Display.getCurrent().dispose();

    }
}
