package edu.itakademy.demo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import edu.itakademy.demo2.adapter.EmployeeRecyclerViewAdapter;
import edu.itakademy.demo2.entity.Employee;
import edu.itakademy.demo2.helper.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        openFragment(new HomeFragment());

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        openFragment(new HomeFragment());
                        return true;
                    case R.id.action_http:
                        openFragment(new HttpFragment());
                        return true;
                    case R.id.action_firebase:
                        Bundle bundle = new Bundle();
                        bundle.putString("test", "Yeah");
                        FirebaseFragment firebaseFragment = new FirebaseFragment();
                        firebaseFragment.setArguments(bundle);
                        openFragment(firebaseFragment);
                        return true;
                }
                return false;
            }
        });

    }

    void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.constraintLayout, fragment);
        fragmentTransaction.commit();
    }

    public void openHttpFormActivity(View view) {
        Intent i = new Intent(this, HttpFormActivity.class);
        startActivity(i);
    }

    public void openHttpListActivity(View view) {
        Intent i = new Intent(this, HttpListActivity.class);
        startActivity(i);
    }


}