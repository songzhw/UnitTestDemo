package com.intalgent.addressbook.wizard;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class BasicContactPage extends WizardPage {
    private Text givenNameText;
    private Text familyNameText;
    private Text nickNameText;
    private Text businessPhoneText;
    private Text homePhoneText;
    private Text emailText;
    private ISelection selection;

    public BasicContactPage(ISelection selection) {
        super("wizardPage");
        setTitle("New Contact");
        setDescription("This wizard creates a new contact.");
        this.selection = selection;
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
        layout.verticalSpacing = 9;

        Label label = new Label(container, SWT.NULL);
        label.setText("&Given Name:");

        givenNameText = new Text(container, SWT.BORDER | SWT.SINGLE);

        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        givenNameText.setLayoutData(gd);
        givenNameText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        label = new Label(container, SWT.NULL);
        label.setText("&Family Name:");

        familyNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        familyNameText.setLayoutData(gd);
        familyNameText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        label = new Label(container, SWT.NULL);
        label.setText("&Nickname:");

        nickNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        nickNameText.setLayoutData(gd);

        createLine(container, layout.numColumns);

        label = new Label(container, SWT.NULL);
        label.setText("&Business Phone:");

        businessPhoneText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        businessPhoneText.setLayoutData(gd);

        label = new Label(container, SWT.NULL);
        label.setText("&Home Phone:");

        homePhoneText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        homePhoneText.setLayoutData(gd);

        createLine(container, layout.numColumns);

        label = new Label(container, SWT.NULL);
        label.setText("&E-Mail Address:");

        emailText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        emailText.setLayoutData(gd);
        emailText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        //dialogChanged();
        setControl(container);
    }

    private void dialogChanged() {
        if (this.getGivenName().length() == 0) {
            updateStatus("Given name must be specified.");

            return;
        }

        if (this.getFamilyName().length() == 0) {
            updateStatus("Family name must be specified.");

            return;
        }

        if (this.getEmail().length() > 0) {
            if (this.getEmail().indexOf("@") < 0) {
                updateStatus(
                        "Please enter a complete email address in the form yourname@yourdomain.com");

                return;
            }
        }

        updateStatus(null);
    }

    private void updateStatus(String message) {
        setErrorMessage(message);
        setPageComplete(message == null);
    }

    public String getFamilyName() {
        return familyNameText.getText();
    }

    public String getGivenName() {
        return givenNameText.getText();
    }

    public String getNickName() {
        return nickNameText.getText();
    }

    public String getBusinessPhone() {
        return businessPhoneText.getText();
    }

    public String getHomePhone() {
        return homePhoneText.getText();
    }

    public String getEmail() {
        return emailText.getText();
    }

    public void setNickName(String name) {
        nickNameText.setText(name);
    }

    private void createLine(Composite parent, int ncol) {
        Label line = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL |
                SWT.BOLD);
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.horizontalSpan = ncol;
        line.setLayoutData(gridData);
    }
}
