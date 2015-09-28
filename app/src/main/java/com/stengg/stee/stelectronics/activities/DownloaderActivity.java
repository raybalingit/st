package com.stengg.stee.stelectronics.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.stengg.stee.stelectronics.R;
import com.stengg.stee.stelectronics.services.DownloadingService;
import com.stengg.stee.stelectronics.services.File;

import java.util.ArrayList;
import java.util.Arrays;

public class DownloaderActivity extends Activity {

    public static final String ID = "id";
    private ListView mListView;
    private ArrayAdapter<File> mAdapter;
    private boolean mReceiversRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_downloader);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        ListView listView = mListView = (ListView) findViewById(R.id.list_progress);
        long id = 0;
        File[] files = {/*getFile("Assets2", 2, "http://veanovenario.com/work/mi-st/MOBILEASSETEXTSYS_MBLASSET_3698688.144067407565393761.xml.gz")*/getFile("Assets", 1, "http://veanovenario.com/work/mi-st/1x_Asset_A1032.xml.gz")/*, getFile("Assets Full", 2, "http://veanovenario.com/work/mi-st/MOBILEASSETEXTSYS_MBLASSET_3003141.1440734633858539684.xml.gz")*/};
        listView.setAdapter(mAdapter = new ArrayAdapter<File>(this,
                R.layout.row_progress_bar, R.id.tv_title, files) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                updateRow(getItem(position), v);
                return v;
            }
        });

        if (savedInstanceState == null) {
            Intent intent = new Intent(this, DownloadingService.class);
            intent.putParcelableArrayListExtra("files", new ArrayList<File>(Arrays.asList(files)));
            startService(intent);
        }

        registerReceiver();
    }


    private File getFile(String name, long id, String url) {
        return new File(name, id, url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver();
    }

    private void registerReceiver() {
        unregisterReceiver();
        IntentFilter intentToReceiveFilter = new IntentFilter();
        intentToReceiveFilter
                .addAction(DownloadingService.PROGRESS_UPDATE_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(
                mDownloadingProgressReceiver, intentToReceiveFilter);
        mReceiversRegistered = true;
    }

    private void unregisterReceiver() {
        if (mReceiversRegistered) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(
                    mDownloadingProgressReceiver);
            mReceiversRegistered = false;
        }
    }

    private void updateRow(final File file, View v) {
        ProgressBar bar = (ProgressBar) v.findViewById(R.id.progressBar);
        bar.setProgress(file.getProgress());
        TextView tv = (TextView) v.findViewById(R.id.tv_title);
        tv.setText(file.getName());
        TextView tvPercentage = (TextView) v.findViewById(R.id.tv_percentage);
        tvPercentage.setText(String.format("%d%%", file.getProgress()));
        TextView tvCurrentSize = (TextView) v.findViewById(R.id.tv_progress);
        tvCurrentSize.setText(String.format("%d", file.getCurrentsize()));
        TextView tvFileSize = (TextView) v.findViewById(R.id.tv_total);
        tvFileSize.setText(String.format("%d", file.getFilesize()));
        TextView tvCompleted = (TextView) v.findViewById(R.id.tv_completed);
        if (file.getProgress() == 100) {
            LinearLayout parts = (LinearLayout) v.findViewById(R.id.progress_value);
            parts.setVisibility(View.GONE);
            tvCompleted.setVisibility(View.VISIBLE);
        }
        else {
            tvCompleted.setVisibility(View.GONE);
        }

    }

    // don't call notifyDatasetChanged() too frequently, have a look at
    // following url http://stackoverflow.com/a/19090832/1112882
    protected void onProgressUpdate(int position, int progress, int filesize, int currentsize) {
        final ListView listView = mListView;
        int first = listView.getFirstVisiblePosition();
        int last = listView.getLastVisiblePosition();
        mAdapter.getItem(position).setProgress(progress > 100 ? 100 : progress);
        mAdapter.getItem(position).setFilesize(filesize);
        mAdapter.getItem(position).setCurrentsize(currentsize);
        if (position < first || position > last) {
            // just update your data set, UI will be updated automatically in next
            // getView() call
        } else {
            View convertView = mListView.getChildAt(position - first);
            // this is the convertView that you previously returned in getView
            // just fix it (for example:)
            updateRow(mAdapter.getItem(position), convertView);
        }
    }

    protected void onProgressUpdateOneShot(int[] positions, int[] progresses, int[] filesizes, int[] filecurrentsizes) {
        for (int i = 0; i < positions.length; i++) {
            int position = positions[i];
            int progress = progresses[i];
            int filesize = filesizes[i];
            int filecurrentsize = filecurrentsizes[i];
            onProgressUpdate(position, progress, filesize, filecurrentsize);
        }
    }

    private final BroadcastReceiver mDownloadingProgressReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(
                    DownloadingService.PROGRESS_UPDATE_ACTION)) {
                final boolean oneShot = intent
                        .getBooleanExtra("oneshot", false);
                if (oneShot) {
                    final int[] progresses = intent
                            .getIntArrayExtra("progress");
                    final int[] positions = intent.getIntArrayExtra("position");
                    final int[] filesizes = intent.getIntArrayExtra("filesizes");
                    final int[] filecurrentsize = intent.getIntArrayExtra("filecurrentsizes");
                    onProgressUpdateOneShot(positions, progresses, filesizes, filecurrentsize);

                    boolean finished = false;
                    Intent intentResult = new Intent();
                    String[] fileResults = new String[mAdapter.getCount()];
                    for (int i = 0; i < progresses.length; i++) {
                        if (progresses[i] == 100) {
                            fileResults[i] = mAdapter.getItem(i).getName();
                            finished = true;
                        } else {
                            finished = false;
                        }
                    }
                    if (finished) {
                        intentResult.putExtra("files", fileResults);
                        DownloaderActivity.this.setResult(RESULT_OK, intentResult);
                        DownloaderActivity.this.finish();
                    }
                } else {
                    final int progress = intent.getIntExtra("progress", -1);
                    final int position = intent.getIntExtra("position", -1);
                    final int filesize = intent.getIntExtra("filesize", -1);
                    final int filecurrentsize = intent.getIntExtra("filecurrentsize", -1);
                    if (position == -1) {
                        return;
                    }
                    onProgressUpdate(position, progress, filesize, filecurrentsize);
                }
            }
        }
    };
}
