package gachon.mpclass.mp_team_newnew;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.form.PostingForm;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChristmasActivity extends AppCompatActivity implements View.OnClickListener   {
    ImageButton heart;
    ImageView box;
    TextView edit_title;
    private ArrayList<PostingForm> data = null;

    List<Bitmap> imgList = new ArrayList<>();

    RetrofitClient retrofitClient = new RetrofitClient();
    Call<List<PostingForm>> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christmas);

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

    @Override
    public void onClick(View v) {
    }

//    class MyAdapter extends BaseAdapter {
//        private List<PostingForm> adapterPostingForms = new ArrayList<>();
//
//        public void addItems(List<PostingForm> postingFormList){
//            this.adapterPostingForms = postingFormList;
//        }
//        @Override
//        public int getCount() {
//            return adapterPostingForms.size();
//        }
//
//        @Override
//        public PostingForm getItem(int position) {
//            return adapterPostingForms.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(final int position, final View convertView, ViewGroup parent) {
//            MyItemView view = new MyItemView(getApplicationContext());
//
//            PostingForm form = adapterPostingForms.get(position);
//            view.setId(form.getTitle());
//            return view;
//        }
//   }
}