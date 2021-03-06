package com.stengg.stee.stelectronics.services;

import android.app.IntentService;
import android.content.Intent;

import com.stengg.stee.stelectronics.parser.AssetParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Raymond Balingit on 18/9/2015.
 */
public class ParsingService extends IntentService {
    public static final int UPDATE_PROGRESS = 8344;
    public ParsingService() {
        super("ParseService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            String urlToDownload = intent.getStringExtra("url");
            InputStream is = new FileInputStream(urlToDownload);
            AssetParser parser = new AssetParser();

        } catch (IOException e) {

        }

        /*String urlToDownload = intent.getStringExtra("url");
        ResultReceiver receiver = (ResultReceiver) intent.getParcelableExtra("receiver");
        try {
            URL url = new URL(urlToDownload);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            // this will be useful so that you can show a typical 0-100% progress bar
            int fileLength = connection.getContentLength();

            // download the file
            InputStream input = new BufferedInputStream(connection.getInputStream());
            OutputStream output = new FileOutputStream("/sdcard/file.gz");

            byte data[] = new byte[1024];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                Bundle resultData = new Bundle();
                resultData.putInt("total", fileLength);
                resultData.putLong("progress" ,total);
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
        resultData.putInt("progress" ,100);
        receiver.send(UPDATE_PROGRESS, resultData);*/
    }

}
