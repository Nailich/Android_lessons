package ru.stonefist.lesson2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Наиль on 09.05.2016.
 */
public class VideoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        String videosource = "/WhatsApp/Media/WhatsApp Video/vid1.mp4";

        VideoView videoView = (VideoView)findViewById(R.id.videoView);

        videoView.setVideoPath(String.valueOf(R.raw.vid1));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus(0);
        videoView.start();
    }
}
