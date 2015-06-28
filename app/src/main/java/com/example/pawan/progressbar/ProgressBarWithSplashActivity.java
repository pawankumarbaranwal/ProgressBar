package com.example.pawan.progressbar;
 
import java.util.Timer;
import java.util.TimerTask;
 
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Window;
 
public class ProgressBarWithSplashActivity extends Activity {
 
	// Set Duration of the Splash Screen

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Remove the Title Bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// Get the view from splash_screen.xml
		setContentView(R.layout.progressbar_splash);

		// Create a Timer
		Timer RunSplash = new Timer();

		// Task to do when the timer ends
		//TimerTask ShowSplash = new TimerTask() {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
                                            /*
                                             * We are creating this new thread because we don’t
                                             * want our main thread to stop working for that
                                             * time as our android stop working and some time
                                             * application will crashes
                                             */
					e.printStackTrace();
				}
				finally {
					Intent i = new Intent(getApplicationContext(),
							NewActivity.class);
					startActivity(i);
					finish();
				}

			}
		});

		// Start the timer
		//RunSplash.schedule(ShowSplash, Delay);
		th.start(); // start the thread
	}
}