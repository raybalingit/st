package com.stengg.stee.stelectronics.services;

import android.os.Parcel;
import android.os.Parcelable;

public class File implements Parcelable {
    private final long id;
    private final String url;
    private int progress;
    private final String name;
    private int filesize;
    private int currentsize;


    public File(String name, long id, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return url + " " + progress + " %";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.url);
        dest.writeInt(this.progress);
        dest.writeString(this.name);
    }

    private File(Parcel in) {
        this.id = in.readLong();
        this.url = in.readString();
        this.progress = in.readInt();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<File> CREATOR = new Parcelable.Creator<File>() {
        public File createFromParcel(Parcel source) {
            return new File(source);
        }

        public File[] newArray(int size) {
            return new File[size];
        }
    };


    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    public int getCurrentsize() {
        return currentsize;
    }

    public void setCurrentsize(int currentsize) {
        this.currentsize = currentsize;
    }
}