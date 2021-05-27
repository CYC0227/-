package gachon.mpclass.mp_team_newnew;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.time.ZoneId;

public class JoinActivity extends AppCompatActivity {
    EditText edit_name;
    EditText edit_email;
    EditText edit_password;

    String name;
    String email;
    String password;

    ImageButton join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        edit_name = (EditText)findViewById(R.id.editUserName);
        edit_email = (EditText)findViewById(R.id.editTextId);
        edit_password = (EditText)findViewById(R.id.editTextPassword);

        name = edit_name.getText().toString();
        email = edit_email.getText().toString();
        password = edit_password.getText().toString();

        join = (ImageButton)findViewById(R.id.joinButton);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}