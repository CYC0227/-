package gachon.mpclass.mp_team_newnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import gachon.mpclass.mp_team_newnew.form.PostingForm;
import gachon.mpclass.mp_team_newnew.form.TodaySaleForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalePostingActivity extends AppCompatActivity {
    private ListView listView;
    private ListAdapter adapter;
    private EditText info;
    private TextView address;

    private ImageButton btn_save;

    public static String session_email = "kevin";//로그인 되는 순간 생성되야함. LoginActivity로 이동 필요

    RetrofitClient retrofitClient = new RetrofitClient();

    Call<TodaySaleForm> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_posting);

        // 뷰 참조
        listView = (ListView) findViewById(R.id.listview);
        btn_save = (ImageButton) findViewById(R.id.submit);

        address = (TextView) findViewById(R.id.edit_address);
        info = (EditText) findViewById(R.id.edit_description);

        // address 누르면, 가게 주소 가져오게 함
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextView 클릭될 시 할 코드작성
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                TodaySaleForm form = new TodaySaleForm();
//
//                form.setInfo(info.getText().toString());
//                form.setAddress(address.getText().toString());
//
//                call = retrofitClient.retrofitService.postTodaySale(form);
//
//                call.enqueue(new Callback<TodaySaleForm>() {
//                    @Override
//                    public void onResponse(Call<TodaySaleForm> call, Response<TodaySaleForm> response) {
//                        if(response.isSuccessful()){
//                            TodaySaleForm result = response.body();
//
//                            Log.d("tag1","성공" + result.toString());
//                        }
//                        else{
//                            Log.d("tag2","실패");
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<TodaySaleForm> call, Throwable t) {
//                        Log.d("tag3","실패" + t.getMessage());
//                    }
//                });

//                // 입력 완료 후 다시 동네특가 페이지로 이동
                finish();
//                Intent myintent = new Intent(getApplicationContext(), SaleActivity.class);
//                startActivityForResult(myintent, 1);
            }
        });

    }


}