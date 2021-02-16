package edu.itakademy.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.itakademy.demo2.helper.DatabaseHelper;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Bundle extras = getIntent().getExtras();

        TextView secondTextView =  findViewById(R.id.secondTextView);
        secondTextView.setText(extras.getString("data"));

    }

    public void insertEmployee(View view) {

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        EditText editTextTextEmployeeFirstname = findViewById(R.id.editTextTextEmployeeFirstname);
        EditText editTextTextEmployeeLastname = findViewById(R.id.editTextTextEmployeeLastname);
        EditText editTextTextEmployeeAge = findViewById(R.id.editTextTextEmployeeAge);
        EditText editTextTextEmployeeSalary = findViewById(R.id.editTextTextEmployeeSalary);

        ContentValues values = new ContentValues();
        values.put("firstname", editTextTextEmployeeFirstname.getText().toString());
        values.put("lastname", editTextTextEmployeeLastname.getText().toString());
        values.put("age", editTextTextEmployeeAge.getText().toString());
        values.put("salary", editTextTextEmployeeSalary.getText().toString());
        long newRowId = db.insert("employee", null, values);

        Toast.makeText(this, Long.toString(newRowId), Toast.LENGTH_SHORT).show();

    }
}