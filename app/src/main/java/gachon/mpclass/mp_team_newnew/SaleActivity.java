package gachon.mpclass.mp_team_newnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SaleActivity extends AppCompatActivity {
    ImageButton btn_inform;
    ImageButton btn_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);

        //어댑터
        ListView listView = findViewById(R.id.lv_comment_view);
        MyAdapter adapter = new MyAdapter();

        // db에서 정보 가져와서 adapter에 추가해야됨

        // 이건 test

        listView.setAdapter(adapter);

        // 본인 주소 찾기 버튼 (find my location)
        btn_address = (ImageButton)findViewById(R.id.btn_address);
        btn_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 임시로 activity연결시켜놓음. 바꿔야함. ( gps로 본인 위치 가져올 수 있도록 )
                Intent myintent = new Intent(getApplicationContext(), SalePostingActivity.class);
                startActivityForResult(myintent, 1);
            }
        });

        // information 추가하기 버튼
        btn_inform = (ImageButton)findViewById(R.id.btn_inform);
        btn_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // information 입력하는 activity로 이동 ( SalePostingActivity )
                Intent myintent = new Intent(getApplicationContext(), SalePostingActivity.class);
                startActivityForResult(myintent, 1);
            }
        });
    }

    class MyAdapter extends BaseAdapter {
        private ArrayList<MyItem_Sale> items = new ArrayList<>();
        public void addItem(MyItem_Sale item){
            items.add(item);
        }
        @Override public int getCount() {
            return items.size();
        }
        @Override public MyItem_Sale getItem(int position) {
            return items.get(position);
        }
        @Override public long getItemId(int position) {
            return position;
        }
        @Override public View getView(final int position, final View convertView, ViewGroup parent) {
            MyItemView_Sale view = new MyItemView_Sale(getApplicationContext());
            MyItem_Sale item = items.get(position);
            view.setInfo(item.getInfo());
            view.setAddress(item.getAddress());

            return view;
        }
    }
}
