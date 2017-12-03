package com.brightstar.airco;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by super on 11/26/2017.
 */

public class AircoUtils {

    public static final String API_URL = "https://api.thingspeak.com/";
    private static final String TAG = "AircoUtils";
    private static final String API_KEY = "WHKKSR38WAC6FMXY";

    public static void turnOn(Context context){
        String url= API_URL+"update?api_key="+ API_KEY + "&field1=1";
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, error.toString());
            }
        });
        queue.add(stringRequest);
    }

    public static void turnOff(Context context){
        String url= API_URL+"update?api_key="+ API_KEY + "&field1=0";
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, error.toString());
            }
        });
        queue.add(stringRequest);
    }
}
