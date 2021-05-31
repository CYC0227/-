package gachon.mpclass.mp_team_newnew.api;

import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import gachon.mpclass.mp_team_newnew.SaleActivity;

public class MyGeoCoder {

    SaleActivity main;
    Geocoder g;
    List<Address> address = null;

    public MyGeoCoder(SaleActivity context) {
        main = context;
        g = new Geocoder(main, Locale.forLanguageTag("ko"));
    }

    public String getAddress() {
        try {
            address = g.getFromLocation(GpsTracker.latitude, GpsTracker.longitude, 10);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("test", "입출력오류");
        }
        if (address != null) {
            if (address.size() == 0) {
                return "주소찾기 오류";
            } else {
                // Log.d("찾은 주소", address.get(0).toString());
                // Toast.makeText(main, address.get(0).toString(), Toast.LENGTH_LONG).show();
                return address.get(0).getAddressLine(0);
            }
        }
        return "";
    }
}
