package edu.itakademy.demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello les its");

    }

    public void onBtn1Click(View view){
        Intent i = new Intent(this, SecondaryActivity.class);
        i.putExtra("data", "Depuis la main Activity");
        startActivity(i);
    }

    public void onBtn2Click(View view){
        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello personne");

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("Android power");

        Log.e("DEBUG", "TEST");

        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();

    }


}