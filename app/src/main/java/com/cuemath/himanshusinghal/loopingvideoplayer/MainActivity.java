package com.cuemath.himanshusinghal.loopingvideoplayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoUtils videoUtils = new VideoUtils.Builder().with(this)
                .setSource("/sdcard/DCIM/Camera/VID_20180610_115516349.mp4")
                .setLayoutId(R.id.fragment_container)
                .setRepeat(true)
                .showControls(false)
                .buildVideoPlayer();

        videoUtils.play();
    }
}
