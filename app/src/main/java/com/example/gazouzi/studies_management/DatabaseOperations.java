package com.example.gazouzi.studies_management;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations extends SQLiteOpenHelper {
	public static final int database_version = 2;
	private static final String DATABASE_NAME = "studies";

	// Contacts table name
	private static final String STUDENT_DETAIL = "studentDetails";
	private static final String SUBJECT_DETAIL = "subjectDetails";
	private static final String TEACHER_DETAIL = "teacherDetails";
	// Contacts Table Students Columns names
	private static final String STUDENT_ID = "student_id";
	private static final String STUDENT_FIRST_NAME = "student_firstname";
	private static final String STUDENT_LAST_NAME = "student_lastname";
	private static final String AGE = "age";
	private static final String EMAIL = "email";
    private static final String STUDENT_COMMENT = "comment";
	// Contacts Table Subjects Columns names
	private static final String SUBJECT_ID = "subject_id";
	private static final String NAME = "name";
	private static final String DEGREE = "degree";
	private static final String TEACHER_NAME = "teacher_name";
	private static final String SUBJECT_COMMENT = "comment";
	// Contacts Table Teachers Columns names
	private static final String TEACHER_ID = "teacher_id";
	private static final String TEACHER_FIRST_NAME = "teacher_firstname";
	private static final String TEACHER_LAST_NAME = "teacher_lastname";
	private static final String DEPARTEMENT = "departement";
	private static final String TEACHER_COMMENT = "comment";
	

	
	public String CREATE_TABLE_SUBJECT =
			"CREATE TABLE " + SUBJECT_DETAIL +" (" +
					SUBJECT_ID +  " INTEGER PRIMARY KEY, " +
					NAME + " TEXT, " +
					DEGREE + " TEXT, " +
					TEACHER_NAME + " TEXT, " +
					TEACHER_ID + " INTEGER, " +
					SUBJECT_COMMENT + " TEXT, "+
					"FOREIGN KEY ('" + TEACHER_ID + "') REFERENCES " + TEACHER_DETAIL + "('" + TEACHER_ID + "'));";

	public String CREATE_TABLE_STUDENT =
			"CREATE TABLE " + STUDENT_DETAIL +" (" +
					STUDENT_ID +  " INTEGER PRIMARY KEY," +
					STUDENT_FIRST_NAME + " TEXT, " +
					STUDENT_LAST_NAME + " TEXT, " +
					EMAIL + " TEXT, " +
					AGE + " INTEGER, " +
					STUDENT_COMMENT + " TEXT "+");";
	public String CREATE_TABLE_TEACHER =
			"CREATE TABLE " + TEACHER_DETAIL +" (" +
					TEACHER_ID +  " INTEGER PRIMARY KEY," +
					TEACHER_FIRST_NAME + " TEXT, " +
					TEACHER_LAST_NAME + " TEXT, " +
					EMAIL + " TEXT, " +
					DEPARTEMENT + " TEXT, " +
					TEACHER_COMMENT + " TEXT "+");";
	
	
	public DatabaseOperations(Context context) {
	  
		super(context, DATABASE_NAME, null, database_version);
	    Log.d("Database operations", "Database created successfully!");
	}
	
	@Override
	public void onCreate(SQLiteDatabase sdb) {

		sdb.execSQL(CREATE_TABLE_STUDENT);
		sdb.execSQL(CREATE_TABLE_TEACHER);
		sdb.execSQL(CREATE_TABLE_SUBJECT);

		Log.d("Database operations", "Tables created");

	}

	@Override
	public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2) {
		// TODO Auto-generated method stub
		sdb.execSQL("Drop Table if exists " + STUDENT_DETAIL);
		sdb.execSQL("Drop Table if exists " + SUBJECT_DETAIL);
		sdb.execSQL("Drop Table if exists " + TEACHER_DETAIL);
		onCreate(sdb);
		

	}
	
	void addNewStudent(DatabaseOperations dop, String firstname, String lastname, String email, String age, String comment)
	{
		SQLiteDatabase db = dop.getWritableDatabase();
        ContentValues values = new ContentValues();
		Log.d("Database operations", age);
		values.put(STUDENT_FIRST_NAME, firstname);
        values.put(STUDENT_LAST_NAME, lastname);
		values.put(AGE, Integer.parseInt(age));
        values.put(EMAIL, email);
        values.put(STUDENT_COMMENT, comment);
        // Inserting Row
        db.insert(STUDENT_DETAIL, null, values);
        db.close(); // Closing database connection
		
	}
	void addNewSubject(DatabaseOperations dop, String name, String degree, String teacher_name, int teacherId, String comment)
	{
		SQLiteDatabase db = dop.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(NAME, name);
		values.put(DEGREE, degree);
		values.put(TEACHER_NAME, teacher_name);
		values.put(TEACHER_ID, teacherId);
		values.put(SUBJECT_COMMENT, comment);
		// Inserting Row
		db.insert(SUBJECT_DETAIL, null, values);
		db.close(); // Closing database connection

	}
	void addNewTeacher(DatabaseOperations dop, String firstname, String lastname, String email, String departement, String comment)
	{
		SQLiteDatabase db = dop.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(TEACHER_FIRST_NAME, firstname);
		values.put(TEACHER_LAST_NAME, lastname);
		values.put(EMAIL, email);
		values.put(DEPARTEMENT, departement);
		values.put(TEACHER_COMMENT, comment);


		// Inserting Row
		db.insert(TEACHER_DETAIL, null, values);
		db.close(); // Closing database connection

	}

	public List<student> getStudents(DatabaseOperations dop){
		ArrayList<student> list = new ArrayList();
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		Cursor c = SQ.rawQuery("select * from studentDetails" , null);
		while(c.moveToNext()){
            student student_added=new student();
            Log.d("Id" ,c.getString(0));
			student_added.firstname = c.getString(1);
            student_added.lastname =c.getString(2);
            student_added.email=c.getString(3);
            student_added.comment=c.getString(4);
            list.add(student_added);
		}
		c.close();
		return list;
	}
	public List<teacher> getTeachers(DatabaseOperations dop){
		ArrayList<teacher> list_teachers = new ArrayList();
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		Cursor c = SQ.rawQuery("select * from teacherDetails" , null);
		while(c.moveToNext()){
			teacher teacher_added=new teacher();
			Log.d("Id" ,c.getString(0));
			teacher_added.teacherId = c.getInt(0);
			teacher_added.firstname = c.getString(1);
			teacher_added.lastname =c.getString(2);
			teacher_added.email=c.getString(3);
			teacher_added.departement =c.getString(4);
			teacher_added.comment=c.getString(5);
			list_teachers.add(teacher_added);
		}
		c.close();
		return list_teachers;
	}



}
