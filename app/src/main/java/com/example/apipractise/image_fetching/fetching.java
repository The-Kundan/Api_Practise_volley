package com.example.apipractise.image_fetching;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.apipractise.R;
import com.example.apipractise.volleySingleton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class fetching extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    List<Item> postList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetching);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue= volleySingleton.getInstance(this).getRequestQueue();

        postList = new ArrayList<>();
        fetchData();
    }

    private void fetchData() {
        String url ="https://pixabay.com/api/?key=51859612-ff1979d1c2687e240c24326e6&q=nature&image_type=photo&pretty=true";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("hits");
                    for (int i = 0; i < jsonArray.length(); i++) {
                         JSONObject jsonObject = jsonArray.getJSONObject(i);

                         String imageUrl = jsonObject.getString("webformatURL");
                         String collections = jsonObject.getString("collections");
                         int likes = jsonObject.getInt("likes");
                         int comments = jsonObject.getInt("comments");
                         int downloads = jsonObject.getInt("downloads");
                         Item post = new Item(imageUrl,collections,likes,comments,downloads);
                         postList.add(post);
                    }
                    postAdapter adapter = new postAdapter(fetching.this,postList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(fetching.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}