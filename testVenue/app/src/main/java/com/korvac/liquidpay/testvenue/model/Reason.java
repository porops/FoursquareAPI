package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldi on 8/29/2017.
 */

public class Reason implements Parcelable {

    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<ReasonItem> reasonItem;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ReasonItem> getReasonItem() {
        return reasonItem;
    }

    public void setReasonItem(List<ReasonItem> reasonItem) {
        this.reasonItem = reasonItem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.count);
        dest.writeTypedList(this.reasonItem);
    }

    public Reason() {
    }

    protected Reason(Parcel in) {
        this.count = (Integer) in.readValue(Integer.class.getClassLoader());
        this.reasonItem = in.createTypedArrayList(ReasonItem.CREATOR);
    }

    public static final Parcelable.Creator<Reason> CREATOR = new Parcelable.Creator<Reason>() {
        @Override
        public Reason createFromParcel(Parcel source) {
            return new Reason(source);
        }

        @Override
        public Reason[] newArray(int size) {
            return new Reason[size];
        }
    };
}
