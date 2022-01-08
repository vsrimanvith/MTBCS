package com.example.mtbcs;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Aviewreg extends Activity implements OnClickListener{
	Spinner sp;
	ImageView out;
	TextView aaa;
	SQLiteDatabase db;
	ListView l;
	EditText t1;
	 ArrayList<String> list1;
	 ArrayAdapter adapter;
	 Button sub;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aviewreg);
		sp=(Spinner)findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> ar=ArrayAdapter.createFromResource(this, R.array.week, android.R.layout.simple_list_item_1);
		ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(ar);
		sub=(Button)findViewById(R.id.button1);
		sub.setOnClickListener(this);
		db=openOrCreateDatabase("HAWK", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists sreg(emp varchar, id varchar, pass varchar,email varchar,mbl varchar);");
		db.execSQL("create table if not exists dreg(emp varchar, id varchar, pass varchar,email varchar,mbl varchar);");
		db.execSQL("create table if not exists treg(emp varchar, id varchar, pass varchar,email varchar,mbl varchar);");
		l = (ListView) findViewById(R.id.listView1);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String u = sp.getSelectedItem().toString();
		String myUser = "Super User";
		if((v==sub) && u.equals(myUser))
    	{
    	
    		final ArrayList<String> list = new ArrayList<String>();
   		 list1 = new ArrayList<String>();
   		 Cursor res=db.rawQuery("SELECT * FROM sreg", null);
   		if(res.getCount()!=0)
   		{
   			while (res.moveToNext())
   			{
   	            list.add("Super User ID:   "+res.getString(1)+"\n Password:   "+res.getString(2)+"\n"+"Email ID:   "+res.getString(3)+"\n"+"Mobile:   "+res.getString(4));
   	            list1.add(res.getString(1));
   			}
   		}
   		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
   		l.setAdapter(adapter);
    	}
		
		String u1 = sp.getSelectedItem().toString();
		String myUser1 = "Developer";
		if((v==sub) && u1.equals(myUser1))
    	{
    	
    		final ArrayList<String> list = new ArrayList<String>();
   		 list1 = new ArrayList<String>();
   		 Cursor res=db.rawQuery("SELECT * FROM dreg", null);
   		if(res.getCount()!=0)
   		{
   			while (res.moveToNext())
   			{
   	            list.add("Developer ID:   "+res.getString(1)+"\n Password:   "+res.getString(2)+"\n"+"Email ID:   "+res.getString(3)+"\n"+"Mobile:   "+res.getString(4));
   	            list1.add(res.getString(1));
   			}
   		}
   		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
   		l.setAdapter(adapter);
    	}
		
		
		String u2 = sp.getSelectedItem().toString();
		String myUser2 = "Tester";
		if((v==sub) && u2.equals(myUser2))
    	{
    	
    		final ArrayList<String> list = new ArrayList<String>();
   		 list1 = new ArrayList<String>();
   		 Cursor res=db.rawQuery("SELECT * FROM treg", null);
   		if(res.getCount()!=0)
   		{
   			while (res.moveToNext())
   			{
   	            list.add("Tester ID:   "+res.getString(1)+"\n Password:   "+res.getString(2)+"\n"+"Email ID:   "+res.getString(3)+"\n"+"Mobile:   "+res.getString(4));
   	            list1.add(res.getString(1));
   			}
   		}
   		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
   		l.setAdapter(adapter);
    	}
    	}
		
	}

