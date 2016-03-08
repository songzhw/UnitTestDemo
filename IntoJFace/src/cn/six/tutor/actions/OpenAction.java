package cn.six.tutor.actions;

import cn.six.tutor.table2.Table2Util;
import cn.six.tutor.table4.ITableSelection;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.program.Program;

import java.io.File;

/**
 * Created by songzhw on 2016/3/7.
 */
public class OpenAction extends Action {
    ITableSelection app;

    public OpenAction(ITableSelection window) {
        app =  window;
        setText("&Open... @Ctrl+O");
        setToolTipText("Open file...");
        setImageDescriptor(Table2Util.getImageDesp("file:images/ic_open_16.png"));
    }

    @Override
    public void run() {
        IStructuredSelection selection = app.getTableSelection();
        if(selection.size() != 1){ return;}

        File selectedFile = (File) selection.getFirstElement();
        if(selectedFile.isFile()){
            Program.launch(selectedFile.getAbsolutePath());
        }
    }

}
