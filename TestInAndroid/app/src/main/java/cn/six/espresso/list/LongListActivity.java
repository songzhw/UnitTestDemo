package cn.six.espresso.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import cn.six.espresso.aut.R;


public class LongListActivity extends Activity {

    public static final int NUMBER_OF_ITEMS = 100;

    public static final String ITEM_TEXT_FORMAT = "item: %d";

    private List<ItemData> data = new ArrayList<ItemData>();

    private LayoutInflater layoutInflater;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_long_list);
        populateData();

        layoutInflater = getLayoutInflater();
        ListView listView = (ListView) findViewById(R.id.lv_list);
        ListAdapter adapter = new LongListAdapter();
        listView.setAdapter(adapter);

    }

    private void populateData() {
        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            ItemData d = new ItemData();
            if(i == 1) { d.isOpen = true; } else  { d.isOpen = false;}
            d.name = String.format(ITEM_TEXT_FORMAT, i);
            data.add(d);
        }
    }

    private class LongListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return data.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (null == convertView) {
                convertView = layoutInflater.inflate(R.layout.item_list, null);
                holder = new ViewHolder();
                holder.tv = (TextView) convertView. findViewById(R.id.tv_list_item);
                holder.tb = (ToggleButton) convertView.findViewById(R.id.tb_list_item);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            ItemData d = data.get(position);
            holder.tv.setText(d.name);
            holder.tb.setChecked(d.isOpen);

            // 有ToggleButton在， 会让OnItemClickListener失效。所以点击写在这。
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((TextView) findViewById(R.id.tv_list_selection_row_value))
                            .setText( String.valueOf(position));
                }
            });
            return convertView;
        }

        private class ViewHolder{
            public TextView tv;
            public ToggleButton tb;
        }

    }

}
