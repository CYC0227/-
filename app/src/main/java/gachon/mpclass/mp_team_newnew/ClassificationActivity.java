package gachon.mpclass.mp_team_newnew;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClassificationActivity extends AppCompatActivity {

    ImageButton bt_day;
    ImageButton bt_country;
    DayFragment DayFragment;
    CountryFragment CountryFragment;
    FragmentManager fm;
    FragmentTransaction tran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);

        DayFragment = new DayFragment();
        CountryFragment = new CountryFragment();
        setFrag(0); //fragment change

        bt_day = (ImageButton) findViewById(R.id.btnDay);
        bt_country = (ImageButton) findViewById(R.id.btnCountry);

        bt_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFrag(0);
            }
        });
        bt_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFrag(1);
            }
        });

    }


    private void setFrag(int i) { // fragment change method
        fm = getFragmentManager();
        tran = fm.beginTransaction();

        switch (i){
            case 0:
                tran.replace(R.id.frame_classification, DayFragment);
                tran.commit();
                break;
            case 1:
                tran.replace(R.id.frame_classification, CountryFragment);
                tran.commit();
                break;
        }
    }
}
