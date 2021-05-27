package gachon.mpclass.mp_team_newnew;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import gachon.mpclass.mp_team_newnew.form.LoginForm;
import gachon.mpclass.mp_team_newnew.form.PostingForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText edit_email;
    EditText edit_password;

    String email;
    String password;

    ImageButton login;


    RetrofitClient retrofitClient = new RetrofitClient();

    Call<Boolean> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_email = (EditText)findViewById(R.id.editTextId);
        edit_password = (EditText)findViewById(R.id.editTextPassword);

        email = edit_email.getText().toString();
        password = edit_password.getText().toString();

        login = (ImageButton)findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                call = retrofitClient.retrofitService.login(email, password);

                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                        Boolean isSuccessful = response.body();

                        if(isSuccessful){
                            //다음 화면으로 넘어가기
                        }
                        else {
                            //오류 토스트 메세지
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        System.out.println(t.getMessage());
                        Log.d("login","실패" + t.getMessage());
                    }
                });

            }
        });
    }
}