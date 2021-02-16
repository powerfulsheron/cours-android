package edu.itakademy.demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

import edu.itakademy.demo2.helper.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello les its");

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Array des champs qu'on veut récuperer de la table
        String[] projection = {
                "id",
                "firstname",
                "lastname"
        };

        String selection = "firstname" + " = ?";
        String[] selectionArgs = {"Canavaggio"};
        Cursor cursor = db.query(
                "employee",
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        if(cursor != null){
            cursor.moveToFirst();
        }

        Toast.makeText(this, cursor.getString(cursor.getColumnIndex("firstname")), Toast.LENGTH_SHORT).show();

        // Select * sur la table employee
        // Cursor cursor = db.query("employee", null, null, null, null, null, null, null)
        // Cursor cursor = db.rawQuery("select * from employee", null);

        cursor.close();




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