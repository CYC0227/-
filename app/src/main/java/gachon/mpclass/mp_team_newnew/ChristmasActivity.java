package gachon.mpclass.mp_team_newnew;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.form.PostingForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChristmasActivity extends AppCompatActivity {
    ImageButton heart;
    ImageView box;
    TextView edit_title;

    RetrofitClient retrofitClient = new RetrofitClient();
    Call<List<PostingForm>> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christmas);

        ListView listView = findViewById(R.id.listview);

        //db에서 가져오는 부분
        String anniv  = "Christmas";
        call = retrofitClient.retrofitService.getPostsByAnniversary(anniv);

        //저장된 리스트
        List<PostingForm> postingFormList = new ArrayList<>();

        call.enqueue(new Callback<List<PostingForm>>() {
            @Override
            public void onResponse(Call<List<PostingForm>> call, Response<List<PostingForm>> response) {
                for(PostingForm postingForm: response.body()) {
                    postingFormList.add(postingForm);

                }
            }

            @Override
            public void onFailure(Call<List<PostingForm>> call, Throwable t) {
                System.out.println(t.getMessage());
                Log.d("tag4","실패" + t.getMessage());
            }
        });


//
//        PostingForm post1 = new PostingForm();
//        post1.setTitle("hello");
//        postingFormList.add(post1);
//
//        PostingForm post2 = new PostingForm();
//        post2.setTitle("hello2");
//        postingFormList.add(post2);
//
//        PostingForm post3 = new PostingForm();
//        post3.setTitle("hello3");
//        postingFormList.add(post3);
//
//        MyAdapter adapter = new MyAdapter();
//        adapter.addItem(new MyItem(postingFormList.get(0).getTitle(),postingFormList.get(0).getImgURL(),postingFormList.get(0).getDescription(),postingFormList.get(0).getIngredients_name(),postingFormList.get(0).getIngredients_quantity(),postingFormList.get(0).getAnniversary(),postingFormList.get(0).getCountry(),postingFormList.get(0).getVideoURL()));
//        adapter.addItem(new MyItem(postingFormList.get(1).getTitle(),postingFormList.get(1).getImgURL(),postingFormList.get(1).getDescription(),postingFormList.get(1).getIngredients_name(),postingFormList.get(1).getIngredients_quantity(),postingFormList.get(1).getAnniversary(),postingFormList.get(1).getCountry(),postingFormList.get(1).getVideoURL()));
//        adapter.addItem(new MyItem(postingFormList.get(2).getTitle(),postingFormList.get(2).getImgURL(),postingFormList.get(2).getDescription(),postingFormList.get(2).getIngredients_name(),postingFormList.get(2).getIngredients_quantity(),postingFormList.get(2).getAnniversary(),postingFormList.get(2).getCountry(),postingFormList.get(2).getVideoURL()));
//
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), postingFormList.get(position).getTitle(), Toast.LENGTH_LONG).show();
//
//                Intent intent = new Intent(getApplicationContext(), PostActivity.class);
//                startActivity(intent);
//            }
//        });


        PostingForm post2 = new PostingForm();
        post2.setTitle("hello2");
        postingFormList.add(post2);

        PostingForm post3 = new PostingForm();
        post3.setTitle("hello3");
        postingFormList.add(post3);

        MyAdapter adapter = new MyAdapter();

        adapter.addItems(postingFormList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), postingFormList.get(position).getTitle(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), PostActivity.class);
                startActivity(intent);
            }
        });

/*
        // 하트 누르기
        heart = (ImageButton) findViewById(R.id.heart);
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //point 점수 10점 더하는 로직
            }
        });*/


    }
    class MyAdapter extends BaseAdapter {
        private List<PostingForm> adapterPostingForms = new ArrayList<>();

        public void addItems(List<PostingForm> postingFormList){
            this.adapterPostingForms = postingFormList;
        }
        @Override
        public int getCount() {
            return adapterPostingForms.size();
        }

        @Override
        public PostingForm getItem(int position) {
            return adapterPostingForms.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, final View convertView, ViewGroup parent) {
            MyItemView view = new MyItemView(getApplicationContext());

            PostingForm form = adapterPostingForms.get(position);
            view.setId(form.getTitle());
            return view;
        }
   }
}