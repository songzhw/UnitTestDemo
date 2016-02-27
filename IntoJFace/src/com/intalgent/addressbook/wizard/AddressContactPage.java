package com.intalgent.addressbook.wizard;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class AddressContactPage extends WizardPage
{
    private static String[] STATES = 
    {
        "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
        "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia",
        "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
        "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
        "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
        "New England", "New Hampshire", "New Jersey", "New Mexico", "New York",
        "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
        "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
        "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
        "West Virginia", "Wisconsin", "Wyoming"
    };
    private Text addressLine1Text;
    private Text addressLine2Text;
    private Text cityText;
    private Text zipCodeText;
    private Combo stateCombo;
    private ISelection selection;
    private boolean isDisplaySet = false;

    public AddressContactPage(ISelection selection)
    {
        super("wizardPage");
        setTitle("New Contact");
        setDescription("This wizard creates a new contact.");
        this.selection = selection;
    }

    public void createControl(Composite parent)
    {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
        layout.verticalSpacing = 9;

        Label label = new Label(container, SWT.NULL);
        label.setText("&Address Line 1:");

        addressLine1Text = new Text(container, SWT.BORDER | SWT.MULTI);

        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        addressLine1Text.setLayoutData(gd);
        addressLine1Text.addModifyListener(new ModifyListener()
            {
                public void modifyText(ModifyEvent e)
                {
                    dialogChanged();
                }
            });

        label = new Label(container, SWT.NULL);
        label.setText("&Address Line 2:");

        addressLine2Text = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        addressLine2Text.setLayoutData(gd);
        addressLine2Text.addModifyListener(new ModifyListener()
            {
                public void modifyText(ModifyEvent e)
                {
                    dialogChanged();
                }
            });

        label = new Label(container, SWT.NULL);
        label.setText("&City:");

        cityText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        cityText.setLayoutData(gd);

        label = new Label(container, SWT.NULL);
        label.setText("&State:");

        stateCombo = new Combo(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        stateCombo.setLayoutData(gd);
        stateCombo.setItems(STATES);

        label = new Label(container, SWT.NULL);
        label.setText("&Zip Code:");

        zipCodeText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        zipCodeText.setLayoutData(gd);

        //dialogChanged();
        setControl(container);
    }

    private void dialogChanged()
    {
        if (this.getGivenName().length() == 0)
        {
            updateStatus("Given name must be specified.");

            return;
        }

        if (this.getFamilyName().length() == 0)
        {
            updateStatus("Family name must be specified.");

            return;
        }

        updateStatus(null);
    }

    private void updateStatus(String message)
    {
        setErrorMessage(message);
        setPageComplete(message == null);
    }

    public String getFamilyName()
    {
        return addressLine2Text.getText();
    }

    public String getGivenName()
    {
        return addressLine1Text.getText();
    }

    public String getNickName()
    {
        return cityText.getText();
    }

    public String getBusinessPhone()
    {
        return zipCodeText.getText();
    }

    public void setNickName(String name)
    {
        cityText.setText(name);
    }

    private void createLine(Composite parent, int ncol)
    {
        Label line = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL |
                SWT.BOLD);
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.horizontalSpan = ncol;
        line.setLayoutData(gridData);
    }
}
