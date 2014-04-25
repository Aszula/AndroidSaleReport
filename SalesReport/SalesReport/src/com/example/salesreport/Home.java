package com.example.salesreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	public void CreateHandler(View v){
		Intent create = new Intent(this,Create_Report_Activity.class);
		startActivity(create);
	}
	
	public void EditViewHandler(View v){
		Intent create = new Intent(this,View_Edit_Activity.class);
		startActivity(create);
	}
}
