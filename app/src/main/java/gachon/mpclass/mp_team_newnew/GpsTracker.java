package gachon.mpclass.mp_team_newnew;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.core.content.ContextCompat;

/**
 * Class that returns user's current location using GPS
 */
public class GpsTracker extends Service implements LocationListener {

    /* -------------------- instance variable -------------------------- */
    private final Context mContext;
    Location location;
    double latitude; // 위도
    double longitude; // 경도

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1분
    protected LocationManager locationManager;
    /* ---------------------------------------------------------------- */

    /**
     * Constructor
     */
    public GpsTracker(Context context) {
        this.mContext = context;
        getLocation();
    }

    /**
     * method to get current location using GPS
     *
     * @return location (Location) -> current location of this application
     */
    public Location getLocation() {
        try {
            /* get location manager */
            locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);

            /* get GPS status */
            boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) { /* case that anything doesn't work */

            } else { /* at least one of them works */

                /* check whether we have permission to use GPS */
                int hasFineLocationPermission = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION);
                int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION);
                if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                        hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED) { /* case that we have all the permissions */

                } else { /* case that we don't have every permissions */
                    return null; // can't use GPS
                }

                /* GPS usage section */
                if (isNetworkEnabled) { // network online
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER); // get GPS value
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }

                if (isGPSEnabled) { // GPS online
                    if (location == null) {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            Log.d("@@@", "" + e.toString());
        }

        return location;
    }

    /**
     * method to get latitude value from location object
     *
     * @return latitude (double) -> latitude value of current location
     */
    public double getLatitude() {
        if (location != null) {
            latitude = location.getLatitude();
        }
        return latitude;
    }

    /**
     * method to get longitude value from location object
     *
     * @return longitude (double) -> longitude value of current location
     */
    public double getLongitude() {
        if (location != null) {
            longitude = location.getLongitude();
        }
        return longitude;
    }

    /* ------------------- override method ---------------------------- */
    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
    /* ----------------------------------------------------------------- */

    /**
     * method to stop using GPS
     */
    public void stopUsingGPS() {
        if (locationManager != null) {
            locationManager.removeUpdates(GpsTracker.this);
        }
    }

}
