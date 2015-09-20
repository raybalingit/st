package com.stengg.stee.stelectronics.services;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadingService extends IntentService {
    public static final String ID = "id";
    public static String PROGRESS_UPDATE_ACTION = DownloadingService.class
            .getName() + ".progress_update";

    private static final String ACTION_CANCEL_DOWNLOAD = DownloadingService.class
            .getName() + "action_cancel_download";

    private boolean mIsAlreadyRunning;
    private boolean mReceiversRegistered;

    private ExecutorService mExec;
    private CompletionService<NoResultType> mEcs;
    private LocalBroadcastManager mBroadcastManager;
    private List<DownloadTask> mTasks;

    private static final long INTERVAL_BROADCAST = 800;
    private long mLastUpdate = 0;

    public DownloadingService() {
        super("DownloadingService");
        mExec = Executors.newFixedThreadPool( /* only 5 at a time */5);
        mEcs = new ExecutorCompletionService<NoResultType>(mExec);
        mBroadcastManager = LocalBroadcastManager.getInstance(this);
        mTasks = new ArrayList<DownloadTask>();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerReceiver();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mIsAlreadyRunning) {
            publishCurrentProgressOneShot(true);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (mIsAlreadyRunning) {
            return;
        }
        mIsAlreadyRunning = true;

        ArrayList<File> files = intent.getParcelableArrayListExtra("files");
        final Collection<DownloadTask> tasks = mTasks;
        int index = 0;
        for (File file : files) {
            DownloadTask yt1 = new DownloadTask(index++, file);
            tasks.add(yt1);
        }

        for (DownloadTask t : tasks) {
            mEcs.submit(t);
        }
        // wait for finish
        int n = tasks.size();
        for (int i = 0; i < n; ++i) {
            NoResultType r;
            try {
                r = mEcs.take().get();
                if (r != null) {
                    Log.d("R ST", r.toString());
                    // use you result here
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        // send a last broadcast
        publishCurrentProgressOneShot(true);
        mExec.shutdown();
    }

    private void publishCurrentProgressOneShot(boolean forced) {
        if (forced
                || System.currentTimeMillis() - mLastUpdate > INTERVAL_BROADCAST) {
            mLastUpdate = System.currentTimeMillis();
            final List<DownloadTask> tasks = mTasks;
            int[] positions = new int[tasks.size()];
            int[] progresses = new int[tasks.size()];
            int[] filesizes = new int[tasks.size()];
            int[] filecurrentsizes = new int[tasks.size()];
            for (int i = 0; i < tasks.size(); i++) {
                DownloadTask t = tasks.get(i);
                positions[i] = t.mPosition;
                progresses[i] = t.mProgress;
                filesizes[i] = t.mFileSize;
                filecurrentsizes[i] = t.mCurrentFile;
            }
            publishProgress(positions, progresses, filesizes, filecurrentsizes);
        }
    }

    private void publishCurrentProgressOneShot() {
        publishCurrentProgressOneShot(false);
    }

    private synchronized void publishProgress(int[] positions,
                                              int[] progresses, int[] filesizes, int[] currentfilesize) {
        Intent i = new Intent();
        i.setAction(PROGRESS_UPDATE_ACTION);
        i.putExtra("position", positions);
        i.putExtra("progress", progresses);
        i.putExtra("oneshot", true);
        i.putExtra("filesizes", filesizes);
        i.putExtra("filecurrentsizes", currentfilesize);
        mBroadcastManager.sendBroadcast(i);
    }

    // following methods can also be used but will cause lots of broadcasts
    private void publishCurrentProgress() {
        final Collection<DownloadTask> tasks = mTasks;
        for (DownloadTask t : tasks) {
            publishProgress(t.mPosition, t.mProgress, t.mFileSize, t.mCurrentFile);
        }
    }

    private synchronized void publishProgress(int position, int progress, int filesize, int currentsize) {
        Intent i = new Intent();
        i.setAction(PROGRESS_UPDATE_ACTION);
        i.putExtra("progress", progress);
        i.putExtra("position", position);
        i.putExtra("filesize", filesize);
        i.putExtra("filecurrentsize", currentsize);
        mBroadcastManager.sendBroadcast(i);
    }

    class DownloadTask implements Callable<NoResultType> {
        private int mPosition;
        private int mProgress;
        private int mCurrentFile;
        private int mFileSize;
        private boolean mCancelled;
        private final File mFile;
        private Random mRand = new Random();

        public DownloadTask(int position, File file) {
            mPosition = position;
            mFile = file;
        }

        @Override
        public NoResultType call() throws Exception {

            int fileLength = 0;
            try {

                URL url = new URL(mFile.getUrl());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.connect();
                // this will be useful so that you can show a typical 0-100% progress bar
                fileLength = connection.getContentLength();
                mFileSize = fileLength;

                // download the file
                InputStream input = new BufferedInputStream(connection.getInputStream());
                OutputStream output;
                if (!TextUtils.isEmpty(mFile.getName())) {
                    output = new FileOutputStream("sdcard/" + mFile.getName() + ".gz");
                } else {
                    output = new FileOutputStream("/sdcard/file.gz");
                }

                byte data[] = new byte[1024];
                long total = 0;
                int count;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    mCurrentFile = (int)total;
                    mProgress = (((int)total * 100)/ fileLength) ;
                    output.write(data, 0, count);
                    // publishing the progress....
                    publishCurrentProgressOneShot();
                }

                output.flush();
                output.close();
                input.close();

                output = null; input = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new NoResultType();
        }

        public int getProgress() {
            return mProgress;
        }

        public int getPosition() {
            return mPosition;
        }

        public void cancel() {
            mCancelled = true;
        }
    }

    private void registerReceiver() {
        unregisterReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(DownloadingService.ACTION_CANCEL_DOWNLOAD);
        LocalBroadcastManager.getInstance(this).registerReceiver(
                mCommunicationReceiver, filter);
        mReceiversRegistered = true;
    }

    private void unregisterReceiver() {
        if (mReceiversRegistered) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(
                    mCommunicationReceiver);
            mReceiversRegistered = false;
        }
    }

    private final BroadcastReceiver mCommunicationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(
                    DownloadingService.ACTION_CANCEL_DOWNLOAD)) {
                final long id = intent.getLongExtra(ID, -1);
                if (id != -1) {
                    for (DownloadTask task : mTasks) {
                        if (task.mFile.getId() == id) {
                            task.cancel();
                            break;
                        }
                    }
                }
            }
        }
    };

    class NoResultType {
    }
}
