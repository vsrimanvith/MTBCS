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

public class HomeAdmin extends Activity {
	Button ab,bs,pr,log;
	TextView aaa;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_admin);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		aaa=(TextView)findViewById(R.id.textView2);
		aaa.setText(globalvariabel.GetUsername().toString());
		ab=(Button)findViewById(R.id.button1);
		bs=(Button)findViewById(R.id.button2);
		pr=(Button)findViewById(R.id.button3);
		log=(Button)findViewById(R.id.button4);
		ab.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),Aviewbugs.class));
			}
		});
bs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),Aviewreg.class));
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
		showMessage("DEVELOPED BY","MIND TECH BUG COMPONENT SYSTEM IN SOFTWARE ORGANIZATION  \n GUIDE NAME: SURESH \n MOBILE NO:9700664440");
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
