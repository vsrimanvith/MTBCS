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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dasignbug extends Activity implements OnClickListener{
	TextView bid;
	SQLiteDatabase db;
	Button vieww,sub;
	EditText did;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dasignbug);
		bid=(TextView)findViewById(R.id.textView3);
		Bundle b = getIntent().getExtras();
		bid.setText(b.getCharSequence("Name"));
		
		sub=(Button)findViewById(R.id.button2);
		sub.setOnClickListener(this);
		did=(EditText)findViewById(R.id.editText1);
		db=openOrCreateDatabase("HAWK", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists bug(tid varchar, bid varchar, type varchar,did varchar,bug varchar,status varchar);");
		db.execSQL("create table if not exists dreg(emp varchar, id varchar, pass varchar,email varchar,mbl varchar);");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v==sub)
    	{
    		if(did.getText().toString().trim().length()==0)
    		{
    			Toast.makeText(getApplicationContext(), "Enter Developer Id", Toast.LENGTH_SHORT).show();
				return;
    		}
    		Cursor c=db.rawQuery("SELECT * FROM bug WHERE bid='"+bid.getText()+"'", null);
    		if(c.moveToFirst())
    		{
    			db.execSQL("UPDATE bug SET status='"+did.getText()+"' WHERE bid='"+bid.getText()+"'");
    			Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
    			clr();
    			startActivity(new Intent(getApplicationContext(),Drepbug.class));
				return;
    		}
    		else
    		{
    			Toast.makeText(getApplicationContext(), "Invalid Details", Toast.LENGTH_SHORT).show();
				return;    		
				}
    		
    	}
		
	}

	public void showMessage(String title,String message)
    {
    	Builder builder=new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
	}
	public void clr()
	{
		did.setText("");
	}

}
