package gachon.mpclass.mp_team_newnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.api.GpsTracker;
import gachon.mpclass.mp_team_newnew.api.WeatherAPI;
import gachon.mpclass.mp_team_newnew.form.PostingForm;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    ImageButton button_kind;
    ImageButton button_mypage;
    ImageButton button_posting;
    ImageButton button_sale;

    ImageButton ranking1;
    ImageButton ranking2;
    ImageButton ranking3;
    ImageButton ranking4;
    ImageButton ranking5;

    List<Bitmap> imgList = new ArrayList<>();
    List<Bitmap> imgList2 = new ArrayList<>();

    List<PostingForm> postingFormList = new ArrayList<>();
    List<PostingForm> postingFormList2 = new ArrayList<>();


    RetrofitClient retrofitClient = new RetrofitClient();
    Call<List<PostingForm>> call;

    GpsTracker gpsTracker;
    WeatherAPI weatherAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_kind = findViewById(R.id.kind);
        button_posting = findViewById(R.id.posting);
        button_mypage = findViewById(R.id.mypage);
        button_sale = findViewById(R.id.sale);


        //db에서 가져오는 부분
        String anniv = "Christmas";
        call = retrofitClient.retrofitService.getPostsByAnniversary(anniv);


        call.enqueue(new Callback<List<PostingForm>>() {
            @Override
            public void onResponse(Call<List<PostingForm>> call, Response<List<PostingForm>> response) {
                for (PostingForm postingForm : response.body()) {
                    postingFormList2.add(postingForm);

                    System.out.println("postingForm = " + postingForm);
                    System.out.println("@@@@@@@@@@@@@@##################@@@@@@@@@@@@@########");
                }
                ChristmasActivity.postingFormList2 = postingFormList2;

                for (PostingForm postingForm : postingFormList2) {
                    String img = postingForm.getImgURL();

                    Call<ResponseBody> callImageDown;
                    callImageDown = retrofitClient.retrofitService.downloadFile(img);

                    callImageDown.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            InputStream is = response.body().byteStream();
                            Bitmap bitmap = BitmapFactory.decodeStream(is);

                            imgList2.add(bitmap);
                            System.out.println("bitmap = " + bitmap);
                            System.out.println("biiit");


                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Log.d("TAG", "Image download error: " + t.getLocalizedMessage());

                        }
                    });

                }

                ChristmasActivity.imgList2 = imgList2;
            }

            @Override
            public void onFailure(Call<List<PostingForm>> call, Throwable t) {
                System.out.println(t.getMessage());
                Log.d("tag4", "실패" + t.getMessage());
                System.out.println("FAIL");

            }


        });


        RetrofitClient retrofitClient = new RetrofitClient();

        Call<List<PostingForm>> call2;
        call2 = retrofitClient.retrofitService.getPosts("kevin");

        //DB에서 가져온 유저의 모든 포스팅

        call2.enqueue(new Callback<List<PostingForm>>() {
            @Override
            public void onResponse(Call<List<PostingForm>> call, Response<List<PostingForm>> response) {
                for (PostingForm postingForm : response.body()) {
                    postingFormList.add(postingForm);

                    System.out.println(" aaaassssssssssssssssssssssssssssssssssssssssssss123123 ");
                    System.out.println(postingForm.toString());
                }

                MyrecipeActivity.postingFormList = postingFormList;

                //image download

                for (PostingForm postingForm : postingFormList) {
                    String img = postingForm.getImgURL();

                    Call<ResponseBody> callImageDown;
                    callImageDown = retrofitClient.retrofitService.downloadFile(img);

                    callImageDown.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            InputStream is = response.body().byteStream();
                            Bitmap bitmap = BitmapFactory.decodeStream(is);

                            imgList.add(bitmap);
                            System.out.println("bitmap = " + bitmap);
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Log.d("TAG", "Image download error: " + t.getLocalizedMessage());
                        }
                    });

                }
                MyrecipeActivity.imgList = imgList;
            }

            @Override
            public void onFailure(Call<List<PostingForm>> call, Throwable t) {
                System.out.println(t.getMessage());
                Log.d("tag4", "실패" + t.getMessage());
            }
        });

        // 가로 스크롤에 가져온 포스팅 5개 정보 채워주기
        ranking1 = (ImageButton) findViewById(R.id.rank1);
        ranking2 = (ImageButton) findViewById(R.id.rank2);
        ranking3 = (ImageButton) findViewById(R.id.rank3);
        ranking4 = (ImageButton) findViewById(R.id.rank4);
        ranking5 = (ImageButton) findViewById(R.id.rank5);

        // 각 사진 누르면 포스트로 넘어가게
        ranking1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostActivity.class);
                // main -> new
                startActivityForResult(intent, 1);
                // 데이터베이스에서 가져온 값을 intent로 넘겨준다.
            }
        });

//
//        //test
//        Call<ResponseBody> callImageDown;
//        callImageDown = retrofitClient.retrofitService.downloadFile(file.getName());
//
//        callImageDown.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                InputStream is = response.body().byteStream();
//                Bitmap bitmap = BitmapFactory.decodeStream(is);
//
//                System.out.println("bitmap = " + bitmap);
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d("TAG", "Image download error: " + t.getLocalizedMessage());
//
//            }
//        });


        //test

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

        // 날씨 파트
        gpsTracker = new GpsTracker(this);
        weatherAPI = new WeatherAPI(this);

        gpsTracker.startLocationService();
        weatherAPI.callCurrentWeather(GpsTracker.latitude, GpsTracker.longitude);
        ImageView recommend = findViewById(R.id.recommend_picture);
        // recommend.setImageResource(R.drawable.rain); <- 이 부분만 수정하여 결과 바꾸면 될 듯
    }
}