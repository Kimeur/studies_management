package com.example.schoolinhand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminActivity extends Activity {
    
	Button aEtudiant, aEnseignant, aMatiere, aClasse, decoAdmin, affListes;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		
		aEtudiant = (Button) findViewById(R.id.AjouterNote);
		aEnseignant = (Button) findViewById(R.id.modifierNote);
		aMatiere = (Button) findViewById(R.id.AjouterMat);
		aClasse = (Button) findViewById(R.id.AjouterCla);
		decoAdmin = (Button) findViewById(R.id.decoAdmin);
		affListes = (Button) findViewById(R.id.AfficherListes);
		
		aClasse.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			Intent secondeActivite = new Intent(AdminActivity.this,
			AjouterClasse.class);
			startActivity(secondeActivite);
			}
			});
		aEtudiant.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			Intent secondeActivite = new Intent(AdminActivity.this,
			AjouterEtudiant.class);
			startActivity(secondeActivite);
			}
			});
		aEnseignant.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			Intent secondeActivite = new Intent(AdminActivity.this,
			AjouterEnseignant.class);
			startActivity(secondeActivite);
			}
			});
		aMatiere.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			Intent secondeActivite = new Intent(AdminActivity.this,
			AjouterMatiere.class);
			startActivity(secondeActivite);
			}
			});
		decoAdmin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getBaseContext(), "Déconnexion...", Toast.LENGTH_LONG).show();
				Runnable clickButton = new Runnable() {
		            @Override
		            public void run() {
		            	
		            	Intent secondeActivite = new Intent(AdminActivity.this,
		            			MainActivity.class);
		            	finish();
		            			startActivity(secondeActivite);	
							
		            }
		        };
		    decoAdmin.postDelayed(clickButton, 3500);
			
			}
			});
		affListes.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			Intent secondeActivite = new Intent(AdminActivity.this,
			afficherClasses.class);
			startActivity(secondeActivite);
			}
			});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
