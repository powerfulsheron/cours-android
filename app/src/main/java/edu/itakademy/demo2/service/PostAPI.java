package edu.itakademy.demo2.service;

import java.util.List;

import edu.itakademy.demo2.entity.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostAPI {

    @GET("posts/{id}")
    Call<Post> getPost (@Path("id") String id);

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST("posts")
    Call<Post> createPost(@Body Post post);

}
