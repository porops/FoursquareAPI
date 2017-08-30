package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldi on 8/29/2017.
 */

public class Item implements Parcelable {

    @SerializedName("reasons")
    private Reason reasons;
    @SerializedName("venue")
    private Venue venue;
    @SerializedName("tips")
    private List<Tip> tips;
    @SerializedName("referralId")
    private String referralId;

    public Reason getReasons() {
        return reasons;
    }

    public void setReasons(Reason reasons) {
        this.reasons = reasons;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Tip> getTips() {
        return tips;
    }

    public void setTips(List<Tip> tips) {
        this.tips = tips;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.reasons, flags);
        dest.writeParcelable(this.venue, flags);
        dest.writeTypedList(this.tips);
        dest.writeString(this.referralId);
    }

    public Item() {
    }

    protected Item(Parcel in) {
        this.reasons = in.readParcelable(Reason.class.getClassLoader());
        this.venue = in.readParcelable(Venue.class.getClassLoader());
        this.tips = in.createTypedArrayList(Tip.CREATOR);
        this.referralId = in.readString();
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
