package com.example.timetabletest;

import java.io.IOException;

import com.example.timetabletest.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {
	final String[] days = {
		      "Monday",
		      "Tuesday",
		      "Wednesday",
		      "Thursday",
		      "Friday",
		      "Saturday",
		      		      
		  };
	String day;
   // final Spinner dayobj = (Spinner) findViewById(R.id.spinner1);
    public void vieww(View v)
	{   Spinner dayobj=(Spinner)findViewById(R.id.spinner1);
	day = dayobj.getSelectedItem().toString();
	System.out.println("adadadafasfasfasdfdff "+day);
    	
		Intent intent=new Intent (MainActivity.this, ViewActivity.class);
		intent.putExtra("dayoo", day);
		startActivity(intent);
			
	}
    
    
	//Button view=(Button)findViewById(R.id.button1);
	 
	@Override

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        final Spinner dayobj = (Spinner) findViewById(R.id.spinner1);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
		        this, R.layout.spinner_item  , days);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		dayobj.setAdapter(adapter);
		DataBaseHelper myDbHelper = new DataBaseHelper(null);
        myDbHelper = new DataBaseHelper(this);
 
        try {
 
        	myDbHelper.createDataBase();
 
 	} catch (IOException ioe) {
 
 		throw new Error("Unable to create database");
 
 	}
 
 	try {
 
 		myDbHelper.openDataBase();
 
 	}catch(SQLException sqle){
 
 		throw sqle;
 
 	}
 	
	
	Button view=(Button)findViewById(R.id.button1);
	
    		
	
		
		
	
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
