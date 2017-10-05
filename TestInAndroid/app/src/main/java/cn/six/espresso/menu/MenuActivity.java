package cn.six.espresso.menu;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;

import cn.six.aut.R;

/**
 * Shows MenuActivity with Options menu, Context menu and Popup menu. Click on a menu item changes
 * text of R.id.textMenuResult.
 */
public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // long-click view --> Context Menu
        this.registerForContextMenu(findViewById(R.id.tv_context_menu));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        TextView text = (TextView) findViewById(R.id.tv_menu_result);
        text.setText(item.getTitle());
        return true;
    }

    // ----------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView text = (TextView) findViewById(R.id.tv_menu_result);
        text.setText(item.getTitle());
        return true;
    }



    // ----------------------------------------------------------

    // PopupMenu : since API 11
    // this method is called when the button is clicked : android:click="showPopup"
    public void showPopup(View view) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            TextView text = (TextView) findViewById(R.id.tv_menu_result);
            text.setText("Not supported in API " + Build.VERSION.SDK_INT);
        } else {
            PopupMenu popup = new PopupMenu(this, view);
            popup.setOnMenuItemClickListener(new PopupMenuListener());
            popup.getMenuInflater().inflate(R.menu.popupmenu, popup.getMenu());
            popup.show();
        }
    }

    private class PopupMenuListener implements OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            TextView text = (TextView) findViewById(R.id.tv_menu_result);
            text.setText(item.getTitle());
            return true;
        }
    }
}
