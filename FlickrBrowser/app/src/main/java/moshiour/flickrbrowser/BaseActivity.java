package moshiour.flickrbrowser;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Moshiour on 12/5/2015.
 */
public class BaseActivity extends AppCompatActivity {
    public static final String FLICKR_QUERY = "FLICKR_QUERY";
    public static final String PHOTO_TRANSFER = "PHOTO_TRANSFER";

    private Toolbar mToolBar;

    protected Toolbar activateToolBar() {
        if (mToolBar == null) {
            mToolBar = (Toolbar) findViewById(R.id.app_bar);
            if (mToolBar != null) {
                setSupportActionBar(mToolBar);
            }
        }
        return mToolBar;
    }

    protected Toolbar activateToolbarWithHomeEnables() {
        activateToolBar();
        if (mToolBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        return mToolBar;
    }
}
