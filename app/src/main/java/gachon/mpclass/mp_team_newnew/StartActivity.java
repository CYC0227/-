package gachon.mpclass.mp_team_newnew;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    ImageButton login;
    ImageButton signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        login = findViewById(R.id.loginButton);
        signup = findViewById(R.id.signButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // start -> login
                Intent myintent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivityForResult(myintent, 1);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // start -> join
                Intent myintent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivityForResult(myintent, 1);
            }
        });
    }
}