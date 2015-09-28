package com.stengg.stee.stelectronics.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stengg.stee.stelectronics.R;
import com.stengg.stee.stelectronics.activities.AssetDetails;
import com.stengg.stee.stelectronics.models.Asset;

import java.util.ArrayList;
import java.util.List;

public class AssetAdapter extends RecyclerView.Adapter<AssetAdapter.ViewHolder> {
    public static final String POSITION = "position";

    private List<Asset> mDataset;
    private Context mContext;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvAsset;
        public TextView tvDesc;
        public TextView tvAssetCode;
        public TextView tvLoc;
        public TextView tvLocCode;
        public TextView tvUsage;
        public TextView tvType;
        public TextView tvParent;

        public ViewHolder(View v) {
            super(v);
            tvAsset = (TextView) v.findViewById(R.id.tv_asset_id);
            tvDesc = (TextView) v.findViewById(R.id.tv_description);
            tvAssetCode = (TextView) v.findViewById(R.id.tv_asset_code);
            tvLoc = (TextView) v.findViewById(R.id.tv_location);
            tvLocCode = (TextView) v.findViewById(R.id.tv_location_code);
            tvUsage = (TextView) v.findViewById(R.id.tv_usage);
            tvType = (TextView) v.findViewById(R.id.tv_type);
            tvParent = (TextView) v.findViewById(R.id.tv_parent);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AssetAdapter(Context context, List<Asset> myDataset) {
        mContext = context;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AssetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_assets_list, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        Asset currentAsset = mDataset.get(position);

        // - replace the contents of the view with that element
        holder.tvAsset.setText(currentAsset.getASSETID());
        holder.tvDesc.setText(currentAsset.getDESCRIPTION());
        holder.tvAssetCode.setText(currentAsset.getASSETCODE());
        holder.tvLoc.setText(currentAsset.getLOCATION());
        holder.tvLocCode.setText(currentAsset.getLOCATION());
        holder.tvUsage.setText(currentAsset.getUSAGE());
        holder.tvType.setText(currentAsset.getASSETTYPE());
        holder.tvParent.setText(currentAsset.getPARENT());

        // change background color
        if ((position % 2) == 0)
            holder.itemView.setBackgroundColor(mContext.getResources()
                    .getColor(android
                            .R.color
                            .darker_gray));
        else
            holder.itemView.setBackgroundColor(mContext.getResources().getColor(android.R.color
                    .background_light));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AssetDetails.class);
                intent.putExtra(POSITION, position);
                mContext.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void refresh(List<Asset> myDataset) {
        this.mDataset = new ArrayList<>(myDataset);
        notifyDataSetChanged();
    }
}