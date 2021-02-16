package edu.itakademy.demo2;

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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.itakademy.demo2.adapter.EmployeeRecyclerViewAdapter;
import edu.itakademy.demo2.entity.Employee;
import edu.itakademy.demo2.helper.DatabaseHelper;

public class MainActivity extends AppCompatActivity implements  EmployeeRecyclerViewAdapter.ItemClickListener {

    EmployeeRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello les its");

        RecyclerView recyclerView = findViewById(R.id.employeeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ArrayList<Employee> employees = new ArrayList<>();

        Cursor cursor = db.query("employee", null, null, null, null, null, null, null);

        while(cursor.moveToNext()) {
            Employee tempEmployee = new Employee();
            tempEmployee.setId(cursor.getInt(cursor.getColumnIndex("id")));
            tempEmployee.setFirstname(cursor.getString(cursor.getColumnIndex("firstname")));
            tempEmployee.setLastname(cursor.getString(cursor.getColumnIndex("lastname")));
            tempEmployee.setAge(cursor.getInt(cursor.getColumnIndex("age")));
            tempEmployee.setSalary(cursor.getInt(cursor.getColumnIndex("salary")));
            employees.add(tempEmployee);
        }

        cursor.close();

        adapter = new EmployeeRecyclerViewAdapter(this, employees);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

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

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You cliked : " + String.valueOf(adapter.getItem(position)), Toast.LENGTH_SHORT).show();
    }


}