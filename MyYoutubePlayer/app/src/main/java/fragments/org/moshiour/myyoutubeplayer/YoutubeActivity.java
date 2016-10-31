package fragments.org.moshiour.myyoutubeplayer;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by Moshiour on 11/14/2015.
 */
public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public static final String GOOGLE_API_KEY = "AIzaSyDMDC0hbClRDpjYDw957rzBb1VhrVMIL_M";
    public static final String YOUTUBE_VIDEO_ID = "F-uLA7pKtGs";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);

    }

    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Cannot initialize Youtube player", Toast.LENGTH_LONG).show();
    }

    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);


        if (!wasRestored) {
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
            player.setFullscreen(true);

            player.cueVideo(YOUTUBE_VIDEO_ID);


        }
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {

        public void onBuffering(boolean arg0) {

        }

        public void onPaused() {
        }

        public void onPlaying() {

        }

        public void onSeekTo(int arg0) {

        }

        public void onStopped() {

        }
    };

    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {

        public void onAdStarted() {

        }

        public void onError(ErrorReason arg0) {

        }

        public void onLoading() {

        }

        public void onLoaded(String arg0) {

        }

        public void onVideoStarted() {
            Toast.makeText(YoutubeActivity.this, "Loaded", Toast.LENGTH_LONG).show();
        }

        public void onVideoEnded() {

        }

    };


    //region MY_CODE
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.youtube);
//        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
//        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
//
//    }

//    @Override
//    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
//        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
//        youTubePlayer.setPlaybackEventListener(playbackEventListener);
//        if (!wasRestored) {
//            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
//        }
//
//    }
//
//    @Override
//    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//        Toast.makeText(this, "Can not initialize youtube player", Toast.LENGTH_LONG).show();
//    }
//
//    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
//        @Override
//        public void onPlaying() {
//
//        }
//
//        @Override
//        public void onPaused() {
//
//        }
//
//        @Override
//        public void onStopped() {
//
//        }
//
//        @Override
//        public void onBuffering(boolean b) {
//
//        }
//
//        @Override
//        public void onSeekTo(int i) {
//
//        }
//    };
//
//    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
//        @Override
//        public void onLoading() {
//
//        }
//
//        @Override
//        public void onLoaded(String s) {
//
//        }
//
//        @Override
//        public void onAdStarted() {
//
//        }
//
//        @Override
//        public void onVideoStarted() {
//
//        }
//
//        @Override
//        public void onVideoEnded() {
//
//        }
//
//        @Override
//        public void onError(YouTubePlayer.ErrorReason errorReason) {
//
//        }
//    };

    //endregion
}
