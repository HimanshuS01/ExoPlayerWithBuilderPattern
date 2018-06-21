package com.cuemath.himanshusinghal.loopingvideoplayer;

import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

public class FragmentOne extends Fragment {

    VideoView myVideo1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        String path = "https://www.youtube.com/watch?v=33hh5Kg0gwI";
        Uri uri=Uri.parse(path);

        getActivity().getWindow().setFormat(PixelFormat.TRANSLUCENT);
        myVideo1=view.findViewById(R.id.myvideoview);
        myVideo1.setVideoURI(uri);
        myVideo1.start();
        myVideo1.requestFocus();

        myVideo1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                myVideo1.requestFocus();
                myVideo1.start();
                mp.setLooping(true);
            }
        });

        return view;
    }
}
