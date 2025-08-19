package com.example.apipractise.MovieFetching;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.apipractise.R;
import com.example.apipractise.volleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    List<Movie> movieList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        recyclerView = findViewById(R.id.recyclerviewMovie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = volleySingleton.getInstance(this).getRequestQueue();

        movieList = new ArrayList<>();
        fetchMovies();

    }

    private void fetchMovies() {
        String url = "https://my.api.mockaroo.com/users.json?key=de45bf80";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        String title = jsonObject.getString("title");
                        String poster = jsonObject.getString("poster");
                        String overview = jsonObject.getString("overview");
                        Double rating = jsonObject.getDouble("rating");

                        Movie movie = new Movie(title, poster, overview, rating);
                        movieList.add(movie);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    MovieAdapter movieAdapter = new MovieAdapter(MovieList.this, movieList);
                    recyclerView.setAdapter(movieAdapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MovieList.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}