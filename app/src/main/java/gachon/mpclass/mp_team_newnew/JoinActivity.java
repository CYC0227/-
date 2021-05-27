package gachon.mpclass.mp_team_newnew;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.ZoneId;

import gachon.mpclass.mp_team_newnew.form.MemberForm;
import gachon.mpclass.mp_team_newnew.form.PostingForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JoinActivity extends AppCompatActivity {
    EditText edit_name;
    EditText edit_email;
    EditText edit_password;

    String name;
    String email;
    String password;

    ImageButton join;


    RetrofitClient retrofitClient = new RetrofitClient();
    Call<MemberForm> call;

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
                MemberForm form = new MemberForm();
                form.setEmail(edit_email.getText().toString());
                form.setName(edit_name.getText().toString());
                form.setPw(edit_password.getText().toString());

                call = retrofitClient.retrofitService.joinMember(form);

                call.enqueue(new Callback<MemberForm>() {
                    @Override
                    public void onResponse(Call<MemberForm> call, Response<MemberForm> response) {
                        if(response.isSuccessful()){
                            MemberForm result = response.body();
                            Log.d("tag1","성공" + result.toString());

                            Toast.makeText(getApplicationContext(), "로그인 성공!", Toast.LENGTH_LONG).show();
                            // join -> login ( 성공하면 로그인 창으로 이동 )
                            Intent myintent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivityForResult(myintent, 1);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "이미 가입된 이메일입니다.", Toast.LENGTH_LONG).show();
                            Log.d("tag2","실패");
                        }
                    }


                    @Override
                    public void onFailure(Call<MemberForm> call, Throwable t) {
                        Log.d("tag3","실패" + t.getMessage());
                    }
                });
            }
        });
    }
}