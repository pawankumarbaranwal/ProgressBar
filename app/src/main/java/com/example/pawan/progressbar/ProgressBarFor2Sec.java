package com.example.pawan.progressbar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class ProgressBarFor2Sec extends Activity {

    Button button;
    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarbHandler = new Handler();

    private long fileSize = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar_2sec);
        addButtonListener();
    }

    public void addButtonListener() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // create and display a new ProgressBarDialog
                progressBar = new ProgressDialog(view.getContext());
                progressBar.setCancelable(true);
                progressBar.setMessage("File downloading ...");
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.show();
                progressBarStatus = 0;

                fileSize = 0;

                new Thread(new Runnable() {

                    public void run() {
                        while (progressBarStatus < 100) {
                            progressBarStatus+=50;
                            // process some tasks
                            //progressBarStatus = downloadFile();
                            // sleep 1 second (simulating a time consuming task...)
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            // Update the progress bar
                            progressBarbHandler.post(new Runnable() {
                                public void run() {
                                    progressBar.setProgress(progressBarStatus);
                                }
                            });
                        }
                        // if the file is downloaded,
                        if (progressBarStatus >= 100) {
                            // sleep 2 seconds, so that you can see the 100%
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            // and then close the progressbar dialog
                            progressBar.dismiss();
                        }
                    }
                }).start();
            }
        });
    }
}