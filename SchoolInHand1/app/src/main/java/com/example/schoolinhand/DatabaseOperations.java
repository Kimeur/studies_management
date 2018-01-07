package com.example.schoolinhand;

import com.example.schoolinhand.TableData.Enseignant;

import java.util.ArrayList;

import com.example.schoolinhand.TableData.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseOperations extends SQLiteOpenHelper {
	public static final int database_version = 2;
	
	public String CREATE_TABLE_ENSEIGNANT =
			"CREATE TABLE " + Enseignant.TABLE_NAME +" (" +
	                Enseignant.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					Enseignant.NOM + " TEXT, " +
					Enseignant.PRENOM + " TEXT, " +
					Enseignant.EMAIL + " TEXT, " +
					Enseignant.PASSWORD + " TEXT, " +
					Enseignant.CIN + " TEXT "+
	                ");";
	
	public String CREATE_TABLE_CLASSE =
			"CREATE TABLE " + Classe.TABLE_NAME +" (" +
	                Classe.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					Classe.NOM_CLASSE + " TEXT " +
	                ");";
	
	public String CREATE_TABLE_ETUDIANT =
			"CREATE TABLE " + Etudiant.TABLE_NAME +" (" +
	                Etudiant.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					Etudiant.NOM + " TEXT, " +
					Etudiant.PRENOM + " TEXT, " +
					Etudiant.EMAIL + " TEXT, " +
					Etudiant.PASSWORD + " TEXT, " +
					Etudiant.CIN + " TEXT, "+
					Etudiant.ID_CLASSE + " INTEGER, " +
		"FOREIGN KEY(" + Etudiant.ID_CLASSE+ ") REFERENCES " + Classe.TABLE_NAME+"(id));";
	
	public String CREATE_TABLE_MATIERE =
			"CREATE TABLE " + Matiere.TABLE_NAME +" (" +
	                Matiere.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					Matiere.NOM + " TEXT, " +
	                Matiere.ID_CLASSE + " INTEGER, " +
					Matiere.ID_ENS + " INTEGER, " +
	   "FOREIGN KEY(" + Matiere.ID_CLASSE+ ") REFERENCES " + Classe.TABLE_NAME+"(id), "+
	   "FOREIGN KEY(" + Matiere.ID_ENS+ ") REFERENCES " + Enseignant.TABLE_NAME+"(id));";        
					
	public String CREATE_TABLE_NOTE =
			"CREATE TABLE " + Note.TABLE_NAME +" (" +
	                Note.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					Note.VALUE + " REAL, " +
					Note.ID_ETUD + " INTEGER, " +
					Note.ID_MAT + " INTEGER, " +
		"FOREIGN KEY(" + Note.ID_ETUD + ") REFERENCES " + Etudiant.TABLE_NAME+"(id), "+
		"FOREIGN KEY(" + Note.ID_MAT + ") REFERENCES " + Matiere.TABLE_NAME+"(id));";
	
	
	public DatabaseOperations(Context context) {
	  
		super(context, TableData.DATABASE_NAME, null, database_version);
	    Log.d("Database operations", "Databse created successfully!");
	}
	
	@Override
	public void onCreate(SQLiteDatabase sdb) {
		
		sdb.execSQL(CREATE_TABLE_CLASSE);
		sdb.execSQL(CREATE_TABLE_ENSEIGNANT);
		sdb.execSQL(CREATE_TABLE_ETUDIANT);
		sdb.execSQL(CREATE_TABLE_MATIERE);
		sdb.execSQL(CREATE_TABLE_NOTE);
		Log.d("Database operations", "Tables created");

	}

	@Override
	public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2) {
		// TODO Auto-generated method stub 
		sdb.execSQL("Drop Table if exists " + Enseignant.TABLE_NAME);
		sdb.execSQL("Drop Table if exists " + Classe.TABLE_NAME);
		sdb.execSQL("Drop Table if exists " + Etudiant.TABLE_NAME);
		sdb.execSQL("Drop Table if exists " + Matiere.TABLE_NAME);
		sdb.execSQL("Drop Table if exists " + Note.TABLE_NAME);
		onCreate(sdb);
		

	}
	
	public void ajouterClasse(DatabaseOperations dop, String name)
	{
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(Classe.NOM_CLASSE, name);
		SQ.insert(Classe.TABLE_NAME, null, cv);
		Log.d("Database operations", "1 row inserted.");
		
	}
	
	public boolean ajouterEtudiant(DatabaseOperations dop, String nom, String prenom, String email, String cin, String classe)
	{
		
		
		
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		Cursor c = SQ.rawQuery("select " + Classe.ID + " from " + Classe.TABLE_NAME
				+ " where nom_classe = '" + classe + "'" , null);
		
		int id = 0;
		if(!c.moveToFirst()) return false;
		id = c.getInt(0);
		Log.d("cursor", ""+ id);
		
		c.close();
			
		cv.put(Etudiant.NOM, nom);
		cv.put(Etudiant.PRENOM, prenom);
		cv.put(Etudiant.EMAIL, email);
		cv.put(Etudiant.CIN, cin);
		cv.put(Etudiant.ID_CLASSE, id);
		cv.put(Etudiant.PASSWORD, cin);
		SQ.insert(Etudiant.TABLE_NAME, null, cv);
		return true;
		
	}
	
	public boolean ajouterEnseignant(DatabaseOperations dop, String nom, String prenom, String email, String cin)
	{
		
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
			
		cv.put(Enseignant.NOM, nom);
		cv.put(Enseignant.PRENOM, prenom);
		cv.put(Enseignant.EMAIL, email);
		cv.put(Enseignant.CIN, cin);
		cv.put(Enseignant.PASSWORD, cin);
		SQ.insert(Enseignant.TABLE_NAME, null, cv);
		return true;
		
	}
	
	public ArrayList<String> getClasses(DatabaseOperations dop){
		
		ArrayList<String> liste = new ArrayList();
		
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		Cursor c = SQ.rawQuery("select * from classe" , null);
		
		String nom;
		while(c.moveToNext()){ 
		nom = c.getString(1);
		liste.add(nom);
		}
		c.close();
		
		return liste;
	}
	
    public ArrayList<String> getTeachers(DatabaseOperations dop){
		
		ArrayList<String> liste = new ArrayList();
		
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		Cursor c = SQ.rawQuery("select * from enseignant" , null);
		
		String nom;
		while(c.moveToNext()){ 
		nom = c.getString(1);
		liste.add(nom);
		}
		c.close();
		
		return liste;
	}
    
	public ArrayList<String> getMatieres(DatabaseOperations dop){
			
			ArrayList<String> liste = new ArrayList();
			
			SQLiteDatabase SQ = dop.getWritableDatabase();
			ContentValues cv = new ContentValues();
			
			Cursor c = SQ.rawQuery("select * from matiere" , null);
			
			String nom;
			while(c.moveToNext()){ 
			nom = c.getString(1);
			liste.add(nom);
			}
			c.close();
			
			return liste;
		}
	
	public ArrayList<String> getStudents(DatabaseOperations dop){
		
		ArrayList<String> liste = new ArrayList();
		
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		Cursor c = SQ.rawQuery("select * from etudiant" , null);
		
		String nom, prenom;
		while(c.moveToNext()){ 
		nom = c.getString(1);
		liste.add(nom);
		}
		c.close();
		
		return liste;
	}
	
public ArrayList<String> getStudentsPerClasse(DatabaseOperations dop, String classe){
		
		ArrayList<String> liste = new ArrayList();
		
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		//Recuperer l'id de la classe
				Cursor c = SQ.rawQuery("select " + Classe.ID + " from " + Classe.TABLE_NAME
						+ " where nom_classe = '" + classe + "'" , null);
				
				int id = 0;
				c.moveToFirst();
				id = c.getInt(0);
				c.close();
		
		Cursor c1 = SQ.rawQuery("select * from etudiant where id_classe = " + id , null);
		
		String nom;
		while(c1.moveToNext()){ 
		nom = c1.getString(1);
		liste.add(nom);
		}
		c1.close();
		
		return liste;
	}
	
	
	public boolean ajouterMatiere(DatabaseOperations dop, String nom, String classe, String enseignant)
	{
		
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		//Recuperer l'id de la classe
		Cursor c = SQ.rawQuery("select " + Classe.ID + " from " + Classe.TABLE_NAME
				+ " where nom_classe = '" + classe + "'" , null);
		
		int id = 0;
		if(!c.moveToFirst()) return false;
		id = c.getInt(0);
		Log.d("cursor", ""+ id);
		
		c.close();
		
		//Recuperer l'id de l'enseignant
		Cursor c1 = SQ.rawQuery("select " + Enseignant.ID + " from " + Enseignant.TABLE_NAME
				+ " where ens_nom = '" + enseignant + "'" , null);
		
		int id_ens = 0;
		if(!c1.moveToFirst()) return false;
		id_ens = c1.getInt(0);
		Log.d("cursor", ""+ id_ens);
		
		c1.close();
		
			
		cv.put(Matiere.NOM, nom);
		cv.put(Matiere.ID_CLASSE, id);
		cv.put(Matiere.ID_ENS, id_ens);
		SQ.insert(Matiere.TABLE_NAME, null, cv);
		return true;
		
	}
	
	public boolean ajouterNote(DatabaseOperations dop, Float value, String matiere, String etudiant)
	{
		
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		//Recuperer l'id de la matiere
		Cursor c = SQ.rawQuery("select " + Matiere.ID + " from " + Matiere.TABLE_NAME
				+ " where mat_nom = '" + matiere + "'" , null);
		
		int id = 0;
		if(!c.moveToFirst()) return false;
		id = c.getInt(0);
		
		c.close();
		
		//Recuperer l'id de l'etudiant
		Cursor c1 = SQ.rawQuery("select " + Etudiant.ID + " from " + Etudiant.TABLE_NAME
				+ " where etud_nom = '" + etudiant + "'" , null);
		
		int id_etud = 0;
		if(!c1.moveToFirst()) return false;
		id_etud = c1.getInt(0);
		
		c1.close();
		
			
		cv.put(Note.VALUE, value);
		cv.put(Note.ID_ETUD, id_etud);
		cv.put(Note.ID_MAT, id);
		SQ.insert(Note.TABLE_NAME, null, cv);
		return true;
		
	}
	
	public boolean checkAuthentication(DatabaseOperations dop, String username, String password, String type){
		
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		boolean val = false;
	          
		//Authentification enseignant
		if(type=="Enseignant"){
				Cursor c = SQ.rawQuery("select * from " + Enseignant.TABLE_NAME
						+ " where ens_email = '" + username + "'" , null);
			 
				if(!c.moveToFirst()){ return false;}
				else{
					if((c.getString(3)== username)&&(c.getString(5)== password)) val =  true;
					else val = false;
				}
				
	          }
		
		//Authentification etudiant
		else if(type=="Etudiant"){
						Cursor c = SQ.rawQuery("select * from " + Etudiant.TABLE_NAME
								+ " where etud_email = '" + username + "'" , null);
					 
						if(!c.moveToFirst()){ val = false;}
						else{
							if((c.getString(3)== username)&&(c.getString(5)== password)) val = true;
							else val = false;
						}
						
			          }
				
				//Authentification admin
		else if(type=="Administrateur"){
						if(username !="Admin" || password!="admin") val = false;
						else val = true;
			          }
		else {
			return false;
		}
	          
    return val;
	}
}
