package com.korvac.liquidpay.testvenue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldi on 8/29/2017.
 */

public class Item {

    @SerializedName("reasons")
    private Reason reasons;
    @SerializedName("venue")
    private Venue venue;
    @SerializedName("tips")
    private List<Object> tips;
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

    public List<Object> getTips() {
        return tips;
    }

    public void setTips(List<Object> tips) {
        this.tips = tips;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }
}
