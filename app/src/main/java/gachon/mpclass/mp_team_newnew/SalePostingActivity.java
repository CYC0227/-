package gachon.mpclass.mp_team_newnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.form.TodaySaleForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalePostingActivity extends AppCompatActivity {
    private EditText info;
    private TextView address_store;

    private ImageButton btn_save;

    public static String session_email = "kevin";//로그인 되는 순간 생성되야함. LoginActivity로 이동 필요

    //미사용중
    private String address;
    private String address_around;

    //사용중
    static String address_found;
    static String address_around_found;

    static List<TodaySaleForm> todaySaleForms = new ArrayList<>();

    RetrofitClient retrofitClient = new RetrofitClient();

    Call<TodaySaleForm> callTodaySale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_posting);

        Intent intent = getIntent();    // address, address_around 받아옴

        address = intent.getStringExtra("address");
        address_around = intent.getStringExtra("address_around");
        
        btn_save = (ImageButton) findViewById(R.id.submit);

        address_store = (TextView) findViewById(R.id.edit_address);        // address 누르면, 가게 주소 가져오게 함
        info = (EditText) findViewById(R.id.edit_description);

        address_store.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TextView 클릭될 시 할 코드작성 ( 지도 띄워서 사용자가 가게 이름 입력한 후에 주소 받아올 수 있도록해서 받아온 한글주소를 textview에 저장  )
                
                /* 이 부분에 저장해줘
                info = ;
                address_store = ;
                */
                
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TodaySaleForm form = new TodaySaleForm();

                form.setInfo(info.getText().toString());
                form.setStore_address(address_store.getText().toString());
                form.setAddress(address_found);

                form.setAddress_around(address_around_found);
                System.out.println("@@@address_around_found 2 = " + address_around_found);

                callTodaySale = retrofitClient.retrofitService.postTodaySale(form);

                callTodaySale.enqueue(new Callback<TodaySaleForm>() {
                    @Override
                    public void onResponse(Call<TodaySaleForm> call, Response<TodaySaleForm> response) {
                        if(response.isSuccessful()){
                            TodaySaleForm result = response.body();

                            Log.d("tag1","성공" + result.toString());
                        }
                        else{
                            Log.d("tag2","실패");
                        }

                        /* 크리스마스때처럼 스레드땜에 오류나는거면 맨밑에꺼 주석하고 이 주석 활성화해보셈
                        // 입력 완료 후 다시 동네특가 페이지로 이동
                        setResult(RESULT_OK);
                        finish();
                         */
                    }

                    @Override
                    public void onFailure(Call<TodaySaleForm> call, Throwable t) {
                        Log.d("tag3","실패" + t.getMessage());
                    }
                });

                // 입력 완료 후 다시 동네특가 페이지로 이동
                setResult(RESULT_OK);
                finish();
            }
        });

    }




}
