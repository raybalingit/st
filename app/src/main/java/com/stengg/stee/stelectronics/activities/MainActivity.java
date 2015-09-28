package com.stengg.stee.stelectronics.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.stengg.stee.stelectronics.R;
import com.stengg.stee.stelectronics.adapter.AssetAdapter;
import com.stengg.stee.stelectronics.base.STApplication;
import com.stengg.stee.stelectronics.models.Asset;
import com.stengg.stee.stelectronics.parser.AssetParser;
import com.stengg.stee.stelectronics.services.ParsingService;

import org.xmlpull.v1.XmlPullParserException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class MainActivity extends AppCompatActivity {
    public static final int DOWNLOAD_TASK = 1253;

    private Toolbar mToolbar;
    private RecyclerView mRvTable;
    private CoordinatorLayout mSnackbarLayout;

    private LinearLayoutManager mLayoutManager;
    AssetAdapter mAdapter;

    ProgressDialog mProgressDialog;

    long mStartTime;
    String mMessage;

    List<Asset> mAssets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);

        mRvTable = (RecyclerView) findViewById(R.id.rv_table);
        mRvTable.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRvTable.setLayoutManager(mLayoutManager);

        // initialize array
        mAssets = new ArrayList<>();
        mAdapter = new AssetAdapter(this, mAssets);
        mRvTable.setAdapter(mAdapter);

        mSnackbarLayout = (CoordinatorLayout) findViewById(R.id.snackbarPosition);

        if (STApplication.getInstance().getAssetList() == null || STApplication.getInstance()
                .getAssetList().size() <= 0) {
            new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    Intent i = new Intent(MainActivity.this, DownloaderActivity.class);
                    startActivityForResult(i, DOWNLOAD_TASK);
                }
            }, 3000);
        } else {
            mAdapter.refresh(STApplication.getInstance().getAssetList());
        }
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
            String fileinput = "/sdcard/" + filename + ".gz";
            FileInputStream fis = new FileInputStream(fileinput);
            GZIPInputStream gzis = new GZIPInputStream(fis);
            String fileoutput = "/sdcard/" + filename + ".xml";
            String result = convertStreamToString(gzis, fileoutput);
            return result;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    /**
     *
     * @param is
     * @return
     */
    private String convertStreamToString(InputStream is, String filename) {
        String t = null;
        try {
            OutputStream oas = new FileOutputStream(filename);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DOWNLOAD_TASK && resultCode == RESULT_OK) {
            String[] files = data.getStringArrayExtra("files");
            new ParsingTask(files).execute();
        } else {
            Snackbar.make(mSnackbarLayout, "Download Cancelled", Toast.LENGTH_LONG).show();
        }
    }

    class ParsingTask extends AsyncTask<Void, Void, List<Asset>> {

        ProgressDialog mDialog;
        String[] data;
        String mError = null;
        long mDuration;

        public ParsingTask(String[] files) {
            data = files;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mDialog = new ProgressDialog(MainActivity.this);
            mDialog.setMessage("Parsing Assets");
            mDialog.setIndeterminate(true);
            mDialog.show();
            mDuration = System.currentTimeMillis();
        }

        @Override
        protected List<Asset> doInBackground(Void... params) {
            for (int i = 0; i < data.length; i++) {
                loadArray(data[i]);
                try {
                    String filename = "/" + data[i] + ".xml";
                    AssetParser parser = new AssetParser();
                    List<Asset> assets = parser.parse(filename);
                    return assets;
                } catch (IOException e) {
                    mError = e.getMessage();
                } catch (XmlPullParserException e) {
                    mError = e.getMessage();
                } catch (Exception e) {
                    mError = e.getMessage();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(List<Asset> assets) {
            super.onPostExecute(assets);
            mDuration = System.currentTimeMillis() - mDuration;
            if (TextUtils.isEmpty(mError)) {
                Snackbar.make(mSnackbarLayout, "Size = " + assets.size() + "\n Parsed in " +
                        mDuration + "ms", Snackbar.LENGTH_LONG).show();
                STApplication.getInstance().setAssets(assets);
                mAdapter.refresh(assets);
            } else {
                Snackbar.make(mSnackbarLayout, mError, Snackbar.LENGTH_LONG).show();
            }

            if (mDialog.isShowing())
                mDialog.dismiss();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
