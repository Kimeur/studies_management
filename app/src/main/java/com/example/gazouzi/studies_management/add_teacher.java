package com.example.gazouzi.studies_management;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_teacher extends AppCompatActivity {
    EditText firstname, lastname, email, departement, comment;
    Button submit;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        firstname = (EditText) findViewById(R.id.Firstname);
        lastname= (EditText) findViewById(R.id.Lastname);
        email = (EditText) findViewById(R.id.Email);
        departement = (EditText) findViewById(R.id.Departement);
        comment = (EditText) findViewById(R.id.Comment);
        submit= (Button) findViewById(R.id.submit_teacher);

        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String text_firstname = firstname.getText().toString();
                String text_lastname = lastname.getText().toString();
                String text_email = email.getText().toString();
                String text_departement = departement.getText().toString();
                String text_comment = comment.getText().toString();
                DatabaseOperations DB = new DatabaseOperations(ctx);

                DB.addNewTeacher(DB,text_firstname ,text_lastname ,text_email,text_departement ,text_comment);
                Toast.makeText(getApplicationContext(),"Teacher added!",Toast.LENGTH_SHORT).show();
                Intent secondeActivite = new Intent(ctx, MainActivity.class);
                startActivity(secondeActivite);

            }

        });


    }

}
