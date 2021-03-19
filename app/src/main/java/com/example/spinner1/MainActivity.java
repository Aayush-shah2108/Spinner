package com.example.spinner1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spin;
    ArrayList<String>subject;
    EditText url;
    Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin=(Spinner)findViewById(R.id.sp123);
        url=(EditText)findViewById(R.id.et1);
        go=(Button)findViewById(R.id.btngo);

        subject=new ArrayList<>();
        subject.add("hindi");
        subject.add("english");
        subject.add("gujrati");
        subject.add("maths");
        final ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,subject);
        spin.setAdapter(adapter);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abc=url.getText().toString();
                subject.add(abc);
                adapter.notifyDataSetChanged();
                url.setText("");
                Toast.makeText(MainActivity.this, "Record added sucessfull", Toast.LENGTH_SHORT).show();
            }
        });

    }
}