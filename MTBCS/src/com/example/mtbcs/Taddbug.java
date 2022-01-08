package com.example.mtbcs;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Taddbug extends Activity {
	TextView aaa,bid;
	SQLiteDatabase db;
	Button sub;
	EditText bug;
	RadioGroup acc;
	RadioButton ac;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taddbug);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		aaa=(TextView)findViewById(R.id.textView2);
		aaa.setText(globalvariabel.GetUsername().toString());
		bid=(TextView)findViewById(R.id.textView4);
		bid.setText(generatePIN());
		sub=(Button)findViewById(R.id.button1);
		bug=(EditText)findViewById(R.id.editText1);
		
		acc=(RadioGroup)findViewById(R.id.radioGroup1);
		int ssid=acc.getCheckedRadioButtonId();
		ac=(RadioButton)findViewById(ssid);
		
		db=openOrCreateDatabase("HAWK", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists bug(tid varchar, bid varchar, type varchar,did varchar,bug varchar,status varchar);");
		sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(bug.getText().toString().trim().length()==0)
				{
					Toast.makeText(getApplicationContext(), "Enter Bug Description", Toast.LENGTH_SHORT).show();
					return;
				}
				db.execSQL("insert into bug values('"+aaa.getText()+"','"+bid.getText()+"','"+ac.getText()+"','"+null+"','"+bug.getText()+"','"+null+"');");
				Toast.makeText(getApplicationContext(), "Bug Sent Successfully", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(getApplicationContext(),HomeTester.class));
				
			}
		});
		
	}

	
	public String generatePIN() 
	   {
	        //generate a 4 digit integer 1000 <10000
	        int randomPIN = (int)(Math.random()*9000)+1000;
	        //Store integer in a string
	        return String.valueOf(randomPIN);

	    }
	public void clr()
	{
		bug.setText("");
	}
}
