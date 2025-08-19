package com.example.apipractise;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class volleySingleton {
    private static volleySingleton instance;
    private RequestQueue requestQueue;

    private volleySingleton(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }
    public static synchronized volleySingleton getInstance(Context context) {
        if (instance == null) {
            instance = new volleySingleton(context);
        }
        return instance;
    }
    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

}
