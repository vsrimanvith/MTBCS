package com.example.mtbcs;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeDeveloper extends Activity {
	Button ab,bs,pr,log;
	TextView aaa;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_developer);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		aaa=(TextView)findViewById(R.id.textView2);
		aaa.setText(globalvariabel.GetUsername().toString());
		ab=(Button)findViewById(R.id.button1);
		bs=(Button)findViewById(R.id.button2);
		pr=(Button)findViewById(R.id.button3);
		log=(Button)findViewById(R.id.button4);
		db=openOrCreateDatabase("HAWK", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists pro(id varchar, pass varchar,email varchar,mbl varchar);");
		db.execSQL("create table if not exists sreg(emp varchar, id varchar, pass varchar,email varchar,mbl varchar);");
		db.execSQL("create table if not exists dreg(emp varchar, id varchar, pass varchar,email varchar,mbl varchar);");
		db.execSQL("create table if not exists treg(emp varchar, id varchar, pass varchar,email varchar,mbl varchar);");
		ab.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),Drepbug.class));
			}
		});
bs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor c=db.rawQuery("SELECT * FROM pro", null);
				if(c.getCount()==0)
				{
					showMessage("Error", "No records found");
					return;
				}
				StringBuffer buffer=new StringBuffer();
				while(c.moveToNext())
		            		{
					buffer.append("Project ID: "+c.getString(0)+"\n");
					buffer.append("Name: "+c.getString(1)+"\n");
					buffer.append("Company Name: "+c.getString(2)+"\n");
					buffer.append("Description: "+c.getString(3)+"\n\n");
				}
				showMessage("Project Details", buffer.toString());
			}
		});
log.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(new Intent(getApplicationContext(),Home.class));
	}
});
pr.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Cursor c=db.rawQuery("SELECT * FROM dreg WHERE id='"+aaa.getText()+"'", null);
		if(c.getCount()==0)
		{
			showMessage("Error", "No records found");
			return;
		}
		StringBuffer buffer=new StringBuffer();
		while(c.moveToNext())
		{
			buffer.append("Developer ID: "+c.getString(1)+"\n");
			buffer.append("Password: "+c.getString(2)+"\n");
			buffer.append("Email Id: "+c.getString(3)+"\n");
			buffer.append("Mobile No: "+c.getString(4)+"\n");
		}
		showMessage("Developer Profile Details", buffer.toString());
	}
});
	}

	public void showMessage(String title,String message)
    {
    	Builder builder=new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
	}
	
	 @Override
	    public void onBackPressed() {
	    	// TODO Auto-generated method stub
	    	 Toast.makeText(getApplicationContext(), "Please press Logout button goto Page", Toast.LENGTH_LONG).show();
	    }

}
