package gachon.mpclass.mp_team_newnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import gachon.mpclass.mp_team_newnew.form.TodaySaleForm;
import retrofit2.Call;

public class SalePostingActivity extends AppCompatActivity {
    private ListView listView;
    private ListAdapter adapter;
    private EditText info;
    private EditText address;

    private ImageButton btn_save;

    public static String session_email = "kevin";//로그인 되는 순간 생성되야함. LoginActivity로 이동 필요

    RetrofitClient retrofitClient = new RetrofitClient();

    Call<TodaySaleForm> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        // 뷰 참조
        listView = (ListView) findViewById(R.id.listview);
        btn_save = (ImageButton) findViewById(R.id.submit);

        address = (EditText) findViewById(R.id.edit_information);
        info = (EditText) findViewById(R.id.edit_description);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TodaySaleForm form = new TodaySaleForm();

                form.setInformation(address.getText().toString());
                form.setDescription(info.getText().toString());
            }
        });

    }


}
