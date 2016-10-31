package fragments.org.moshiour.myyoutubeplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

/**
 * Created by Moshiour on 11/14/2015.
 */
public class StandAloneActivity extends Activity implements View.OnClickListener {

    public static final String GOOGLE_API_KEY = "AIzaSyDMDC0hbClRDpjYDw957rzBb1VhrVMIL_M";
    public static final String YOUTUBE_VIDEO_ID = "qqLtPbEmbJs";
    private static final String YOUTUBE_PLAYLIST_ID = "PLi7ihgkEws7Tc-nS8VRpFvJPMmwx8KNbF";

    private Button btnPlay, btnPlayList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standalone);
        btnPlay = (Button) findViewById(R.id.btn_Start);
        btnPlayList = (Button) findViewById(R.id.btn_playlist);
        btnPlay.setOnClickListener(this);
        btnPlayList.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (v == btnPlay) {
            //play a single video
            intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);

        } else if (v == btnPlayList) {
            //play playlist
            intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST_ID);

        }
        if (intent != null) {
            /*if zero it would not return anything */

            startActivityForResult(intent, 0);
        }
    }


}
