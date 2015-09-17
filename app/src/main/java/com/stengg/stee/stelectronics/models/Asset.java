package com.stengg.stee.stelectronics.models;

/**
 * Created by Raymond Balingit on 18/9/2015.
 */
public class Asset {

    private String mAssetNum;
    private String mAssetCode;
    private String mDescription;
    private String mLocation;
    private String mLocationCode;
    private String mUsage;
    private String mType;
    private String mParent;

    public Asset(String assetNum, String assetCode, String description, String location, String locationCode,
                 String usage, String type, String parent) {
        setAssetNum(assetNum);
        setAssetCode(assetCode);
        setDescription(description);
        setLocation(location);
        setLocationCode(locationCode);
        setUsage(usage);
        setType(type);
        setParent(parent);
    }

    public String getAssetNum() {
        return mAssetNum;
    }

    public void setAssetNum(String mAssetNum) {
        this.mAssetNum = mAssetNum;
    }

    public String getAssetCode() {
        return mAssetCode;
    }

    public void setAssetCode(String mAssetCode) {
        this.mAssetCode = mAssetCode;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getLocationCode() {
        return mLocationCode;
    }

    public void setLocationCode(String mLocationCode) {
        this.mLocationCode = mLocationCode;
    }

    public String getUsage() {
        return mUsage;
    }

    public void setUsage(String mUsage) {
        this.mUsage = mUsage;
    }

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public String getParent() {
        return mParent;
    }

    public void setParent(String mParent) {
        this.mParent = mParent;
    }
}
