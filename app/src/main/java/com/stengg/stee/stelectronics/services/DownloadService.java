package com.stengg.stee.stelectronics.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Service used to download files from a
 * given URL
 */
public class DownloadService extends IntentService {
    public static final int UPDATE_PROGRESS = 8344;
    public static final String DOWNLOAD_PROGRESS = "progress";
    public static final String DOWNLOAD_SIZE = "total";
    public static final String URL = "url";
    public static final String FILENAME = "filename";
    public static final String RECEIVER = "receiver";


    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String urlToDownload = intent.getStringExtra(URL);
        String filename = intent.getStringExtra(FILENAME);

        ResultReceiver receiver = (ResultReceiver) intent.getParcelableExtra(RECEIVER);
        int fileLength = 0;
        try {
            URL url = new URL(urlToDownload);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            // this will be useful so that you can show a typical 0-100% progress bar
            fileLength = connection.getContentLength();

            // download the file
            InputStream input = new BufferedInputStream(connection.getInputStream());
            OutputStream output;
            if (!TextUtils.isEmpty(filename)) {
                output = new FileOutputStream(filename);
            } else {
                output = new FileOutputStream("/sdcard/file.gz");
            }

            byte data[] = new byte[1024];
            long total = 0;
            int count;

            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                Bundle resultData = new Bundle();
                resultData.putInt(DOWNLOAD_SIZE, fileLength);
                resultData.putLong(DOWNLOAD_PROGRESS ,total);
                receiver.send(UPDATE_PROGRESS, resultData);
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();

            output = null; input = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bundle resultData = new Bundle();
        resultData.putLong(DOWNLOAD_PROGRESS ,fileLength);
        receiver.send(UPDATE_PROGRESS, resultData);
    }
}