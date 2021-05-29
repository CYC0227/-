package gachon.mpclass.mp_team_newnew;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.form.PostingForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageButton button_kind;
    ImageButton button_mypage;
    ImageButton button_posting;
    ImageButton button_sale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_kind = findViewById(R.id.kind);
        button_posting = findViewById(R.id.posting);
        button_mypage = findViewById(R.id.mypage);
        button_sale = findViewById(R.id.sale);


        RetrofitClient retrofitClient = new RetrofitClient();

        Call<List<PostingForm>> call2;
        call2 = retrofitClient.retrofitService.getPosts("kevin");

        //DB에서 가져온 유저의 모든 포스팅
        List<PostingForm> postingFormList = new ArrayList<>();

        call2.enqueue(new Callback<List<PostingForm>>() {
            @Override
            public void onResponse(Call<List<PostingForm>> call, Response<List<PostingForm>> response) {
                for(PostingForm postingForm: response.body()) {
                    postingFormList.add(postingForm);

                    System.out.println(postingForm.toString());
                }
            }

            @Override
            public void onFailure(Call<List<PostingForm>> call, Throwable t) {
                System.out.println(t.getMessage());
                Log.d("tag4","실패" + t.getMessage());
            }
        });



        button_kind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // main -> new
                Intent myintent = new Intent(getApplicationContext(), ClassificationActivity.class);
                startActivityForResult(myintent, 1);
            }
        });

        button_posting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // main -> new
                Intent myintent = new Intent(getApplicationContext(), PostingActivity.class);
                startActivityForResult(myintent, 1);
            }
        });

        button_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // main -> new
                Intent myintent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivityForResult(myintent, 1);
            }
        });

        button_sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // main -> new
                Intent myintent = new Intent(getApplicationContext(), SaleActivity.class);
                startActivityForResult(myintent, 1);
            }
        });
    }
}
