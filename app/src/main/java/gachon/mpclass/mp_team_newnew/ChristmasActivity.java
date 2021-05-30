package gachon.mpclass.mp_team_newnew;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.form.PostingForm;

public class ChristmasActivity extends AppCompatActivity implements View.OnClickListener   {
    ImageButton heart;
    ImageView box;
    TextView edit_title;
    private ArrayList<PostingForm> data = null;

    static List<Bitmap> imgList2 = new ArrayList<>();
    static List<PostingForm> postingFormList2 = new ArrayList<>();

    //저장된 리스트



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christmas);





        ListView listView = (ListView) findViewById(R.id.listview);



        MyrecipeAdapter adapter = new MyrecipeAdapter(this, R.layout.myrecipe_item, postingFormList2, imgList2);

        listView.setAdapter(adapter);

        /* 아이템 클릭시 작동 */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MyrecipeClicked.class);

                System.out.println("111111111112222222222222222333333333333344444444444444444444444444444444");

                /* putExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값 */
                intent.putExtra("imgURL", imgList2.get(position));
                intent.putExtra("title", postingFormList2.get(position).getTitle());
                intent.putExtra("description", postingFormList2.get(position).getDescription());
                intent.putExtra("information", postingFormList2.get(position).getInformation());
                intent.putExtra("ingredients_name", postingFormList2.get(position).getIngredients_name());
                intent.putExtra("ingredients_quantity", postingFormList2.get(position).getIngredients_quantity());
                intent.putExtra("ingredients_name2", postingFormList2.get(position).getIngredients_name2());
                intent.putExtra("ingredients_quantity2", postingFormList2.get(position).getIngredients_quantity2());
                intent.putExtra("ingredients_name3", postingFormList2.get(position).getIngredients_name3());
                intent.putExtra("ingredients_quantity3", postingFormList2.get(position).getIngredients_quantity3());
                intent.putExtra("ingredients_name4", postingFormList2.get(position).getIngredients_name4());
                intent.putExtra("ingredients_quantity4", postingFormList2.get(position).getIngredients_quantity4());
                intent.putExtra("ingredients_name5", postingFormList2.get(position).getIngredients_name5());
                intent.putExtra("ingredients_quantity5", postingFormList2.get(position).getIngredients_quantity5());
                intent.putExtra("anniversary", postingFormList2.get(position).getAnniversary());
                intent.putExtra("country", postingFormList2.get(position).getCountry());
                intent.putExtra("videoURL", postingFormList2.get(position).getVideoURL());
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