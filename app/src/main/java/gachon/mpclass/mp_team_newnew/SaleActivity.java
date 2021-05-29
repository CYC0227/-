package gachon.mpclass.mp_team_newnew;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SaleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
    }

    //어댑터
    ListView listView = findViewById(R.id.lv_comment_view);

    class MyAdapter extends BaseAdapter {
        private ArrayList<MyItem> items = new ArrayList<>();
        public void addItem(MyItem item){
            items.add(item);
        }
        @Override public int getCount() {
            return items.size();
        }
        @Override public MyItem getItem(int position) {
            return items.get(position);
        }
        @Override public long getItemId(int position) {
            return position;
        }
        @Override public View getView(final int position, final View convertView, ViewGroup parent) {
            MyItemView view = new MyItemView(getApplicationContext());
            MyItem item = items.get(position);
            view.setId(item.getId());

            return view;
        }
    }
}
