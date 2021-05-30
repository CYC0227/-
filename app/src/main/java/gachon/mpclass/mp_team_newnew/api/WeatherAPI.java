package gachon.mpclass.mp_team_newnew.api;

import android.annotation.SuppressLint;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import gachon.mpclass.mp_team_newnew.MainActivity;

public class WeatherAPI {

    /* -------------------- instance variable -------------------------- */
    private MainActivity main;
    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    private final String apiKey = "106a851c97dded8086a6c906486bfa54";
    static RequestQueue requestQueue;
    /* ----------------------------------------------------------------- */

    public WeatherAPI(MainActivity context) {
        main = context;
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(main);
        }
    }

    public void callCurrentWeather(double latitude, double longitude) {
        String url = BASE_URL + "?lat=" + latitude + "&lon=" + longitude + "&appid=" + apiKey + "&lang=kr";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String city = jsonObject.getString("name");
                    //Toast.makeText(main, "도시 : " + city, Toast.LENGTH_LONG).show();

                    JSONArray weatherJson = jsonObject.getJSONArray("weather");
                    JSONObject weatherObj = weatherJson.getJSONObject(0);
                    String weather = weatherObj.getString("description");
                    //Toast.makeText(main, "날씨 : " + weather, Toast.LENGTH_LONG).show();

                    JSONObject tempK = new JSONObject(jsonObject.getString("main"));
                    double tempDo = (Math.round((tempK.getDouble("temp") - 273.15) * 100) / 100.0);
                    //Toast.makeText(main, "온도 : " + tempDo + "ºC", Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);
    }
}