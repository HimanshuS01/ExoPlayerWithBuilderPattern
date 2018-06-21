package com.cuemath.himanshusinghal.loopingvideoplayer;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadVideoFromUrl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_video_from_url);
        ProgressBack PB = new ProgressBack();
        PB.execute();
    }

    private class ProgressBack extends AsyncTask<Void, Void, Void> {
        ProgressDialog PD;

        @Override
        protected Void doInBackground(Void... voids) {
            downloadFile("https://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_5mb.mp4", "Sample.mp4");
            return null;
        }

        @Override
        protected void onPreExecute() {
            PD = ProgressDialog.show(DownloadVideoFromUrl.this, null, "Please Wait ...", true);
            PD.setCancelable(true);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            PD.dismiss();
        }
    }


    private void downloadFile(String fileURL, String fileName) {
        try {
            String rootDir = Environment.getExternalStorageDirectory()
                    + File.separator + "Video";
            File rootFile = new File(rootDir);
            rootFile.mkdir();
            URL url = new URL(fileURL);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setDoOutput(true);
            c.connect();
            FileOutputStream f = new FileOutputStream(new File(rootFile,
                    fileName));
            InputStream in = c.getInputStream();
            byte[] buffer = new byte[1024];
            int len1 = 0;
            while ((len1 = in.read(buffer)) > 0) {
                f.write(buffer, 0, len1);
                Log.d("InDownload", "downloadFile: " + buffer);
            }
            f.close();
        } catch (IOException e) {
            Log.d("Error....", e.toString());
        }

    }
}
