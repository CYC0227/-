package gachon.mpclass.mp_team_newnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MypageActivity extends AppCompatActivity {

    ImageButton myrecipe;
    ImageButton scrap;

    ImageButton button_home;
    ImageButton button_kind;
    ImageButton button_posting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        myrecipe = findViewById(R.id.toMyRecipe);
        scrap = findViewById(R.id.toScrap);

        button_home = findViewById(R.id.home);
        button_kind = findViewById(R.id.kind);
        button_posting = findViewById(R.id.posting);

        myrecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //main -> new
                Intent myintent = new Intent(getApplicationContext(), MyrecipeActivity.class);
                startActivityForResult(myintent, 1);
            }
        });

        scrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //main -> new
                Intent myintent = new Intent(getApplicationContext(), ScrapActivity.class);
                startActivityForResult(myintent, 1);

            }
        });

        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //main -> new
                Intent myintent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(myintent, 1);

            }
        });

        button_kind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //main -> new
                Intent myintent = new Intent(getApplicationContext(), ClassificationActivity.class);
                startActivityForResult(myintent, 1);

            }
        });

        button_posting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //main -> new
                Intent myintent = new Intent(getApplicationContext(), PostingActivity.class);
                startActivityForResult(myintent, 1);

            }
        });
    }
}
