package com.example.mtbcs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Home extends Activity {
	Button reg,log;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		reg=(Button)findViewById(R.id.button1);
		reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Home.this,Reg.class));
			}
		});
		log=(Button)findViewById(R.id.button2);
		log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Home.this,Login.class));
			}
		});
		
		
	}
	@Override
    public void onBackPressed() {
    	// TODO Auto-generated method stub
    	 Toast.makeText(getApplicationContext(), "you Cant Perform This Action", Toast.LENGTH_LONG).show();
    }
	

}
