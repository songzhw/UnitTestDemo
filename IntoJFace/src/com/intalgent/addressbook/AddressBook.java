package com.intalgent.addressbook;

import com.intalgent.addressbook.domain.Contact;
import com.intalgent.addressbook.menubar.AboutAction;
import com.intalgent.addressbook.menubar.ExitAction;
import com.intalgent.addressbook.menubar.NewContactAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;


public class AddressBook extends ApplicationWindow {
    private static ArrayList contactList;
    private static TableViewer tableViewer;
    private Table table;

    public AddressBook() {
        super(null);
        this.addMenuBar();

        contactList = new ArrayList();
    }

    protected Control createContents(Composite parent) {
        Shell shell = this.getShell();
        shell.setText("Personal Address Book");
        shell.setSize(500, 300);

        SashForm form = new SashForm(parent, SWT.HORIZONTAL | SWT.NULL);

        table = new Table(form, SWT.FULL_SELECTION | SWT.BORDER);

        TableColumn column = new TableColumn(table, SWT.LEFT);
        column.setText("Name");
        column.setWidth(150);
        table.setHeaderVisible(true);

        column = new TableColumn(table, SWT.LEFT);
        column.setText("E-Mail Address");
        column.setWidth(125);
        table.setHeaderVisible(true);

        column = new TableColumn(table, SWT.LEFT);
        column.setText("Business Phone");
        column.setWidth(100);
        table.setHeaderVisible(true);

        column = new TableColumn(table, SWT.LEFT);
        column.setText("Home Phone");
        column.setWidth(100);
        table.setHeaderVisible(true);

        tableViewer = new TableViewer(table);

        return form;
    }

    public static void main(String[] args) {
        AddressBook book = new AddressBook();

        book.setBlockOnOpen(true);
        book.open();

        Display.getCurrent().dispose();
    }

    protected MenuManager createMenuManager() {
        MenuManager bar = new MenuManager("");

        MenuManager fileMenu = new MenuManager("&File");
        MenuManager helpMenu = new MenuManager("&Help");

        bar.add(fileMenu);
        bar.add(helpMenu);

        fileMenu.add(new NewContactAction(this));
        fileMenu.add(new ExitAction(this));

        helpMenu.add(new AboutAction(this));

        return bar;
    }

    public static void addContact(Contact c) {
        getContactList().add(c);

        Table table = tableViewer.getTable();

        TableItem item = new TableItem(table, SWT.NULL);
        item.setText(0, c.getGivenName() + " " + c.getFamilyName());
        item.setText(1, c.getEmailAddress());
        item.setText(2, c.getBusinessPhone());
        item.setText(3, c.getHomePhone());
    }

    public static ArrayList getContactList() {
        return contactList;
    }

    public static TableViewer getTbv() {
        return tableViewer;
    }

    public static void setContactList(ArrayList list) {
        contactList = list;
    }

    public static void setTbv(TableViewer viewer) {
        tableViewer = viewer;
    }
}
