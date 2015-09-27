package com.stengg.stee.stelectronics.models;

import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by Raymond Balingit on 24/9/2015.
 */
public class MblAssetSet {

    @ElementList(entry="ASSET", inline=true)
    private List<Asset> ASSET;

    public List<Asset> getASSET ()
    {
        return ASSET;
    }

    public void setASSET (List<Asset> ASSET)
    {
        this.ASSET = ASSET;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ASSET = "+ASSET+"]";
    }
}
