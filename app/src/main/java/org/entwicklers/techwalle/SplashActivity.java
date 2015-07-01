package org.entwicklers.techwalle;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;


public class SplashActivity extends ActionBarActivity {

    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);

        bar = (ProgressBar) findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                long a=0,b=1,c;
                while (!( a > 60)) {
                    try {
                        Thread.sleep(a*45);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bar.setProgress((int) b);
                    c = a+b;
                    a = b;
                    b = c;
                }
                bar.setProgress(100);
                Intent intent=new Intent(SplashActivity.this,HomeActivity.class);
                startActivityForResult(intent, 0);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                finish();
            }
        }).start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
}
