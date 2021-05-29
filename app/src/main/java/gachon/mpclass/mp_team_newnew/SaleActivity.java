package gachon.mpclass.mp_team_newnew;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SaleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
    }

    //어댑터
    ListView listView = findViewById(R.id.lv_comment_view);

    class MyAdapter extends BaseAdapter {


    }
}
