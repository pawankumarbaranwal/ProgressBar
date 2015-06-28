package com.example.pawan.progressbar;

		import android.app.Activity;
		import android.os.Bundle;
		import android.os.Handler;
		import android.view.Menu;
		import android.view.MenuItem;
		import android.widget.ProgressBar;
		import android.widget.RelativeLayout;
		import android.widget.TextView;

		import android.app.Activity;
		import android.os.Bundle;
		import android.os.Handler;
		import android.widget.ProgressBar;
		import android.widget.TextView;

public class ProgressBarActivity3 extends Activity {
	TextView tv, tv2;
	ProgressBar pBar, pBar2;
	int pStatus = 0;
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressbar_activity3);
		tv = (TextView) findViewById(R.id.textView1);
		pBar = (ProgressBar) findViewById(R.id.progressBar1);
		tv2 = (TextView) findViewById(R.id.textView2);
		pBar2 = (ProgressBar) findViewById(R.id.progressBar2);

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (pStatus < 100) {
					pStatus += 1;

					handler.post(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							pBar.setProgress(pStatus);
							tv.setText(pStatus + "/" + pBar.getMax());
							pBar2.setProgress(pStatus);
							tv2.setText(pStatus + "%");
						}
					});
					try {
						// Sleep for 200 milliseconds.
						// Just to display the progress slowly
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}