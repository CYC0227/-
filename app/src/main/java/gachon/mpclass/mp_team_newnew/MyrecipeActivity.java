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

    static List<Bitmap> imgList = new ArrayList<>();
    static List<PostingForm> postingFormList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrecipe);

//        button_home = findViewById(R.id.home);
//        button_kind = findViewById(R.id.kind);
//        button_posting = findViewById(R.id.posting);
//        button_mypage = findViewById(R.id.mypage);





        ListView listView = (ListView) findViewById(R.id.listview);



        MyrecipeAdapter adapter = new MyrecipeAdapter(this, R.layout.myrecipe_item, postingFormList, imgList);

        listView.setAdapter(adapter);

        /* 아이템 클릭시 작동 */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MyrecipeClicked.class);

                System.out.println("111111111112222222222222222333333333333344444444444444444444444444444444");

                /* putExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값 */
                intent.putExtra("imgURL", imgList.get(position));
                intent.putExtra("title", postingFormList.get(position).getTitle());
                intent.putExtra("description", postingFormList.get(position).getDescription());
                intent.putExtra("information", postingFormList.get(position).getInformation());
                intent.putExtra("ingredients_name", postingFormList.get(position).getIngredients_name());
                intent.putExtra("ingredients_quantity", postingFormList.get(position).getIngredients_quantity());
                intent.putExtra("ingredients_name2", postingFormList.get(position).getIngredients_name2());
                intent.putExtra("ingredients_quantity2", postingFormList.get(position).getIngredients_quantity2());
                intent.putExtra("ingredients_name3", postingFormList.get(position).getIngredients_name3());
                intent.putExtra("ingredients_quantity3", postingFormList.get(position).getIngredients_quantity3());
                intent.putExtra("ingredients_name4", postingFormList.get(position).getIngredients_name4());
                intent.putExtra("ingredients_quantity4", postingFormList.get(position).getIngredients_quantity4());
                intent.putExtra("ingredients_name5", postingFormList.get(position).getIngredients_name5());
                intent.putExtra("ingredients_quantity5", postingFormList.get(position).getIngredients_quantity5());
                intent.putExtra("anniversary", postingFormList.get(position).getAnniversary());
                intent.putExtra("country", postingFormList.get(position).getCountry());
                intent.putExtra("videoURL", postingFormList.get(position).getVideoURL());
                startActivity(intent);
            }
        });


//        button_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // main -> new
//                Intent myintent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivityForResult(myintent, 1);
//            }
//        });
//
//        button_kind.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // main -> new
//                Intent myintent = new Intent(getApplicationContext(), ClassificationActivity.class);
//                startActivityForResult(myintent, 1);
//            }
//        });
//
//        button_posting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //main -> new
//                Intent myintent = new Intent(getApplicationContext(), PostingActivity.class);
//                startActivityForResult(myintent, 1);
//
//            }
//        });
//
//        button_mypage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // main -> new
//                Intent myintent = new Intent(getApplicationContext(), MypageActivity.class);
//                startActivityForResult(myintent, 1);
//            }
//        });
    }

    @Override
    public void onClick(View v) {

    }
}
