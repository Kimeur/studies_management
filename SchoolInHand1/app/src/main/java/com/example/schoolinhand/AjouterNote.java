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

public class AjouterNote extends Activity{
    EditText nEtud;
    Button save;
    Spinner etud, mat;
    String etudiant, matiere, note;
    Context ctx = this;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ajouter_note);
		nEtud = (EditText) findViewById(R.id.Note);
		etud = (Spinner) findViewById(R.id.note_etud);
		mat = (Spinner) findViewById(R.id.note_matiere);
        save = (Button) findViewById(R.id.enregNote);
        

		DatabaseOperations DB = new DatabaseOperations(ctx);
        
        //Remplissage du spinner Matiere
        ArrayList<String> cl = DB.getMatieres(DB);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, cl);
        mat.setAdapter(adapter);
        
        //Remplissage du spinner Etudiant
        ArrayList<String> cl1 = DB.getStudents(DB);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, cl1);
        etud.setAdapter(ad);
        
    	save.setOnClickListener(new OnClickListener(){
   
			@Override
			public void onClick(View v) {
			
			note = nEtud.getText().toString();	
			
			Float t = Float.valueOf(note);
			etudiant = etud.getSelectedItem().toString();
			matiere = mat.getSelectedItem().toString();
			
			DatabaseOperations DB = new DatabaseOperations(ctx);
			if(!DB.ajouterNote(DB, t, matiere, etudiant))
			Toast.makeText(getBaseContext(), "Note non ajouté, réessayer.", Toast.LENGTH_LONG).show();
			
			else 
				Toast.makeText(getBaseContext(), "Note ajouté", Toast.LENGTH_LONG).show();
			
			}
			
			
		});
	}
		
		
		}
