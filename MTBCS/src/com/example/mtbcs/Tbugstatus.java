package com.example.mtbcs;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Tbugstatus extends Activity {
	ImageView out;
	TextView aaa;
	SQLiteDatabase db;
	ListView l;
	EditText t1;
	 ArrayList<String> list1;
	 ArrayAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tbugstatus);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		aaa=(TextView)findViewById(R.id.textView2);
		aaa.setText(globalvariabel.GetUsername().toString());
		out=(ImageView)findViewById(R.id.imageView1);
		t1=(EditText)findViewById(R.id.search);
		db=openOrCreateDatabase("HAWK", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists bug(tid varchar, bid varchar, type varchar,did varchar,bug varchar,status varchar);");
		l = (ListView) findViewById(R.id.listView1);
		final ArrayList<String> list = new ArrayList<String>();
		 list1 = new ArrayList<String>();
		 Cursor res=db.rawQuery("SELECT * FROM bug where tid='"+aaa.getText()+"'", null);
		if(res.getCount()!=0)
		{
			while (res.moveToNext())
			{
	            list.add("Tester ID:   "+res.getString(0)+"\nBug ID:   "+res.getString(1)+"\n"+"Type:   "+res.getString(2)+"\n"+"Developer Id:   "+res.getString(3)+"\n"+"Bug:   "+res.getString(4)+"\n"+"Status:   "+res.getString(5));
	            list1.add(res.getString(1));
			}
		}
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
		l.setAdapter(adapter);
		
		
		// (close)
		
		/// search (start)
		
		t1.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				 Tbugstatus.this.adapter.getFilter().filter(s); 
				
			}
			
		});
	}
		// (close)
		
		// alert dialog
		
		/* 
		l.setAdapter(adapter);
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				
				 
				 // two buttons (start)
				  // TODO Auto-generated method stub
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(Admin.this);
				 
		        // Setting Dialog Title
		        alertDialog.setTitle("Confirm Delete...");
		 
		        // Setting Dialog Message
		        alertDialog.setMessage("Are you sure you want delete this?");
		 
		        // Setting Icon to Dialog
		        alertDialog.setIcon(R.drawable.a);
		 
		        // Setting Positive "Yes" Button
		        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog,int which) {
		 
		            // Write your code here to invoke YES event
		            	Cursor c=db.rawQuery("SELECT * FROM job", null);
		        		if(c.moveToFirst())
		        		{
		        			db.execSQL("DELETE FROM job WHERE id='"+c.getString(1)+"'");
		        			 Toast.makeText(getApplicationContext(), "User Deleted Successfully", Toast.LENGTH_SHORT).show();
		        			 Intent a=new Intent(getApplicationContext(),Admin.class);
		        			 startActivity(a);
		        			 return;
		        		}	
		            }
		        });
		        
		        //
		        
		        
		 
		        // Setting Negative "NO" Button
		        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {
		            // Write your code here to invoke NO event
		            Intent b=new Intent(getApplicationContext(),Admin.class);
		            startActivity(b);
		            Toast.makeText(getApplicationContext(), "Refreshed Successfully", Toast.LENGTH_SHORT).show();
		            dialog.cancel();
		            }
		        });
		     // view Button
			     // Setting Negative "NO" Button
			        alertDialog.setNegativeButton("VIEW", new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int which) {
			            // Write your code here to invoke NO event
			            
			            Toast.makeText(getApplicationContext(), "Refreshed Successfully", Toast.LENGTH_SHORT).show();
			            dialog.cancel();
			            }
			        });
		        // Showing Alert Message
		        alertDialog.show();
				
				// (close)
			}
		});
		
		 */
		
		//
		///logout

	 public void showMessage(String title,String message)
	    {
	    	Builder builder=new Builder(this);
	    	builder.setCancelable(true);
	    	builder.setTitle(title);
	    	builder.setMessage(message);
	    	builder.show();
		}
	 
	 
}
