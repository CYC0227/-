package gachon.mpclass.mp_team_newnew;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class PostingActivity extends AppCompatActivity {
    private ListView listView;
    private ListAdapter adapter;

    private EditText edt_title;
    private EditText edt_sub;
    private ImageButton btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        // 뷰 참조
        edt_title = (EditText) findViewById(R.id.edit_ingredients);
        edt_sub = (EditText) findViewById(R.id.edit_ingredients_num);
        btn_add = (ImageButton) findViewById(R.id.plus);
        listView = (ListView) findViewById(R.id.listview);

        adapter = new ListAdapter(PostingActivity.this);
        listView.setAdapter(adapter);

        // 데이터 추가하기
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem(edt_title.getText().toString(), edt_sub.getText().toString());
                edt_title.setText("");
                edt_sub.setText("");

                adapter.notifyDataSetChanged();

            }
        });

    }

}
