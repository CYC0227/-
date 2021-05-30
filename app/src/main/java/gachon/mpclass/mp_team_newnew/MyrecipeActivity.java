package gachon.mpclass.mp_team_newnew;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.form.FileUploadResponse;
import gachon.mpclass.mp_team_newnew.form.PostingForm;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyrecipeActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton button_home;
    ImageButton button_kind;
    ImageButton button_posting;
    ImageButton button_mypage;

    RetrofitClient retrofitClient = new RetrofitClient();

    List<Bitmap> imgList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrecipe);

        button_home = findViewById(R.id.home);
        button_kind = findViewById(R.id.kind);
        button_posting = findViewById(R.id.posting);
        button_mypage = findViewById(R.id.mypage);



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

//image download

        for (PostingForm postingForm: postingFormList) {
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




        ListView listView = (ListView) findViewById(R.id.listview);


        MyrecipeAdapter adapter = new MyrecipeAdapter(this, R.layout.myrecipe_item, postingFormList, imgList);

        listView.setAdapter(adapter);

        /* 아이템 클릭시 작동 */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MyrecipeClicked.class);

                /* putExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값 */
                intent.putExtra("imgURL", imgList.get(position));
                intent.putExtra("title", postingFormList.get(position).getTitle());
                intent.putExtra("description", postingFormList.get(position).getDescription());
                intent.putExtra("information", postingFormList.get(position).getInformation());
                intent.putExtra("ingredients_name", postingFormList.get(position).getIngredients_name());
                intent.putExtra("ingredients_quantity", postingFormList.get(position).getIngredients_quantity());
                intent.putExtra("anniversary", postingFormList.get(position).getAnniversary());
                intent.putExtra("country", postingFormList.get(position).getCountry());
                intent.putExtra("videoURL", postingFormList.get(position).getVideoURL());
                startActivity(intent);
            }
        });


        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // main -> new
                Intent myintent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(myintent, 1);
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
                //main -> new
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
    }

    @Override
    public void onClick(View v) {

    }
}
