package gachon.mpclass.mp_team_newnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import gachon.mpclass.mp_team_newnew.form.PostingForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    RetrofitClient retrofitClient = new RetrofitClient();

    Call<PostingForm> call;

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
        btn_submit = (ImageButton)findViewById(R.id.submit);

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
                edt_title.setText("");
                edt_sub.setText("");

                adapter.notifyDataSetChanged();

            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostingForm form = new PostingForm();
                form.setTitle(edt_title.getText().toString());
                form.setInformation(information.getText().toString());
                form.setDescription(description.getText().toString());

                call = retrofitClient.retrofitService.setPostBody(form);

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




            //intent (bundle로 싸서) - posting -> post
                // change form to string
                String set_title = main_title.getText().toString();
                String set_description = description.getText().toString();
                String set_information = information.getText().toString();
                final String kind_day = spi_day.getSelectedItem().toString();
                final String kind_country = spi_country.getSelectedItem().toString();
                // make bundle
                Bundle bun = new Bundle();
                bun.putString("title",set_title);
                bun.putString("kind_day",kind_day);
                bun.putString("kind_country",kind_country);
                bun.putString("description",set_description);
                bun.putString("information",set_information);

                Intent intent = new Intent(getApplicationContext(), PostActivity.class);
                intent.putExtras(bun);
                startActivityForResult(intent,1);

            }
        });

    }

}
