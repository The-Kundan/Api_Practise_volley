package com.example.apipractise;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);
        Button button = findViewById(R.id.button);

        // without singleton pattern
//        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // with singleton pattern
        RequestQueue requestQueue = volleySingleton.getInstance(this).getRequestQueue();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://my.api.mockaroo.com/users.json?key=de45bf80&__method=PUT";
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("student");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject student = jsonArray.getJSONObject(i);

                                String name = student.getString("name");
                                String email = student.getString("email");
                                int age = student.getInt("age");
                                String course = student.getString("course");

                                textView.append("Name: " + name + "\n");
                                textView.append("Email: " + email + "\n");
                                textView.append("Age: " + age + "\n");
                                textView.append("Course: " + course + "\n\n");

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Error parsing data.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        String errorMessage = volleyError.getMessage();
                        if (TextUtils.isEmpty(errorMessage)) {
                            // If getMessage() is null or empty, provide a generic error message.
                            Toast.makeText(MainActivity.this, "An unknown error occurred.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                        }
                        // It's also good practice to log the full error for debugging
                        if (volleyError.networkResponse != null) {
                            // Log network response details if available
                            android.util.Log.e("VolleyError", "Status Code: " + volleyError.networkResponse.statusCode);
                        }
                        volleyError.printStackTrace();
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }
}