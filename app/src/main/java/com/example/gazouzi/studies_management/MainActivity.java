package com.example.gazouzi.studies_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button student, subject, teacher, liststudents ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student = (Button) findViewById(R.id.add_student);
        subject= (Button) findViewById(R.id.add_subject);
        teacher = (Button) findViewById(R.id.add_teacher);
        liststudents = (Button) findViewById(R.id.show_list);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(MainActivity.this, add_student.class);
                startActivity(secondeActivite);
            }
        });

        subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(MainActivity.this, add_subject.class);
                startActivity(secondeActivite);
            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(MainActivity.this, add_teacher.class);
                startActivity(secondeActivite);
            }
        });
        liststudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(MainActivity.this, get_students.class);
                startActivity(secondeActivite);
            }
        });
    }
}
