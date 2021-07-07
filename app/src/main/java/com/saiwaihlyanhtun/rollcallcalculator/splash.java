package com.saiwaihlyanhtun.rollcallcalculator;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;

public class splash extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable(){
				@Override
				public void run() {

					Intent mainIntent = new Intent(splash.this,MainActivity.class);
					splash.this.startActivity(mainIntent);
					splash.this.finish();
				}
			}, SPLASH_DISPLAY_LENGTH);
    }
}

