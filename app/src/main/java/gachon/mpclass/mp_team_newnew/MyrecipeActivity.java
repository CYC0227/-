package gachon.mpclass.mp_team_newnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.form.PostingForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyrecipeActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton button_home;
    ImageButton button_kind;
    ImageButton button_posting;
    ImageButton button_mypage;

    private ArrayList<PostingForm> data = null;
    private ArrayList<PostingForm> data2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrecipe);
//
//        button_home = findViewById(R.id.home);
//        button_kind = findViewById(R.id.kind);
//        button_posting = findViewById(R.id.posting);
//        button_mypage = findViewById(R.id.mypage);
//
//        RetrofitClient retrofitClient = new RetrofitClient();
//        Call<List<PostingForm>> call2;
//        call2 = retrofitClient.retrofitService.getPosts("kevin");
//
//        //DB에서 가져온 유저의 모든 포스팅
//        List<PostingForm> postingFormList = new ArrayList<>();
//
//        call2.enqueue(new Callback<List<PostingForm>>() {
//            @Override
//            public void onResponse(Call<List<PostingForm>> call, Response<List<PostingForm>> response) {
//                for(PostingForm postingForm: response.body()) {
//                    postingFormList.add(postingForm);
//
//                    System.out.println(postingForm.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<PostingForm>> call, Throwable t) {
//                System.out.println(t.getMessage());
//                Log.d("tag4","실패" + t.getMessage());
//            }
//        });

        ListView listView = (ListView) findViewById(R.id.listview);

        data = new ArrayList<>();

        PostingForm item1 = new PostingForm("Image", "title", "야채썰고 볶는다.", "3", "양파","1", "christmas", "India","video");
        PostingForm item2 = new PostingForm("Image2", "title2","야채썰고 볶는다2.", "3", "양파2","1", "christmas", "India","video");

        data.add(item1);
        data.add(item2);


//        data2 = new ArrayList<>();
//        PostingForm post1 = new PostingForm();
//        post1.setTitle("post1");
//        post1.setAnniversary("christmas");
//        post1.setDescription("food");
//        post1.setImg(R.drawable.chicken);
//
//        PostingForm post2 = new PostingForm();
//        post1.setTitle("post2");
//        post1.setAnniversary("christmas2");
//        post1.setDescription("food2");
//        post1.setImg(R.drawable.chicken);
//
//        data2.add(post1);
//        data2.add(post2);
        MyrecipeAdapter adapter = new MyrecipeAdapter(this, R.layout.myrecipe_item, data);

        listView.setAdapter(adapter);

        /* 아이템 클릭시 작동 */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MyrecipeClicked.class);

                /* putExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값 */
                intent.putExtra("profile", data.get(position).getImgURL());
                intent.putExtra("title", data.get(position).getTitle());
                intent.putExtra("description", data.get(position).getDescription());
                intent.putExtra("information", data.get(position).getInformation());
                intent.putExtra("ingredients_name", data.get(position).getIngredients_name());
                intent.putExtra("ingredients_quantity", data.get(position).getIngredients_quantity());
                intent.putExtra("anniversary", data.get(position).getAnniversary());
                intent.putExtra("country", data.get(position).getCountry());

                startActivity(intent);
            }
        });

//
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
