package com.example.schoolinhand;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjouterClasse extends Activity{
    EditText t = null;
    Button save;
    String classe_name;
    Context ctx = this;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ajouter_classe);
		t = (EditText) findViewById(R.id.Note);
        save = (Button) findViewById(R.id.enregNote);
        
    	save.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
			classe_name = t.getText().toString();
			
			DatabaseOperations DB = new DatabaseOperations(ctx);
			DB.ajouterClasse(DB, classe_name);
			Toast.makeText(getBaseContext(), "Classe ajoutée", Toast.LENGTH_LONG).show();
			
			}
			
			
		});
	}
		
		
		}
