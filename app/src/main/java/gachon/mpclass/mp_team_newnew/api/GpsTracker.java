package gachon.mpclass.mp_team_newnew.api;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import gachon.mpclass.mp_team_newnew.MainActivity;

public class GpsTracker {

    private MainActivity main;
    public static double latitude;
    public static double longitude;

    public GpsTracker(MainActivity context) {
        main = context;
        main.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                0);
    }

    /**
     * 위치 정보 확인을 위해 정의한 메소드
     */
    public void startLocationService() {
        LocationManager manager = (LocationManager) main.getSystemService(Context.LOCATION_SERVICE);
        GPSListener gpsListener = new GPSListener();
        long minTime = 10000;
        float minDistance = 0;
        try {
            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    minTime,
                    minDistance,
                    gpsListener);
// 위치 확인이 안되는 경우에도 최근에 확인된 위치 정보 먼저 확인
            Location lastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastLocation != null) {
                latitude = lastLocation.getLatitude();
                longitude = lastLocation.getLongitude();
                //Toast.makeText(main, "Last Known Location : " + "Latitude : " + latitude + "\nLongitude:"+longitude, Toast.LENGTH_LONG).show();
            }
        } catch (SecurityException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 리스너 클래스 정의
     */
    private class GPSListener implements LocationListener {
        /**
         * 위치 정보가 확인될 때 자동 호출되는 메소드
         */
        public void onLocationChanged(Location location) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            String msg = "Latitude : " + latitude + "\nLongitude:" + longitude;
            //Toast.makeText(main, msg, Toast.LENGTH_LONG).show();
            Log.i("GPSListener", msg);
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }
}
