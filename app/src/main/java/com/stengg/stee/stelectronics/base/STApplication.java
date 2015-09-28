package com.stengg.stee.stelectronics.base;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

import com.stengg.stee.stelectronics.models.Asset;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raymondbalingit on 9/29/15.
 */
public class STApplication extends Application {
    private static STApplication mInstance;
    SharedPreferences mPref;
    private List<Asset> mAssets;

    public static STApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mInstance.initializeInstance();
    }

    private void initializeInstance() {

        // Do your application wise initialization task
        screenConfiguration();

        // set application wise preference
        mPref = this.getApplicationContext().getSharedPreferences("pref_key", MODE_PRIVATE);
    }



    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void screenConfiguration() {
        Configuration config = getResources().getConfiguration();
        boolean isTab = (config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;


        Point size = new Point();
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        int deviceScreenWidth;
        int deviceScreenHeight;

        try {
            display.getSize(size);
            deviceScreenWidth = size.x;
            deviceScreenHeight = size.y;
        } catch (NoSuchMethodError e) {
            deviceScreenWidth = display.getWidth();
            deviceScreenHeight = display.getHeight();
        }
    }

    public boolean isFirstRun() {
        // return true if the app is running for the first time
        return mPref.getBoolean("is_first_run", true);
    }

    public void setRunned() {
        // after a successful run, call this method to set first run false
        SharedPreferences.Editor edit = mPref.edit();
        edit.putBoolean("is_first_run", false);
        edit.commit();
    }

    @Override
    public void onTerminate() {
        // Do your application wise Termination task
        super.onTerminate();
    }

    public List<Asset> getAssetList() {
        return mAssets;
    }

    public void setAssets(List<Asset> mAssets) {
        this.mAssets = mAssets;
    }
}
