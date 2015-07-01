package org.entwicklers.techwalle;

import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends ActionBarActivity {

    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();
    private float scale = 1f;
    ImageView defaultIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle(Html.fromHtml("<font color=\"#ffffff\">" + "HomeActivity" + "</font>"));

        defaultIMG = (ImageView) findViewById(R.id.defaultIMG);
        scaleGestureDetector = new ScaleGestureDetector(this,new ScaleListener());
    }

    public boolean onTouchEvent(MotionEvent ev) {
        scaleGestureDetector.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.

            SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5.0f));

            matrix.setScale(scale, scale);
            defaultIMG.setImageMatrix(matrix);
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
            overridePendingTransition(R.anim.trans_bottom_in, R.anim.trans_bottom_out);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
}
