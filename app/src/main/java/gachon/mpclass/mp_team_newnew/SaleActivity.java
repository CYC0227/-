package gachon.mpclass.mp_team_newnew;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.api.MyGeoCoder;
import gachon.mpclass.mp_team_newnew.form.PostingForm;
import gachon.mpclass.mp_team_newnew.form.TodaySaleForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaleActivity extends AppCompatActivity {
    ImageButton btn_inform;
    ImageButton btn_address;

    private String str;
    private String address ="";

    private boolean clicked = false;


    static List<TodaySaleForm> saleFormList = new ArrayList<>();
    RetrofitClient retrofitClient = new RetrofitClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);

        // 들어오자마자 기록되어있는 동네특가 정보 확인 가능
        SaleAdapter adapter = new SaleAdapter(this, R.layout.sale_item, saleFormList);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        // 본인 주소 찾기 버튼 (find my location)
        btn_address = (ImageButton) findViewById(R.id.btn_address);
        btn_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyGeoCoder myGeoCoder = new MyGeoCoder(SaleActivity.this);
                str = myGeoCoder.getAddress(); // 데이터베이스의 address (실제)
                String[] addresses = str.split(" ");
                address = addresses[3] + " " + addresses[4]; // 데이터베이스의 address_around (자른 값)

                SalePostingActivity.address_found = str;
                SalePostingActivity.address_around_found = address;

                System.out.println("@@@address_around_found = " + address);

                Toast.makeText(getApplicationContext(), "현재 나의 위치 : " + str, Toast.LENGTH_LONG).show();
                clicked = true;
                // Log.d("rev", address);


                //test
                Call<List<TodaySaleForm>> callTodaySaleList;
                callTodaySaleList = retrofitClient.retrofitService.getTodaySalesAround(address);

                callTodaySaleList.enqueue(new Callback<List<TodaySaleForm>>() {
                    @Override
                    public void onResponse(Call<List<TodaySaleForm>> call, Response<List<TodaySaleForm>> response) {
                        for (TodaySaleForm todaySaleForm : response.body()) {
                            saleFormList.add(todaySaleForm);

                            System.out.println("postingForm = " + todaySaleForm);
                            System.out.println("@22#313213131233133131313!!!");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TodaySaleForm>> call, Throwable t) {
                        Log.d("TAG", "Today Sale Error: " + t.getLocalizedMessage());

                    }
                });
            }
        });

        // information 추가하기 버튼
        btn_inform = (ImageButton) findViewById(R.id.btn_inform);
        btn_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(clicked == false){
                    Toast.makeText(getApplicationContext(), "'find my location'을 눌러 현재 위치를 확인해주세요! ", Toast.LENGTH_LONG).show();
                    return;
                }
                // information 입력하는 activity로 이동 ( SalePostingActivity )
                Intent myintent = new Intent(getApplicationContext(), SalePostingActivity.class);

                myintent.putExtra("address", str);
                myintent.putExtra("address_around", address);

                startActivityForResult(myintent, 1);
            }
        });
    }

    // SalePostingActivity에서 정보입력 완료 후 다시 돌아왔을 때 실행 : listview 뿌려줌
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                //어댑터
                SaleAdapter adapter = new SaleAdapter(this, R.layout.sale_item, saleFormList);
                ListView listView = findViewById(R.id.listview);
                listView.setAdapter(adapter);

                Toast.makeText(getApplicationContext(), " 동네특가 등록 성공! ", Toast.LENGTH_LONG).show();
            }
        }
    }
}