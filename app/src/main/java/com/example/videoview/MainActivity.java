package com.example.videoview;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView=(VideoView)findViewById(R.id.video);
        String path="android.resource://"+getPackageName()+"/"+R.raw.barcelona;
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        /*Uri uri=Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.setVideoURI(uri);
        videoView.start();
        */

    }
}
