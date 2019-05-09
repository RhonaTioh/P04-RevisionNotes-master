package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShow;
    EditText etNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsertNote);
        etNote = findViewById(R.id.editTextNote);
        btnShow = findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RadioGroup rg = findViewById(R.id.radioGroupStars);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);


                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertNote(etNote.getText().toString(), Integer.parseInt(rb.getText().toString()));
                db.close();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getBaseContext(), SecondActivity.class);
                // Insert a task
                startActivity(i);

            }
        });


    }
}