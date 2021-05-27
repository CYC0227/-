package gachon.mpclass.mp_team_newnew;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ChristmasActivity extends AppCompatActivity {
    ImageButton heart;
    ImageView box;
    TextView edit_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christmas);

        ListView listView = findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter();

        adapter.addItem(new MyItem("123"));
        adapter.addItem(new MyItem("456"));
        adapter.addItem(new MyItem("789"));

        listView.setAdapter(adapter);
/*
        // 하트 누르기
        heart = (ImageButton) findViewById(R.id.heart);
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //point 점수 10점 더하는 로직
            }
        });*/


/*
//        // 유저들의 list 가져오기
//        List<Posting> postings = new ArrayList<>();
//        postings.getId();
        box = findViewById(R.id.box);
        edit_title = findViewById(R.id.edit_title);

        //그저 테스트용
        List<String> a = new ArrayList();
        a.add("abc");
        a.add("def");

        for (int i=0; i<2; i++){
            box.setImageResource(R.drawable.insta_box);
            heart.setImageResource(R.drawable.insta_heart);
            //edit_title.setText(a.get(i));
            edit_title.setText("abc");
        }


//        // posting에 있는 유저 수만큼 인스타그램 보여주기
//        for (int i=0; i<postings.size(); i++){
//            box.setImageResource(R.drawable.insta_box);
//            heart.setImageResource(R.drawable.insta_heart);
//            edit_title.setText(postings.getTitle(i));
//        }*/

    }

    class MyAdapter extends BaseAdapter {
        private ArrayList<MyItem> items = new ArrayList<>();

        public void addItem(MyItem item) {
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public MyItem getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, final View convertView, ViewGroup parent) {
            MyItemView view = new MyItemView(getApplicationContext());
            MyItem item = items.get(position);
            view.setId(item.getId());
            return view;
        }
    }
}