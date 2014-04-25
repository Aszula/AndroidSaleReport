package com.example.salesreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseConnector {
	private static final String DATABASE_NAME = "myReports";
	private SQLiteDatabase database;
	private DatabaseOpenHelper databaseOpenHelper;
	
	public DatabaseConnector(Context context)
	{
		databaseOpenHelper = 
				new DatabaseOpenHelper(context, DATABASE_NAME, null, 1);
	}
	
	public void open() throws SQLException
	{
		database = databaseOpenHelper.getWritableDatabase();
	}
	
	public void close()
	{
		if(database != null)
			database.close();
	}
	
	public void insertCall(String type, String reason, String detail, String followup)
	{
		try
		{
			ContentValues newCall = new ContentValues();
			newCall.put("type", type);
			newCall.put("reason", reason);
			newCall.put("detail", detail);
			newCall.put("followup", followup);
			open();
			database.insert("callReports", null, newCall);
			close();
		}
		catch (Exception e)
		{
			
		}
	}
	
	public void updateCall(long id, String type, String reason, String detail, String followup)
	{
		ContentValues editCall = new ContentValues();
		editCall.put("type",type);
		editCall.put("reason",reason);
		editCall.put("detail",detail);
		editCall.put("followup",followup);
		
		open();
		database.update("callReports", editCall, "_id=" + id, null);
	}
	
	public Cursor getAllCalls()
	{
		return database.query("callReports", new String[] {"_id", "type","reason","detail","followup"},
				null, null, null, null, null, "type");
	}
	
	public Cursor getOneCall(long id)
	{
		return database.query("callReports", null, "_id=" + id, null, null, null, null, null);
	}
	
	public void deleteCall(long id)
	{
		open();
		database.delete("callReports","_id=" + id,null);
		close();
	}
	
	
	private class DatabaseOpenHelper extends SQLiteOpenHelper
	{

		public DatabaseOpenHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createQuery = "CREATE TABLE callReports" +
					 "(_id integer primary key autoincrement," +
					 "type TEXT," +
					 "reason TEXT," +
					 "detail TEXT," +
					 "followup TEXT);";
			
			db.execSQL(createQuery);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
