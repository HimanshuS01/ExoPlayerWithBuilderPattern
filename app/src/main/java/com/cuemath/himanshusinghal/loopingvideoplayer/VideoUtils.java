package com.cuemath.himanshusinghal.loopingvideoplayer;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class VideoUtils {


    private Context context;
    private String urlSource;
    private int layoutId;
    private boolean isRepeat;
    private boolean showControls;


    public VideoUtils(Context context, String urlSource, int layoutId, boolean isRepeat, boolean showControls) {
        this.context = context;
        this.urlSource = urlSource;
        this.layoutId = layoutId;
        this.isRepeat = isRepeat;
        this.showControls = showControls;
    }

    public void play() {
        FragmentActivity activity = (FragmentActivity) context;
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
        VideoFragment videoFragment = VideoFragment.newInstance(urlSource, layoutId, isRepeat, showControls);
        ft.replace(layoutId, videoFragment);
        ft.commit();
    }

    public static class Builder {

        private Context context;
        private String urlSource;
        private int layoutId;
        private boolean isRepeat;
        private boolean showControls;


        public Builder with(Context context) {
            this.context = context;
            return this;
        }

        public Builder setSource(String urlSource) {
            this.urlSource = urlSource;
            return this;
        }

        public Builder setLayoutId(int layoutId) {
            this.layoutId = layoutId;
            return this;
        }

        public Builder setRepeat(boolean isRepeat) {
            this.isRepeat = isRepeat;
            return this;
        }

        public Builder showControls(boolean showControls) {
            this.showControls = showControls;
            return this;
        }

        public VideoUtils buildVideoPlayer() {

            if (context == null)
                throw new IllegalArgumentException("Can't play video without the context");

            if (urlSource.isEmpty())
                throw new IllegalArgumentException("Can't play video with source");

            return new VideoUtils(context, urlSource, layoutId, isRepeat, showControls);
        }
    }
}
