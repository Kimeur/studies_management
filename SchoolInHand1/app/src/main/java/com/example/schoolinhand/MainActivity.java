package com.example.schoolinhand;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    
	Button goTo;
	TextView user, pass;
	String name, pwd,typeau;
	Spinner type;
	Context ctx = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.authentification);
		
		goTo = (Button) findViewById(R.id.Go);
		user = (TextView) findViewById(R.id.Username);
		pass = (TextView) findViewById(R.id.Password);
		type = (Spinner)findViewById(R.id.Type);
		
		ArrayList<String> cl = new ArrayList();
		cl.add("Administrateur");
		cl.add("Enseignant");
		cl.add("Etudiant");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, cl);
        type.setAdapter(adapter);
		
		goTo.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	name = user.getText().toString();
				pwd = pass.getText().toString();
				typeau = type.getSelectedItem().toString();
				
				DatabaseOperations dp = new DatabaseOperations(ctx);
				
				if(dp.checkAuthentication(dp, name, pwd, typeau)){
				user.setText("");
				pass.setText("");
				Toast.makeText(getBaseContext(), "Login ou mot de passe erroné!!", Toast.LENGTH_LONG).show();
				}
				else{
			   Toast.makeText(getBaseContext(), "Authenticating...", Toast.LENGTH_LONG).show();
		        Runnable clickButton = new Runnable() {
		            @Override
		            public void run() {
		            	
							if(typeau == "Administrateur"){
							Intent secondeActivite = new Intent(MainActivity.this,
									AdminActivity.class);
					
									startActivity(secondeActivite);}
							
							if(typeau == "Enseignant"){
								Intent Activite = new Intent(MainActivity.this,
										EnseiActivity.class);
						
										startActivity(Activite);}
							
							if(typeau == "Etudiant"){
								Intent Activite = new Intent(MainActivity.this,
										EtudActivity.class);
						
										startActivity(Activite);}
							
		            }
		        };
		    goTo.postDelayed(clickButton, 3500);
				}}
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
