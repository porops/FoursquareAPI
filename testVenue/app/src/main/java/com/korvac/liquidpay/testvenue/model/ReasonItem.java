package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aldi on 8/29/2017.
 */

public class ReasonItem implements Parcelable {
    private String summary;
    private String type;
    private String reasonName;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.summary);
        dest.writeString(this.type);
        dest.writeString(this.reasonName);
    }

    public ReasonItem() {
    }

    protected ReasonItem(Parcel in) {
        this.summary = in.readString();
        this.type = in.readString();
        this.reasonName = in.readString();
    }

    public static final Parcelable.Creator<ReasonItem> CREATOR = new Parcelable.Creator<ReasonItem>() {
        @Override
        public ReasonItem createFromParcel(Parcel source) {
            return new ReasonItem(source);
        }

        @Override
        public ReasonItem[] newArray(int size) {
            return new ReasonItem[size];
        }
    };
}
