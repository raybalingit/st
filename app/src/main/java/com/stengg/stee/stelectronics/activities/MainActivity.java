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
import com.stengg.stee.stelectronics.models.Asset;
import com.stengg.stee.stelectronics.parser.AssetParser;
import com.stengg.stee.stelectronics.services.DownloadService;
import com.stengg.stee.stelectronics.services.ParsingService;

import org.xmlpull.v1.XmlPullParserException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class MainActivity extends AppCompatActivity {

    ProgressDialog mProgressDialog;
    TextView tvContent;
    long mStartTime;
    String mMessage;

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
//        intent.putExtra("url", "http://veanovenario.com/work/mi-st/MOBILEASSETEXTSYS_MBLASSET_3003141.1440734633858539684.xml.gz");
        intent.putExtra("url", "http://veanovenario.com/work/mi-st/1x_Asset_A1032.xml.gz");
        intent.putExtra("receiver", new DownloadReceiver(new Handler()));

        mStartTime = System.currentTimeMillis();
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
    public String loadArray(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            GZIPInputStream gzis = new GZIPInputStream(fis);
//            ObjectInputStream in=new ObjectInputStream(gzis);
            String result = convertStreamToString(gzis);
//            List<String> read_field=(List<String>)in.readObject();
//
//            in.close();
//            return read_field;
            return result;

        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    private class ParseReceiver extends ResultReceiver {
        public ParseReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            if (resultCode == ParsingService.UPDATE_PROGRESS) {
                int progress = (int) resultData.getLong("progress");
                int max = (int) resultData.getInt("total");
                mProgressDialog.setIndeterminate(false);
                mProgressDialog.setMax(max);
                mProgressDialog.setProgress(progress);
                if (progress == max) {
                    mProgressDialog.dismiss();
                    StringBuilder sb = new StringBuilder();
                    sb.append(mMessage);
                    sb.append("\n");
                    sb.append("Parse Duration: ");
                    sb.append(System.currentTimeMillis() - mStartTime);
                    sb.append("ms\n");
                    mMessage = sb.toString();
                }
            }

            tvContent.setText(mMessage);
        }
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
                    loadArray("/sdcard/file.gz");
                    mProgressDialog.dismiss();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Download Duration: ");
                    sb.append(System.currentTimeMillis() - mStartTime);
                    sb.append("ms\n");
                    mProgressDialog.setMessage("Parsing ...");
                    mProgressDialog.setIndeterminate(true);
                    // this is how you fire the downloader
                    mProgressDialog.show();
//                    Intent intent = new Intent(MainActivity.this, ParsingService.class);
//                    intent.putExtra("url", "/sdcard/ste.xml");
//                    intent.putExtra("receiver", new ParseReceiver(new Handler()));
//                    mStartTime = System.currentTimeMillis();
//                    startService(intent);
                    try {
                        mStartTime = System.currentTimeMillis();
                        InputStream is = new FileInputStream("/sdcard/ste.xml");
                        AssetParser parser = new AssetParser();
                        List<Asset> assets = parser.parse(is);

                        sb.append("Parsing Duration: ");
                        sb.append(System.currentTimeMillis() - mStartTime);
                        sb.append("ms\n");

                        for (Asset a : assets) {
                            sb.append("(Asset: ");
                            sb.append(a.getAssetNum() + ", ");
                            sb.append(a.getDescription() + ", ");
                            sb.append(a.getAssetCode() + ", ");
                            sb.append(a.getLocation() + ", ");
                            sb.append(a.getLocationCode() + ", ");
                            sb.append(a.getUsage() + ", ");
                            sb.append(a.getType() + ", ");
                            sb.append(a.getParent() + ")\n");
                        }

                        mMessage = sb.toString();
                        tvContent.setText(mMessage);
                        mProgressDialog.dismiss();
                    } catch (IOException e) {

                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    /**
     *
     * @param is
     * @return
     */
    private String convertStreamToString(InputStream is) {
        String t = null;
        try {
            OutputStream oas = new FileOutputStream("/sdcard/ste.xml");
            copyStream(is, oas);
            t = oas.toString();
            oas.close();
            oas = null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;
    }

    /**
     *
     * @param is
     * @param os
     */
    private void copyStream(InputStream is, OutputStream os) throws IOException {
        final int buffer_size = 1024;
        try {
            byte[] bytes = new byte[buffer_size];
            for (; ; ) {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1)
                    break;
                os.write(bytes, 0, count);
            }
        } finally {
            is.close();
            os.close();
        }

    }
}
