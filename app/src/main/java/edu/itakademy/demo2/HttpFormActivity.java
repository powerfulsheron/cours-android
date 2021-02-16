package edu.itakademy.demo2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.itakademy.demo2.entity.Post;
import edu.itakademy.demo2.helper.PostAPIHelper;
import edu.itakademy.demo2.service.PostAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HttpFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_form);
    }


    public void insertPost(View view) {

        PostAPIHelper postAPIHelper = new PostAPIHelper();
        PostAPI postAPI = postAPIHelper.api;

        EditText editTextPostTitle = findViewById(R.id.editTextPostTitle);
        EditText editTextPostBody = findViewById(R.id.editTextPostBody);

        Post post = new Post();
        post.setTitle(editTextPostTitle.getText().toString());
        post.setBody(editTextPostBody.getText().toString());

        postAPI.createPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getBaseContext(), String.valueOf(response.body().getId()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });

    }

}