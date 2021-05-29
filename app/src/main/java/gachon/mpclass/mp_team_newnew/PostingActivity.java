package gachon.mpclass.mp_team_newnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.form.FileUploadResponse;
import gachon.mpclass.mp_team_newnew.form.PostingForm;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;

public class PostingActivity extends AppCompatActivity {
    private ListView listView;
    private ListAdapter adapter;
    private EditText main_title;
    private EditText description;
    private EditText information;

    private EditText edt_title;
    private EditText edt_sub;
    private ImageButton btn_add;
    private ImageButton btn_submit;

    public static String session_email = "kevin";//로그인 되는 순간 생성되야함. LoginActivity로 이동 필요

    RetrofitClient retrofitClient = new RetrofitClient();

    Call<PostingForm> call;
    Call<FileUploadResponse> callPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        // spinner
        Spinner spi_day = findViewById(R.id.spinner_day);
        //final String kind_day = spi_day.getSelectedItem().toString();

        Spinner spi_country = findViewById(R.id.spinner_country);
        //final String kind_country = spi_country.getSelectedItem().toString();

        // 뷰 참조
        edt_title = (EditText) findViewById(R.id.edit_ingredients);
        edt_sub = (EditText) findViewById(R.id.edit_ingredients_num);
        btn_add = (ImageButton) findViewById(R.id.plus);
        listView = (ListView) findViewById(R.id.listview);
        btn_submit = (ImageButton) findViewById(R.id.submit);

        information = (EditText) findViewById(R.id.edit_information);
        description = (EditText) findViewById(R.id.edit_description);
        main_title = (EditText) findViewById(R.id.title);

        adapter = new ListAdapter(PostingActivity.this);
        listView.setAdapter(adapter);

        // 재료 추가하기
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem(edt_title.getText().toString(), edt_sub.getText().toString());

                edt_title.setText(edt_title.getText().toString());
                edt_sub.setText(edt_sub.getText().toString());
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostingForm form = new PostingForm();

                // 추가된 ingredients 정보만큼 돌아야되는데 어떻게 하지?
                form.setTitle(edt_title.getText().toString());
                form.setInformation(information.getText().toString());
                form.setDescription(description.getText().toString());

                call = retrofitClient.retrofitService.setPostBody(form, session_email);

                call.enqueue(new Callback<PostingForm>() {
                    @Override
                    public void onResponse(Call<PostingForm> call, Response<PostingForm> response) {
                        if(response.isSuccessful()){
                            PostingForm result = response.body();

                            Log.d("tag1","성공" + result.toString());
                        }
                            else{
                                Log.d("tag2","실패");
                            }
                    }

                    @Override
                    public void onFailure(Call<PostingForm> call, Throwable t) {
                    Log.d("tag3","실패" + t.getMessage());
//서버와 통신가능하지만, 여러 수정필요
                  }
                });

                //사진 업로드

                // Uri 타입의 파일경로를 가지는 RequestBody 객체 생성
                Uri filePath = new Uri();
                RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), Uri filePath);

// RequestBody로 Multipart.Part 객체 생성
                MultipartBody.Part filePart = Multipart.Part.createFormData("photo", "photo.jpg", fileBody);

                callPic = retrofitClient.retrofitService.uploadFile(filePart);


                callPic.enqueue(new Callback<FileUploadResponse>() {
                    @Override
                    public void onResponse(Call<FileUploadResponse> call, Response<FileUploadResponse> response) {
                        if(response.isSuccessful()){
                            FileUploadResponse result = response.body();

                            Log.d("tag1","성공" + result.toString());
                        }
                        else{
                            Log.d("tag2","실패");
                        }
                    }

                    @Override
                    public void onFailure(Call<FileUploadResponse> call, Throwable t) {
                        Log.d("tag3","실패" + t.getMessage());
                    }
                });
//
//                //intent (bundle로 싸서) - posting -> post
//                // change form to string
//                String set_title = main_title.getText().toString();
//                String set_description = description.getText().toString();
//                String set_information = information.getText().toString();
//                final String kind_day = spi_day.getSelectedItem().toString();
//                final String kind_country = spi_country.getSelectedItem().toString();
//                // make bundle
//                Bundle bun = new Bundle();
//                bun.putString("title",set_title);
//                bun.putString("kind_day",kind_day);
//                bun.putString("kind_country",kind_country);
//                bun.putString("description",set_description);
//                bun.putString("information",set_information);
//
//                Intent intent = new Intent(getApplicationContext(), PostActivity.class);
//                intent.putExtras(bun);
//                startActivityForResult(intent,1);


                //test
                Call<List<PostingForm>> call2;
                call2 = retrofitClient.retrofitService.getPosts("demouser");
//
//                call2.enqueue(new Callback<PostingForm>() {
//                    @Override
//                    public void onResponse(Call<PostingForm> call, Response<PostingForm> response) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<PostingForm> call, Throwable t) {
//
//                    }
//                });

                call2.enqueue(new Callback<List<PostingForm>>() {
                    @Override
                    public void onResponse(Call<List<PostingForm>> call, Response<List<PostingForm>> response) {
                        for(PostingForm postingForm: response.body()) {
                            System.out.println(postingForm.toString());
                            System.out.println("aaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbb");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PostingForm>> call, Throwable t) {
                        System.out.println(t.getMessage());
                        Log.d("tag4","실패" + t.getMessage());
                    }
                });


                //test
            }
        });

    }


}
