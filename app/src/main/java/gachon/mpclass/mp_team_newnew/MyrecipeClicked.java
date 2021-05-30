package gachon.mpclass.mp_team_newnew;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyrecipeClicked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* xml과 연결 */
        setContentView(R.layout.item_clicked);

        Intent intent = getIntent();

        ImageView imgURL = (ImageView) findViewById(R.id.img_prof);
        TextView view_title=(TextView) findViewById(R.id.title);
        TextView day=(TextView) findViewById(R.id.text_kind_day);
        TextView kind=(TextView) findViewById(R.id.text_kind_country);
        TextView description=(TextView) findViewById(R.id.text_description);
        TextView information=(TextView) findViewById(R.id.text_information);
        TextView ing_num=(TextView) findViewById(R.id.edit_ingredients_num);
        TextView ing_name=(TextView) findViewById(R.id.edit_ingredients);


        imgURL.setImageBitmap(intent.getParcelableExtra("imgURL"));
        view_title.setText(intent.getStringExtra("title"));
        day.setText(intent.getStringExtra("anniversary"));
        kind.setText(intent.getStringExtra("country"));
        description.setText(intent.getStringExtra("description"));
        information.setText(intent.getStringExtra("information"));
        ing_num.setText(intent.getStringExtra("ingredients_quantity"));
        ing_name.setText(intent.getStringExtra("ingredients_name"));

    }
}
