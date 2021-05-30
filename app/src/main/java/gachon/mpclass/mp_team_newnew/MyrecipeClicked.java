package gachon.mpclass.mp_team_newnew;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyrecipeClicked extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* xml과 연결 */
        setContentView(R.layout.item_clicked);

        Intent intent = getIntent();

        ImageView profile = (ImageView) findViewById(R.id.img_prof);
        TextView view_title=(TextView) findViewById(R.id.title);
        TextView day=(TextView) findViewById(R.id.text_kind_day);
        TextView kind=(TextView) findViewById(R.id.text_kind_country);
        TextView description=(TextView) findViewById(R.id.text_description);
        TextView ing_num=(TextView) findViewById(R.id.edit_ingredients_num);
        TextView ing_name=(TextView) findViewById(R.id.edit_ingredients);
        TextView ing_num2=(TextView) findViewById(R.id.edit_ingredients_num2);
        TextView ing_name2=(TextView) findViewById(R.id.edit_ingredients2);
        TextView ing_num3=(TextView) findViewById(R.id.edit_ingredients_num3);
        TextView ing_name3=(TextView) findViewById(R.id.edit_ingredients3);
        TextView ing_num4=(TextView) findViewById(R.id.edit_ingredients_num4);
        TextView ing_name4=(TextView) findViewById(R.id.edit_ingredients4);
        TextView ing_num5=(TextView) findViewById(R.id.edit_ingredients_num5);
        TextView ing_name5=(TextView) findViewById(R.id.edit_ingredients5);


        profile.setImageBitmap(intent.getParcelableExtra("imgURL"));
        view_title.setText(intent.getStringExtra("title"));
        day.setText(intent.getStringExtra("anniversary"));
        kind.setText(intent.getStringExtra("country"));
        description.setText(intent.getStringExtra("description"));
        ing_num.setText(intent.getStringExtra("ingredients_quantity"));
        ing_name.setText(intent.getStringExtra("ingredients_name"));
        ing_num2.setText(intent.getStringExtra("ingredients_quantity2"));
        ing_name2.setText(intent.getStringExtra("ingredients_name2"));
        ing_num3.setText(intent.getStringExtra("ingredients_quantity3"));
        ing_name3.setText(intent.getStringExtra("ingredients_name3"));
        ing_num4.setText(intent.getStringExtra("ingredients_quantity4"));
        ing_name4.setText(intent.getStringExtra("ingredients_name4"));
        ing_num5.setText(intent.getStringExtra("ingredients_quantity5"));
        ing_name5.setText(intent.getStringExtra("ingredients_name5"));

        int people_init = Integer.parseInt(intent.getStringExtra("information"));    // 글에 설정된 몇인분인지
        int ing_num_int = Integer.parseInt(intent.getStringExtra("ingredients_quantity"));  // 재료1의 양
        int ing_num_int2 = Integer.parseInt(intent.getStringExtra("ingredients_quantity5"));  // 재료1의 양
        int ing_num_int3 = Integer.parseInt(intent.getStringExtra("ingredients_quantity3"));  // 재료1의 양
        int ing_num_int4 = Integer.parseInt(intent.getStringExtra("ingredients_quantity4"));  // 재료1의 양
        int ing_num_int5 = Integer.parseInt(intent.getStringExtra("ingredients_quantity5"));  // 재료1의 양

        Spinner people_spinner = findViewById(R.id.text_information);
        //final String kind_country = spi_country.getSelectedItem().toString();

        people_spinner.setSelection(people_init-1);

        // spinner에서 재료량 계산을 위한 숫자 선택시 재료량 변환
        people_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int people_after = Integer.parseInt((String) parent.getItemAtPosition(position));

                ing_num.setText(String.valueOf(ing_num_int*people_after/people_init));
                ing_num2.setText(String.valueOf(ing_num_int2*people_after/people_init));
                ing_num3.setText(String.valueOf(ing_num_int3*people_after/people_init));
                ing_num4.setText(String.valueOf(ing_num_int4*people_after/people_init));
                ing_num5.setText(String.valueOf(ing_num_int5*people_after/people_init));
                System.out.println(people_after);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}