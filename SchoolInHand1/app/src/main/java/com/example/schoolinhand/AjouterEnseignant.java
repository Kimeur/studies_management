package com.example.schoolinhand;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjouterEnseignant extends Activity{
    EditText nom,prenom,email,cin;
    Button save;
    String eNom, ePrenom, eEmail, eCin;
    Context ctx = this;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ajouter_enseignant);
		nom = (EditText) findViewById(R.id.Ensei_Nom);
		prenom = (EditText) findViewById(R.id.Ensei_Pre);
	    email = (EditText) findViewById(R.id.Ensei_Email);
		cin = (EditText) findViewById(R.id.Ensei_Cin);
        save = (Button) findViewById(R.id.EnregEnsei);
        
    	save.setOnClickListener(new OnClickListener(){
            
			@Override
			public void onClick(View v) {
				
			eNom = nom.getText().toString();
			ePrenom = prenom.getText().toString();
			eEmail = email.getText().toString();
			eCin = cin.getText().toString();
			
			DatabaseOperations DB = new DatabaseOperations(ctx);
			if(!DB.ajouterEnseignant(DB, eNom, ePrenom, eEmail, eCin))
			Toast.makeText(getBaseContext(), "Enseignant non ajouté!", Toast.LENGTH_LONG).show();
			
			else 
				Toast.makeText(getBaseContext(), "Enseignant ajouté", Toast.LENGTH_LONG).show();
			}
			
			
		});
	}
		
		
		}
