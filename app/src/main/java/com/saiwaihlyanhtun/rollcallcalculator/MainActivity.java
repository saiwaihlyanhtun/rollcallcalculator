package com.saiwaihlyanhtun.rollcallcalculator;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.view.inputmethod.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	Button calc,cal,about;
	EditText edit1,edit2;
	TextView result,wr;
	double num1,num2,sum,num;
	ImageView img;
    @Override

	public void onCreate(Bundle savedInstanceState) {

	super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		img = (ImageView)findViewById(R.id.img);
		edit1 = (EditText)findViewById(R.id.edit1);
		edit2 = (EditText)findViewById(R.id.edit2);
		result = (TextView)findViewById(R.id.result);
		wr = (TextView)findViewById(R.id.wr);
		calc = (Button)findViewById(R.id.calc);
		cal = (Button)findViewById(R.id.cal);
		about = (Button)findViewById(R.id.about);
		
		cal.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					Intent intent = new Intent(MainActivity.this, cal.class);
					startActivity(intent);

				}});
				
		about.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					Intent intent = new Intent(MainActivity.this, about.class);
					startActivity(intent);

				}});
		calc.setOnClickListener(new OnClickListener() {
			
			@Override
				public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
				imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
				if(v.getId() == R.id.calc) {
					boolean isValidate = true;
					if (edit1.getText().toString().length() <= 0) {
						edit1.setError("Value Required");
						isValidate = false;
						result.setText("ERROR");
						wr.setText("အျပည့္အစံုမထည့္ပဲငာကဘယ္လိုတြက္ရမွာလဲ");
						img.setVisibility(View.INVISIBLE);
						
					} 
					if (edit2.getText().toString().length() <= 0) {
						edit2.setError("Value Required");
						result.setText("ERROR");
						wr.setText("အျပည့္အစံုမထည့္ပဲငာကဘယ္လိုတြက္ရမွာလဲ");
						img.setVisibility(View.INVISIBLE);
						isValidate = false;
					}
					if (isValidate) {
						num1 = Double.parseDouble(edit1.getText().toString());
						num2 = Double.parseDouble(edit2.getText().toString());
						edit1.setError(null);
						num = (num2*7);
						sum = ((num2*7) - num1)*(100/ (num2*7));
						result.setText(Double.toString(sum)+"%");
						img.setVisibility(View.VISIBLE);
						if(sum>0){
							sum = ((num2*7) - num1)*(100/ (num2*7));
							result.setText(Double.toString(sum)+"%");
						}
						else{
							result.setText("");
							wr.setText("ေက်ာင္းဖြင့္ရက္ထက္ ေက်ာင္းပ်က္ရက္ကပိုမ်ားတယ္ဆိုေတာ့ မင္းဟာ ဏဲဏဲေဒာ့မ်ားတယ္ကြာ");
							img.setImageResource(R.drawable.er);
							return;}
						if(sum>=75){
							sum = ((num2*7) - num1)*(100/ (num2*7));
							result.setText(Double.toString(sum)+"%");
							wr.setText("Roll call ျပည့္ေအာင္တက္နိုင္တဲ့အတြက္ ကမၻာ့စံခ်ိန္တင္သြားပာျပီ။");
							img.setImageResource(R.drawable.up);
						}
						else{
							sum = ((num2*7) - num1)*(100/ (num2*7));
							result.setText(Double.toString(sum)+"%");
							wr.setText("သင့္စတိုင္ပင္ငတ္ျပီျဖစ္တဲ့အတြက္ ဂုဏ္ယူပာတယ္။");
							img.setImageResource(R.drawable.down);
						}		
			}}
			}});
			}
	@Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.main, menu);//Menu Resource, Menu  
        return true;  
    }  
    @Override  
    public boolean onOptionsItemSelected(MenuItem item) {  
        switch (item.getItemId()) {  
            case R.id.calendar:  
				Intent intent = new Intent(MainActivity.this, cal.class);
				startActivity(intent);
				return true;     
			case R.id.about:  
                Intent i = new Intent(MainActivity.this, about.class);
				startActivity(i);
				return true;     
            case R.id.exit:  
                finish();  
				return (false);
			default:  
                return super.onOptionsItemSelected(item);  
        }}
   
				@Override
				public void onBackPressed() {
					AlertDialog exit = new AlertDialog.Builder(MainActivity.this).create();
					exit.setTitle("EXIT!");
					exit.setIcon(R.drawable.ic_launcher);
					exit.setMessage("Are you want to exit?");
					exit.setButton("Yes",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							MainActivity.this.finish();
							}
						});
					exit.setButton2("No", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
							}
						});
					exit.show();
					}
					}
