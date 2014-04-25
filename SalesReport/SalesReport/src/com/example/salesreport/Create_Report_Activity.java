package com.example.salesreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Create_Report_Activity extends Activity {
		RadioGroup rg;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_report_);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create__report_, menu);
		return true;
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent main = new Intent(this, Home.class);
		startActivity(main);
		finish();
		super.onBackPressed();
	}
	
	/*RadioGroup rg1 =(RadioGroup)findViewById(R.id.radioGroup1);
	int selected=rg.getCheckedRadioButtonId();
	RadioButton rb=(RadioButton)findViewById(selected),
	Father_spouse=(RadioButton) rb.getText();
	*/
	
}

