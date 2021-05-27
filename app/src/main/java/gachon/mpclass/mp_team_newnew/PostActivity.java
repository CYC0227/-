package gachon.mpclass.mp_team_newnew;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {

    TextView title;
    TextView kind_day;
    TextView kind_country;
    TextView description;
    TextView information;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        title = findViewById(R.id.title);
        kind_day = findViewById(R.id.text_kind_day);
        kind_country = findViewById(R.id.text_kind_country);
        description = findViewById(R.id.text_description);
        information = findViewById(R.id.text_information);

        //intent
        Intent intent = getIntent();
        if(intent != null){
            Bundle bun = new Bundle();
            bun = intent.getExtras();

            String get_title = bun.getString("title");
            String get_kind_day = bun.getString("kind_day");
            String get_kind_country = bun.getString("kind_country");
            String get_description = bun.getString("description");
            String get_information = bun.getString("information");
            title.setText(get_title);
            kind_day.setText(get_kind_day);
            kind_country.setText(get_kind_country);
            description.setText(get_description);
            information.setText(get_information);
//            title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24) ;
//            title.setText(get_title) ;
//            setContentView(title) ;

            Toast.makeText(getApplicationContext(),
                    "Posting Success ", Toast.LENGTH_LONG).show();

        }

    }
}
