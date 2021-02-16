package edu.itakademy.demo2.service;

import edu.itakademy.demo2.entity.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostAPI {

    @GET("{id}")
    Call<Post> getPost (@Path("id") String id);

}
