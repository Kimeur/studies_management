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
import android.widget.ListView;

import java.util.List;

public class get_students extends AppCompatActivity {
    ListView list_students ;
    Button student;
    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);
        list_students = (ListView) findViewById(R.id.list_students);
        student = (Button) findViewById(R.id.student);
        DatabaseOperations DB = new DatabaseOperations(ctx);
        List<student> list = DB.getStudents(DB);
        if (list.size()==0 ) {
            final Dialog dialog = new Dialog(ctx);
            dialog.setContentView(R.layout.custom_dialog_students);
            Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Intent secondeActivite = new Intent(ctx, add_student.class);
                    startActivity(secondeActivite);

                }
            });
            dialog.show();
        } else {
            String[] prenoms = new String[list.size()];
            prenoms[0] = "";
            for (int i = 0; i < list.size(); i++) {
                prenoms[i] = list.get(i).firstname.toString() + " " + list.get(i).lastname.toString();
            }

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ctx,
                    android.R.layout.simple_list_item_1, prenoms);

            list_students.setAdapter(adapter);

        }
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(ctx, add_student.class);
                startActivity(secondeActivite);
            }
        });
    }

}
