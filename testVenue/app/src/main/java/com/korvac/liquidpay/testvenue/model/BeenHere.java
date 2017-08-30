package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aldi on 8/29/2017.
 */

public class BeenHere implements Parcelable {

    private Integer count;
    private Boolean marked;
    private Long lastCheckinExpiredAt;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    public Long getLastCheckinExpiredAt() {
        return lastCheckinExpiredAt;
    }

    public void setLastCheckinExpiredAt(Long lastCheckinExpiredAt) {
        this.lastCheckinExpiredAt = lastCheckinExpiredAt;
    }

    public BeenHere() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.count);
        dest.writeValue(this.marked);
        dest.writeValue(this.lastCheckinExpiredAt);
    }

    protected BeenHere(Parcel in) {
        this.count = (Integer) in.readValue(Integer.class.getClassLoader());
        this.marked = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.lastCheckinExpiredAt = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Creator<BeenHere> CREATOR = new Creator<BeenHere>() {
        @Override
        public BeenHere createFromParcel(Parcel source) {
            return new BeenHere(source);
        }

        @Override
        public BeenHere[] newArray(int size) {
            return new BeenHere[size];
        }
    };
}
