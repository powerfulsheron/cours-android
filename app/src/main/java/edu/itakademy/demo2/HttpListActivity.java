package edu.itakademy.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import edu.itakademy.demo2.entity.Post;
import edu.itakademy.demo2.helper.PostAPIHelper;
import edu.itakademy.demo2.service.PostAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_list);

        PostAPIHelper postAPIHelper = new PostAPIHelper();
        PostAPI api = postAPIHelper.api;

        Call<List<Post>> postsCall = api.getPosts();
        postsCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                TextView textViewPosts = findViewById(R.id.textViewPosts);
                textViewPosts.setText(posts.toString());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });

    }
}