package com.stengg.stee.stelectronics.activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.stengg.stee.stelectronics.R;
import com.stengg.stee.stelectronics.adapter.AssetAdapter;
import com.stengg.stee.stelectronics.base.STApplication;
import com.stengg.stee.stelectronics.models.Asset;

public class AssetDetails extends AppCompatActivity {

    private Asset mAsset;

    private CoordinatorLayout mSnackbar;
    private TextView tvContent;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_details);

        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        mSnackbar = (CoordinatorLayout) findViewById(R.id.snackbarPosition);
        tvContent = (TextView) findViewById(R.id.tv_content);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int position = getIntent().getIntExtra(AssetAdapter.POSITION, 0);

        mAsset = STApplication.getInstance().getAssetList().get(position);

        if (mAsset != null) {
            tvContent.setText(mAsset.toString());
        } else {
            Snackbar.make(mSnackbar, "An unknown problem has occured.", Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_asset_details, menu);
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
}
