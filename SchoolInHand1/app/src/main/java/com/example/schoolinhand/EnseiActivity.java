package com.example.schoolinhand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EnseiActivity extends Activity {
    
	Button decoEnsei, ajouterN;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enseignant);
		
		
		decoEnsei = (Button) findViewById(R.id.decoEnsei);
		ajouterN = (Button) findViewById(R.id.AjouterNote);
		
		ajouterN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			Intent secondeActivite = new Intent(EnseiActivity.this,
			AjouterNote.class);
			startActivity(secondeActivite);
			}
			});
		
		decoEnsei.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getBaseContext(), "Déconnexion...", Toast.LENGTH_LONG).show();
				Runnable clickButton = new Runnable() {
		            @Override
		            public void run() {
		            	
		            	Intent secondeActivite = new Intent(EnseiActivity.this,
		            			MainActivity.class);
		            	finish();
		            			startActivity(secondeActivite);	
							
		            }
		        };
		    decoEnsei.postDelayed(clickButton, 3500);
			
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
