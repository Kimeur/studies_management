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

public class AjouterMatiere extends Activity{
    EditText nom;
    Button save;
    String mNom, mClasse, mEnsei;
    Spinner classe, enseignant;
    Context ctx = this;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ajouter_matiere);
		nom = (EditText) findViewById(R.id.Mat_Nom);
		classe = (Spinner) findViewById(R.id.Mat_Classe);
		enseignant = (Spinner) findViewById(R.id.Mat_Ensei);
        save = (Button) findViewById(R.id.EnregMat);
        				
        
        DatabaseOperations DB = new DatabaseOperations(ctx);
        
        //Remplissage du spinner classe
        ArrayList<String> cl = DB.getClasses(DB);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, cl);
        classe.setAdapter(adapter);
        
      //Remplissage du spinner enseignant
        ArrayList<String> cl1 = DB.getTeachers(DB);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, cl1);
        enseignant.setAdapter(ad);
        
    	save.setOnClickListener(new OnClickListener(){
            
			@Override
			public void onClick(View v) {
				
			mNom = nom.getText().toString();
			mClasse = classe.getSelectedItem().toString();
			mEnsei = enseignant.getSelectedItem().toString();
			
			DatabaseOperations DB = new DatabaseOperations(ctx);
			if(!DB.ajouterMatiere(DB, mNom, mClasse, mEnsei))
			Toast.makeText(getBaseContext(), "Matière non ajouté, réessayer.", Toast.LENGTH_LONG).show();
			
			else 
				Toast.makeText(getBaseContext(), "Matière ajouté", Toast.LENGTH_LONG).show();
			}
			
			
		});
	}
		
		
		}
