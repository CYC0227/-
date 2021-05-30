package gachon.mpclass.mp_team_newnew;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {

    TextView title;
    TextView kind_day;
    TextView kind_country;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        title = findViewById(R.id.title);
        kind_day = findViewById(R.id.text_kind_day);
        kind_country = findViewById(R.id.text_kind_country);

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

    }
}