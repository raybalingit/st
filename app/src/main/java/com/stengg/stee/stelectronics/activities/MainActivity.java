package com.stengg.stee.stelectronics.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.stengg.stee.stelectronics.R;
import com.stengg.stee.stelectronics.services.DownloadService;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

public class MainActivity extends AppCompatActivity {

    ProgressDialog mProgressDialog;
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = (TextView) findViewById(R.id.tv_content);

        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("Downloading ...");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(true);

        // this is how you fire the downloader
        mProgressDialog.show();
        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra("url", "http://veanovenario.com/work/mi-st/MOBILEASSETEXTSYS_MBLASSET_3003141.1440734633858539684.xml.gz");
        intent.putExtra("receiver", new DownloadReceiver(new Handler()));
        startService(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("unchecked")
    public String loadArray(String filename){
        try {
            FileInputStream fis=new FileInputStream(filename);
            GZIPInputStream gzis=new GZIPInputStream(fis);
//            ObjectInputStream in=new ObjectInputStream(gzis);
            String result = convertStreamToString(gzis);
//            List<String> read_field=(List<String>)in.readObject();
//
//            in.close();
//            return read_field;
            return result;

        }
        catch (  Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    private class DownloadReceiver extends ResultReceiver {
        public DownloadReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            if (resultCode == DownloadService.UPDATE_PROGRESS) {
                int progress = (int) resultData.getLong("progress");
                int max = (int) resultData.getInt("total");
                mProgressDialog.setIndeterminate(false);
                mProgressDialog.setMax(max);
                mProgressDialog.setProgress(progress);
                if (progress == max) {
                    String strings = loadArray("/sdcard/file.gz");
                    tvContent.setText(strings);
                    mProgressDialog.dismiss();
                }
            }
        }
    }

    private String convertStreamToString(InputStream is) {
        ByteArrayOutputStream oas = new ByteArrayOutputStream();
        copyStream(is, oas);
        String t = oas.toString();
        try {
            oas.close();
            oas = null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;
    }

    private void copyStream(InputStream is, OutputStream os)
    {
        final int buffer_size = 1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
                int count=is.read(bytes, 0, buffer_size);
                if(count==-1)
                    break;
                os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }
}
