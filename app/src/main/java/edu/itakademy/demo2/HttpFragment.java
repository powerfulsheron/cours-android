package edu.itakademy.demo2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;

import edu.itakademy.demo2.helper.PostAPIHelper;
import edu.itakademy.demo2.service.PostAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpFragment extends Fragment {

    public HttpFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PostAPIHelper postAPIHelper = new PostAPIHelper();
        PostAPI postAPI = postAPIHelper.api;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_http, container, false);
    }

    @Override
    public void onResume(){
        super.onResume();

        View view = getView();
        ImageView httpImageView = view.findViewById(R.id.httpImageView);

        OkHttpClient client =  new OkHttpClient();

        Request request = new Request.Builder().url("https://picsum.photos/200/300").build();

        client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("ERROR", "Request failed : " + e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());
                    new Handler(Looper.getMainLooper()).post(() -> httpImageView.setImageBitmap(bitmap));
                }
            }
        );

    }

}