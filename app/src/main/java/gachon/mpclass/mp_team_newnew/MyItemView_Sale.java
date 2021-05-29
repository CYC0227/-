package gachon.mpclass.mp_team_newnew;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MyItemView_Sale extends LinearLayout {
    TextView textView, textView2;
    public MyItemView_Sale(Context context) {
        super(context); init(context);
    }
    public MyItemView_Sale(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.my_item_sale, this, true);

        textView = findViewById(R.id.info);
        textView2 = findViewById(R.id.address);
    }
    public void setId(String id){
        textView.setText(id);
    }
    public void setPhone(String phone){
        textView2.setText(phone);
    }
}
