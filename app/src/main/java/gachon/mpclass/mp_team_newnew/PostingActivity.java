package gachon.mpclass.mp_team_newnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.form.FileUploadResponse;
import gachon.mpclass.mp_team_newnew.form.PostingForm;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.form.FileUploadResponse;
import gachon.mpclass.mp_team_newnew.form.PostingForm;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;

public class PostingActivity extends AppCompatActivity {
    private EditText description;
    private EditText information;

    private EditText edt_title;
    private EditText edt_sub;
    private ImageButton btn_submit;
    private ImageView btn_photo;

    private EditText edit_ingredients;
    private EditText edit_ingredients2;
    private EditText edit_ingredients3;
    private EditText edit_ingredients4;
    private EditText edit_ingredients5;

    private EditText edit_ingredients_num;
    private EditText edit_ingredients_num2;
    private EditText edit_ingredients_num3;
    private EditText edit_ingredients_num4;
    private EditText edit_ingredients_num5;

    private Uri filePath;

    private final int GET_GALLERY_IMAGE = 200; // 사진 가져오기 위해 쓰인 코드
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
        edt_title = (EditText) findViewById(R.id.title);
        btn_submit = (ImageButton) findViewById(R.id.submit);
        btn_photo = (ImageView) findViewById(R.id.plus_photo1) ;
        information = (EditText) findViewById(R.id.edit_information);
        description = (EditText) findViewById(R.id.edit_description);
        //
        edit_ingredients = (EditText) findViewById(R.id.edit_ingredients);
        edit_ingredients2 = (EditText) findViewById(R.id.edit_ingredients2);
        edit_ingredients3 = (EditText) findViewById(R.id.edit_ingredients3);
        edit_ingredients4 = (EditText) findViewById(R.id.edit_ingredients4);
        edit_ingredients5 = (EditText) findViewById(R.id.edit_ingredients5);

        edit_ingredients_num = (EditText) findViewById(R.id.edit_ingredients_num);
        edit_ingredients_num2 = (EditText) findViewById(R.id.edit_ingredients_num2);
        edit_ingredients_num3 = (EditText) findViewById(R.id.edit_ingredients_num3);
        edit_ingredients_num4 = (EditText) findViewById(R.id.edit_ingredients_num4);
        edit_ingredients_num5 = (EditText) findViewById(R.id.edit_ingredients_num5);

        // 대문 사진 선택하기 (갤러리 접근)
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //사진 업로드
                String[] proj = { MediaStore.Images.Media.DATA };
                CursorLoader loader = new CursorLoader(getApplicationContext(), filePath, proj, null, null, null);
                Cursor cursor = loader.loadInBackground();
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                String result = cursor.getString(column_index);
                cursor.close();


                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

//                File file = new File(filePath.getPath());
                File file = new File(result);

                RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file);
                MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);


                callPic = retrofitClient.retrofitService.uploadFile(body);


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
                        Log.d("tag3","이미지 업로드 실패" + t.getMessage());
                    }
                });


                PostingForm form = new PostingForm();

                // 추가된 ingredients 정보만큼 돌아야되는데 어떻게 하지?
                form.setTitle(edt_title.getText().toString());
                form.setInformation(information.getText().toString());
                form.setDescription(description.getText().toString());
                form.setImgURL(file.getName());
                // 임의의 ingredients form에 넣어두기
                // 오빠님이 아래 주석한거에 맞게 PostingForm에 ingredients 5개 만들어주시면 됩니다용
//                form.setIngredients_name(edit_ingredients.getText().toString());
//                form.setIngredients_name2(edit_ingredients2.getText().toString());
//                form.setIngredients_name3(edit_ingredients3.getText().toString());
//                form.setIngredients_name4(edit_ingredients4.getText().toString());
//                form.setIngredients_name5(edit_ingredients5.getText().toString());
//
//                form.setIngredients_quantity(edit_ingredients_num.getText().toString());
//                form.setIngredients_quantity2(edit_ingredients_num2.getText().toString());
//                form.setIngredients_quantity3(edit_ingredients_num3.getText().toString());
//                form.setIngredients_quantity4(edit_ingredients_num4.getText().toString());
//                form.setIngredients_quantity5(edit_ingredients_num5.getText().toString());

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



                // 포스팅 성공하면 토스트메시지 + 창 닫아주기
                Toast.makeText(getApplicationContext(), "포스팅 성공!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri selectedImageUri = data.getData();
            filePath = selectedImageUri;
            btn_photo.setImageURI(selectedImageUri);
            btn_photo.setBackgroundColor(00000000);

        }

    }

}