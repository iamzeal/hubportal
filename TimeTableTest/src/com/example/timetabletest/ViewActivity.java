package com.example.timetabletest;

import java.util.ArrayList;

//import com.shikhar.cs3.R;

import android.support.v7.app.ActionBarActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class ViewActivity extends ActionBarActivity {
	SQLiteDatabase db;
	DataBaseHelper dbAdapter;
	ListView lv;
	MainActivity ma;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{  Bundle bundle = getIntent().getExtras();
	    String day1 = bundle.getString("dayoo");
		
		System.out.println("adadafasfgasdfa"+day1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		
		dbAdapter=new DataBaseHelper(this);
		db=dbAdapter.getReadableDatabase();
		Cursor cursor=db.query(false,"cs3class_vi",null,null,null,null,null,null,null);
		String DayString=null;
	
		//Cursor c=db.query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit, cancellationSignal)
		
		try{
		
			ArrayList<String> list=new ArrayList<String>();
			
			
			while(cursor.moveToNext())
			{
				
				DayString=cursor.getString(cursor.getColumnIndex(day1));
				
				list.add("\n"+DayString);
			}
			ArrayAdapter <String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
			lv=(ListView)findViewById(R.id.listView1);
			lv.setAdapter(arrayAdapter);
			
		}
	catch(Exception e)
	{
		
		Log.d("ExceptionErrorulalal",e.toString());
	}
	}
}

	