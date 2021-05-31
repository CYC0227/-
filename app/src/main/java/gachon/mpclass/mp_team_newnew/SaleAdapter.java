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
import gachon.mpclass.mp_team_newnew.form.TodaySaleForm;

public class SaleAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<TodaySaleForm> saleFormList; //Item 목록을 담을 배열
    private int layout;


    public SaleAdapter(Context context, int layout, List<TodaySaleForm> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.saleFormList = data;
        this.layout = layout;
    }

    @Override
    public int getCount() { //리스트 안 Item의 개수를 센다.
        return saleFormList.size();
    }

    @Override
    public String getItem(int position) {
        return saleFormList.get(position).getStore_address();
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
        TodaySaleForm saleItem = saleFormList.get(position);

        // 가게 주소 반영
        TextView address = (TextView) convertView.findViewById(R.id.edit_address);
        address.setText(saleItem.getStore_address());

        // 세일 정보 반영
        TextView info = (TextView) convertView.findViewById(R.id.edit_information);
        info.setText(saleItem.getInfo());

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        return convertView;
    }
}
