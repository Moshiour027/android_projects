package org.moshiour.runtimeimages;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.longText);
        StringBuffer sb = new StringBuffer();
        sb.append(getString(R.string.lorem_ipsum));
        tv.setText(sb.toString());
    }

    public void btnOnclickHandler(View view) {
        String imageName = "image_10102";
        int res = getResources().getIdentifier(imageName, "drawable", getPackageName());
        ImageView iv = (ImageView) findViewById(R.id.imageCourse);
        iv.setImageResource(res);

    }

    public void btn2OnclickHandler(View view) {
        String imageName = "image_50101.png";
        ImageView iv = (ImageView) findViewById(R.id.imageCourse);
        try {
            InputStream stream = getAssets().open(imageName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            iv.setImageDrawable(drawable);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
        }

    }
}
