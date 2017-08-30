package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aldi on 8/29/2017.
 */

public class PrefSuf implements Parcelable {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.prefix);
        dest.writeString(this.suffix);
    }

    public PrefSuf() {
    }

    protected PrefSuf(Parcel in) {
        this.prefix = in.readString();
        this.suffix = in.readString();
    }

    public static final Parcelable.Creator<PrefSuf> CREATOR = new Parcelable.Creator<PrefSuf>() {
        @Override
        public PrefSuf createFromParcel(Parcel source) {
            return new PrefSuf(source);
        }

        @Override
        public PrefSuf[] newArray(int size) {
            return new PrefSuf[size];
        }
    };
}
