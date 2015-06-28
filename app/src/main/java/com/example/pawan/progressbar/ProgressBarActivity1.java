package com.example.pawan.progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarActivity1 extends Activity {
	TextView tv;
	ProgressBar pBar;
	int pStatus = 0;
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressbar_activity1);
		tv = (TextView) findViewById(R.id.textView1);
		pBar = (ProgressBar) findViewById(R.id.progressBar1);

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (pStatus <= 100) {

					handler.post(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							pBar.setProgress(pStatus);
							pBar.setSecondaryProgress(pStatus + 5);
							tv.setText(pStatus + "/" + pBar.getMax());
						}
					});
					try {
						// Sleep for 200 milliseconds.
						// Just to display the progress slowly
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					pStatus++;
				}
			}
		}).start();
	}
}
