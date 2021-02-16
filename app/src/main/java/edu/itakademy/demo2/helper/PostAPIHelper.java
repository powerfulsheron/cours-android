package edu.itakademy.demo2.helper;

import edu.itakademy.demo2.service.PostAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostAPIHelper {

    public final PostAPI api;

    public  PostAPIHelper(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/posts/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(PostAPI.class);
    }

}
