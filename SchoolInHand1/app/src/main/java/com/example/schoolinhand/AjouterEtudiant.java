package com.example.schoolinhand;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AjouterEtudiant extends Activity{
    EditText nom,prenom,email,cin;
    Button save;
    String eNom, ePrenom, eEmail, eCin, eClasse;
    Spinner classe;
    Context ctx = this;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ajouter_etudiant);
		nom = (EditText) findViewById(R.id.Etud_Nom);
		prenom = (EditText) findViewById(R.id.Etud_Pre);
	    email = (EditText) findViewById(R.id.Etud_Email);
		cin = (EditText) findViewById(R.id.Etud_Cin);
		classe = (Spinner) findViewById(R.id.Etud_Classe); 
        save = (Button) findViewById(R.id.EnregEtud);
        
        
        DatabaseOperations DB = new DatabaseOperations(ctx);
        //Remplissage du spinner classe
        ArrayList<String> cl = DB.getClasses(DB);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, cl);
        classe.setAdapter(adapter);
        
    	save.setOnClickListener(new OnClickListener(){
            
			@Override
			public void onClick(View v) {
				
			eNom = nom.getText().toString();
			ePrenom = prenom.getText().toString();
			eEmail = email.getText().toString();
			eCin = cin.getText().toString();
			eClasse = classe.getSelectedItem().toString();
			
			DatabaseOperations DB = new DatabaseOperations(ctx);
			if(!DB.ajouterEtudiant(DB, eNom, ePrenom, eEmail, eCin, eClasse))
			Toast.makeText(getBaseContext(), "Classe introuvable", Toast.LENGTH_LONG).show();
			
			else 
				Toast.makeText(getBaseContext(), "Etudiant ajouté", Toast.LENGTH_LONG).show();
			}
			
			
		});
	}
		
		
		}
