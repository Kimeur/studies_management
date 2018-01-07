package com.example.gazouzi.studies_management;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class add_subject extends AppCompatActivity {
    EditText name, degree, comment;
    Spinner teacher;
    Button submit;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
        DatabaseOperations DB = new DatabaseOperations(ctx);
        final List<teacher> list = DB.getTeachers(DB);
        if (list.size()==0 ) {
            final Dialog dialog = new Dialog(ctx);
            dialog.setContentView(R.layout.custom_dialog);
            Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Intent secondeActivite = new Intent(ctx, add_teacher.class);
                    startActivity(secondeActivite);

                }
            });
            dialog.show();
        }
        name = (EditText) findViewById(R.id.Name);
        degree= (EditText) findViewById(R.id.Degree);
        comment = (EditText) findViewById(R.id.Comment);
        teacher = (Spinner) findViewById(R.id.spinner);
        submit= (Button) findViewById(R.id.submit_subject);
        teacher.setPrompt("teacher_name");
        String[] teachersNames = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            teachersNames[i] = list.get(i).lastname.toString() + " " + list.get(i).firstname.toString();
        }
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ctx,
                android.R.layout.simple_spinner_dropdown_item, teachersNames);
        teacher.setAdapter(arrayAdapter);
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String[] out = teacher.getSelectedItem().toString().split(" ");
                String lastName= out[0];
                final int[] teacher_Id = new int[1];
                for (com.example.gazouzi.studies_management.teacher t : list) {
                    if ( t.getLastname().equals(lastName)) {
                        teacher_Id[0] = t.getTeacherId();
                    }
                }
                String text_name = name.getText().toString();
                String text_degree = degree.getText().toString();
                String text_teacher_name = teacher.getSelectedItem().toString();
                String text_comment = comment.getText().toString();
                DatabaseOperations DB = new DatabaseOperations(ctx);

                DB.addNewSubject(DB,text_name ,text_degree ,text_teacher_name, teacher_Id[0] ,text_comment);
                Toast.makeText(getApplicationContext(),"Subject added!",Toast.LENGTH_SHORT).show();
                Intent secondeActivite = new Intent(ctx, MainActivity.class);
                startActivity(secondeActivite);
            }

        });

    }

}
