package com.example.schoolinhand;

import android.provider.BaseColumns;

public class TableData {

	public TableData(){
		
	}
	public static final String DATABASE_NAME = "gestion_notes";
	
	public static abstract class Enseignant implements BaseColumns
	{
	public static final String TABLE_NAME = "Enseignant";
	public static final String ID = "id";
	public static final String NOM = "ens_nom";
	public static final String PRENOM = "ens_prenom";
	public static final String EMAIL = "ens_email";
	public static final String PASSWORD = "ens_pass";
	public static final String CIN = "ens_cin";
		
	}
	
	public static abstract class Classe implements BaseColumns
	{
	public static final String TABLE_NAME = "Classe";
	public static final String ID = "id";
	public static final String NOM_CLASSE = "nom_classe";
		
	}
	
	public static abstract class Etudiant implements BaseColumns
	{
		public static final String TABLE_NAME = "Etudiant";
		public static final String ID = "id";
		public static final String NOM = "etud_nom";
		public static final String PRENOM = "etud_prenom";
		public static final String EMAIL = "etud_email";
		public static final String PASSWORD = "etud_pass";
		public static final String CIN = "etud_cin";
		public static final String ID_CLASSE ="id_classe";
	}
	
	public static abstract class Matiere implements BaseColumns
	{
		public static final String TABLE_NAME = "Matiere";
		public static final String NOM = "mat_nom";
		public static final String ID = "id";
		public static final String ID_CLASSE ="id_classe";
		public static final String ID_ENS ="id_enseig";
	}
	
	public static abstract class Note implements BaseColumns
	{
		public static final String TABLE_NAME = "Note";
		public static final String VALUE = "valeur";
		public static final String ID = "id";
		public static final String ID_ETUD ="id_etud";
		public static final String ID_MAT ="id_mat";
	}
	
}
