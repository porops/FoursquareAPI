package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aldi on 8/29/2017.
 */

public class Stat implements Parcelable {
    private Integer checkinsCount;
    private Integer usersCount;
    private Integer tipCount;

    public Integer getCheckinsCount() {
        return checkinsCount;
    }

    public void setCheckinsCount(Integer checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public Integer getTipCount() {
        return tipCount;
    }

    public void setTipCount(Integer tipCount) {
        this.tipCount = tipCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.checkinsCount);
        dest.writeValue(this.usersCount);
        dest.writeValue(this.tipCount);
    }

    public Stat() {
    }

    protected Stat(Parcel in) {
        this.checkinsCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.usersCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.tipCount = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Stat> CREATOR = new Parcelable.Creator<Stat>() {
        @Override
        public Stat createFromParcel(Parcel source) {
            return new Stat(source);
        }

        @Override
        public Stat[] newArray(int size) {
            return new Stat[size];
        }
    };
}
