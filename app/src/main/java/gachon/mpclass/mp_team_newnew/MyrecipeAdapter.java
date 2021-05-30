package gachon.mpclass.mp_team_newnew;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gachon.mpclass.mp_team_newnew.form.PostingForm;

public class MyrecipeAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<PostingForm> postingFormList; //Item 목록을 담을 배열
    private int layout;
    private List<Bitmap> imgList = new ArrayList<>();

    public MyrecipeAdapter(Context context, int layout, List<PostingForm> data, List<Bitmap> imgList) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.postingFormList = data;
        this.layout = layout;
        this.imgList = imgList;
    }

    @Override
    public int getCount() { //리스트 안 Item의 개수를 센다.
        return postingFormList.size();
    }

    @Override
    public String getItem(int position) {
        return postingFormList.get(position).getTitle();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        PostingForm myrecipeItem = postingFormList.get(position);
        Bitmap bitmap = imgList.get(position);

        // 이미지 파일 연동
        ImageView profile = (ImageView) convertView.findViewById(R.id.profile);
        profile.setImageBitmap(bitmap);

        // 이름 등 정보 연동
        TextView info = (TextView) convertView.findViewById(R.id.info);
        info.setText(myrecipeItem.getTitle());

        ImageView heart = (ImageView) convertView.findViewById(R.id.heart);

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heart.setImageResource(R.drawable.heart_red);
            }
        });
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        return convertView;
    }
}
