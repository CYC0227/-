package gachon.mpclass.mp_team_newnew;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import gachon.mpclass.mp_team_newnew.form.PostingForm;

public class PostingActivity extends AppCompatActivity {
    private ListView listView;
    private ListAdapter adapter;
    private EditText title;
    private EditText description;
    private EditText information;

    private EditText edt_title;
    private EditText edt_sub;
    private ImageButton btn_add;
    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        // 뷰 참조
        edt_title = (EditText) findViewById(R.id.edit_ingredients);
        edt_sub = (EditText) findViewById(R.id.edit_ingredients_num);
        btn_add = (ImageButton) findViewById(R.id.plus);
        listView = (ListView) findViewById(R.id.listview);
        btn_submit = (Button)findViewById(R.id.submit);

        information = (EditText) findViewById(R.id.edit_information);
        description = (EditText) findViewById(R.id.edit_description);
        title = (EditText) findViewById(R.id.title);



        adapter = new ListAdapter(PostingActivity.this);
        listView.setAdapter(adapter);

        // 재료 추가하기
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem(edt_title.getText().toString(), edt_sub.getText().toString());
                edt_title.setText("");
                edt_sub.setText("");

                adapter.notifyDataSetChanged();

            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostingForm form = new PostingForm();
                form.setTitle(edt_title.getText().toString());
                form.setInformation(information.getText().toString());
                form.setDescription(description.getText().toString());

                btn_submit = (Button)findViewById(R.id.submit);
//form으로 완성된 데이터를 어떻게 서버와 주고받을지 찾아야함
            }
        });

    }

}
