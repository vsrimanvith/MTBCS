package com.example.mtbcs;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Reg extends Activity implements OnClickListener{
	Spinner sp;
	String u,u1,u2;
	EditText id,ps,em,mb;
	Button sub;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		sp=(Spinner)findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> ar=ArrayAdapter.createFromResource(this, R.array.week, android.R.layout.simple_list_item_1);
		ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(ar);
		db=openOrCreateDatabase("HAWK", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists sreg(emp varchar, id varchar, pass varchar,email varchar,mbl varchar);");
		db.execSQL("create table if not exists dreg(emp varchar, id varchar, pass varchar,email varchar,mbl varchar);");
		db.execSQL("create table if not exists treg(emp varchar, id varchar, pass varchar,email varchar,mbl varchar);");		
		id=(EditText)findViewById(R.id.editText1);
		ps=(EditText)findViewById(R.id.editText2);
		em=(EditText)findViewById(R.id.editText3);
		mb=(EditText)findViewById(R.id.editText4);
		sub=(Button)findViewById(R.id.button1);
		sub.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String u = sp.getSelectedItem().toString();
		String myUser = "Super User";
		if((v==sub) && u.equals(myUser))
    	{
    	
    		if(id.getText().toString().trim().length()==0||
    		   ps.getText().toString().trim().length()==0||
    		   em.getText().toString().trim().length()==0||mb.getText().toString().trim().length()==0)
    		{
    			Toast.makeText(getApplicationContext(),"Please Enter All Values", Toast.LENGTH_SHORT).show();
    			return;
    		}
    		else if(mb.getText().toString().trim().length()!=10)
    		{
    			
    			Toast.makeText(getApplicationContext(),"Enter 10 Digit Mobile No", Toast.LENGTH_SHORT).show();
    			return;
    		}
    		else if(mb.getText().length()==10){
    			if(mb.getText().toString().startsWith("7")||
    					mb.getText().toString().startsWith("8")||
    					mb.getText().toString().startsWith("9")){
    			}
    			else{
    				mb.setError("Enter Mobile Numbers starting with 7,8 or 9");
    				return;
    			}
    		}
    		else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(em.getText().toString()).matches())
    		{
    			Toast.makeText(getApplicationContext(),"Enter Proper Email ID", Toast.LENGTH_SHORT).show();
    			return;
    		}
    		
    		Cursor c=db.rawQuery("SELECT * FROM sreg WHERE email='"+em.getText()+"'", null);
    		if(c.moveToFirst())
    		{
    			Toast.makeText(getApplicationContext(),"Email ID Already Exists", Toast.LENGTH_SHORT).show();
    			return;
    		}
    		
    		db.execSQL("INSERT INTO sreg VALUES('"+sp.getSelectedItem()+"','"+id.getText()+
    				   "','"+ps.getText()+"','"+em.getText()+"','"+mb.getText()+"');");
    		Toast.makeText(getApplicationContext(),"Super user Registration Successfully Done", Toast.LENGTH_SHORT).show();
    		clearText();
    		return;
    	}
		
		String u1 = sp.getSelectedItem().toString();
		String myUser1 = "Developer";
		if((v==sub) && u1.equals(myUser1))
    	{
    	
    		if(id.getText().toString().trim().length()==0||
    		   ps.getText().toString().trim().length()==0||
    		   em.getText().toString().trim().length()==0||mb.getText().toString().trim().length()==0)
    		{
    			Toast.makeText(getApplicationContext(),"Please Enter All Values", Toast.LENGTH_SHORT).show();
    			return;
    		}
    		else if(mb.getText().toString().trim().length()!=10)
    		{
    			Toast.makeText(getApplicationContext(),"Enter 10 Digit Mobile No", Toast.LENGTH_SHORT).show();
    			return;
    		}
    		else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(em.getText().toString()).matches())
    		{
    			Toast.makeText(getApplicationContext(),"Enter Proper Email ID", Toast.LENGTH_SHORT).show();
    			return;
    		}
    		
    		Cursor c=db.rawQuery("SELECT * FROM dreg WHERE email='"+em.getText()+"'", null);
    		if(c.moveToFirst())
    		{
    			Toast.makeText(getApplicationContext(),"Email ID Already Exists", Toast.LENGTH_SHORT).show();
    			return;
    		}
    		
    		db.execSQL("INSERT INTO dreg VALUES('"+sp.getSelectedItem()+"','"+id.getText()+
    				   "','"+ps.getText()+"','"+em.getText()+"','"+mb.getText()+"');");
    		Toast.makeText(getApplicationContext(),"Developer Registration Successfully Done", Toast.LENGTH_SHORT).show();
    		clearText();
    		return;
    	}
		else
		{
			if(id.getText().toString().trim().length()==0||
		    		   ps.getText().toString().trim().length()==0||
		    		   em.getText().toString().trim().length()==0||mb.getText().toString().trim().length()==0)
		    		{
		    			Toast.makeText(getApplicationContext(),"Please Enter All Values", Toast.LENGTH_SHORT).show();
		    			return;
		    		}
			else if(mb.getText().toString().trim().length()!=10)
    		{
    			Toast.makeText(getApplicationContext(),"Enter 10 Digit Mobile No", Toast.LENGTH_SHORT).show();
    			return;
    		}
    		else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(em.getText().toString()).matches())
    		{
    			Toast.makeText(getApplicationContext(),"Enter Proper Email ID", Toast.LENGTH_SHORT).show();
    			return;
    		}
		    		
		    		Cursor c=db.rawQuery("SELECT * FROM treg WHERE email='"+em.getText()+"'", null);
		    		if(c.moveToFirst())
		    		{
		    			Toast.makeText(getApplicationContext(),"Email ID Already Exists", Toast.LENGTH_SHORT).show();
		    			return;
		    		}
		    		
		    		db.execSQL("INSERT INTO treg VALUES('"+sp.getSelectedItem()+"','"+id.getText()+
		    				   "','"+ps.getText()+"','"+em.getText()+"','"+mb.getText()+"');");
		    		Toast.makeText(getApplicationContext(),"Tester Registration Successfully Done", Toast.LENGTH_SHORT).show();
		    		clearText();	
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
	    public void clearText()
	    {
	    	id.setText("");
	    	ps.setText("");
	    	em.setText("");
	    	mb.setText("");
	    }

}
