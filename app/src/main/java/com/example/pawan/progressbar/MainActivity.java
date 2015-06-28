package com.example.pawan.progressbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    Button progressBar1,progressBar2,progressBar3,progressBar4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1=(Button)findViewById(R.id.btnProgressBar1);
        progressBar2=(Button)findViewById(R.id.btnProgressBar2);
        progressBar3=(Button)findViewById(R.id.btnProgressBar3);
        progressBar4=(Button)findViewById(R.id.btnProgressBar4);

        progressBar1.setOnClickListener(this);
        progressBar2.setOnClickListener(this);
        progressBar3.setOnClickListener(this);
        progressBar4.setOnClickListener(this);

	}

    @Override
    public void onClick(View view) {
        Intent intent;
        if (view==progressBar1){
            intent=new Intent(getApplicationContext(),ProgressBarActivity1.class);
            startActivity(intent);
        }else if (view==progressBar2){
            intent=new Intent(getApplicationContext(),ProgressBarActivity2.class);
            startActivity(intent);
        }else if (view==progressBar3){
            intent=new Intent(getApplicationContext(),ProgressBarActivity3.class);
            startActivity(intent);
        }else if (view==progressBar4){

        }

    }
}
