package com.example.schoolinhand;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class afficherEtudParClasse extends Activity{
    ListView listeE;
    String classe;
    Context ctx = this;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.afficher_etudiant_listes);
		
		listeE = (ListView) findViewById(R.id.Listes_etudiant);
    	
        Intent i = getIntent();
		String s = i.getStringExtra(afficherClasses.CL);
        
        DatabaseOperations DB = new DatabaseOperations(ctx);
        List<String> exemple = DB.getStudentsPerClasse(DB, s);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, exemple);
		listeE.setAdapter(adapter);
    	
	}
		
		
		}
