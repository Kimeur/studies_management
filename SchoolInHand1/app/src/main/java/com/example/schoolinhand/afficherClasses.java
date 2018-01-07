package com.example.schoolinhand;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class afficherClasses extends Activity{
    ListView listeC;
    Context ctx = this;
    public static String CL = "Value";
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.afficher_listes_admin);
		
		listeC = (ListView) findViewById(R.id.Listes_Classes);
        listeC.getSelectedItem();
        
        DatabaseOperations DB = new DatabaseOperations(ctx);
        final List<String> exemple = DB.getClasses(DB);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, exemple);
		listeC.setAdapter(adapter);
		listeC.setOnItemClickListener(new
				AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapterView,
				View view,
				int position,
				long id) {
	        	String s = new String();
					s=listeC.getSelectedItem().toString();
	        	Intent secondeActivite = new Intent(afficherClasses.this,
						afficherEtudParClasse.class);
	        	String val = exemple.get(position);
	        	secondeActivite.putExtra(CL, val);
				}
				});
    	
	}
		
		
		}
