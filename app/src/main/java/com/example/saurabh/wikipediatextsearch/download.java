package com.example.mhc.anonloger;

/**
 * Created by sagar117 on 2/20/2017.
 */

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import permissions.dispatcher.NeedsPermission;

public class DownloadHash extends Activity {

    // button to show progress dialog
    Button btnShowProgress;

    // Progress Dialog
    private ProgressDialog pDialog;
    ImageView my_image;
    // Progress dialog type (0 - for Horizontal progress bar)
    public static final int progress_bar_type = 0;

    // File url to download
    private static String file_url = "";
    ChatActivity chatActivity=new ChatActivity();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.downloadhash);

//
//        // show progress bar button
//        btnShowProgress = (Button) findViewById(R.id.btnProgressBar);
//        // Image view to show image after downloading
//        my_image = (ImageView) findViewById(R.id.my_image);
        /**
         * Show Progress bar click event
         * */
        Bundle c=this.getIntent().getExtras();
        if (c!=null) {
            String[] array = c.getStringArray("hasharray");
            int len = array.length;


//
//        Bundle b = getIntent().getExtras();
//            int r = b.getInt("objlength");
//        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
//        sharedPreferences.getString("hh","");
//        Log.i("no. of r",String.valueOf(r));


            for (int i = 0; i <= len; i++) {

                String furl = file_url + array[i];
                new DownloadFileFromURL().execute(furl);
            }
        }else {
            Toast.makeText(this,"fuck off dude",Toast.LENGTH_SHORT).show();
        }


//        btnShowProgress.setOnClickListener(new View.OnClickListener() {
//            @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//            @Override
//            public void onClick(View v) {
//                // starting new Async Task
//               // new DownloadFileFromURL().execute(file_url+a);
//            }
//        });
    }

    /**
     * Showing Dialog
     * */
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type: // we set this to 0
                pDialog = new ProgressDialog(this);
                pDialog.setMessage("Downloading file. Please wait...");
                pDialog.setIndeterminate(false);
                pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setCancelable(true);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }

    /**
     * Background Async Task to download file
     * */

    public class DownloadFileFromURL extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progress_bar_type);
        }

        /**
         * Downloading file in background thread
         * */
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        @Override
        protected String doInBackground(String... f_url) {
            int count;


            try {
                URL url = new URL(f_url[0]);
                URLConnection conection = url.openConnection();
                conection.connect();
                // this will be useful so that you can show a tipical 0-100% progress bar
                int lenghtOfFile = conection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(), 8192);

                // Output stream
                int i=0;
                OutputStream output = new FileOutputStream("/storage/emulated/0/downloadedfile"+i);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress(""+(int)((total*100)/lenghtOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        /**
         * Updating progress bar
         * */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        /**
         * After completing background task
         * Dismiss the progress dialog
         * **/
        @NeedsPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
        @Override
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after the file was downloaded
            dismissDialog(progress_bar_type);
            finish();
            // Displaying downloaded image into image view
            // Reading image path from sdcard
            //String imagePath = Environment.getExternalStorageDirectory().toString() + "/downloadedfile.jpg";
            // setting downloaded into image view
           // my_image.setImageDrawable(Drawable.createFromPath(imagePath));
        }

    }
}
