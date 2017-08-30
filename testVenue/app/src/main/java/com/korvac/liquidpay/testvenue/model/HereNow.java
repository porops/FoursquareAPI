package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aldi on 8/29/2017.
 */

public class HereNow implements Parcelable {

    private Integer count;
    private String summary;
    private List<Object> groups;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Object> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.count);
        dest.writeString(this.summary);
        dest.writeList(this.groups);
    }

    public HereNow() {
    }

    protected HereNow(Parcel in) {
        this.count = (Integer) in.readValue(Integer.class.getClassLoader());
        this.summary = in.readString();
        this.groups = new ArrayList<Object>();
        in.readList(this.groups, Object.class.getClassLoader());
    }

    public static final Parcelable.Creator<HereNow> CREATOR = new Parcelable.Creator<HereNow>() {
        @Override
        public HereNow createFromParcel(Parcel source) {
            return new HereNow(source);
        }

        @Override
        public HereNow[] newArray(int size) {
            return new HereNow[size];
        }
    };
}
