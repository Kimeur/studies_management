package com.example.gazouzi.studies_management;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_student extends AppCompatActivity {
    EditText firstname, lastname, email, age, comment;
    Button submit;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        firstname = (EditText) findViewById(R.id.Fisrtname);
        lastname= (EditText) findViewById(R.id.Lastname);
        email = (EditText) findViewById(R.id.Email);
        age = (EditText) findViewById(R.id.Age);
        comment = (EditText) findViewById(R.id.Comment);
        submit= (Button) findViewById(R.id.submit_student);

        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String text_firstname = firstname.getText().toString();
                String text_lastname = lastname.getText().toString();
                String text_email = email.getText().toString();
                String text_age = age.getText().toString();
                String text_comment = comment.getText().toString();
                DatabaseOperations DB = new DatabaseOperations(ctx);
                DB.addNewStudent(DB,text_firstname ,text_lastname ,text_email ,text_age ,text_comment);
                Toast.makeText(getApplicationContext(),"Teacher added!",Toast.LENGTH_SHORT).show();
                Intent secondeActivite = new Intent(ctx, MainActivity.class);
                startActivity(secondeActivite);

            }

        });


    }

}
