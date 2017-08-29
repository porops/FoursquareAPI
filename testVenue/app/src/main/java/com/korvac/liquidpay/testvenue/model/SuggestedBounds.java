package com.korvac.liquidpay.testvenue.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldi on 8/29/2017.
 */

public class SuggestedBounds {

    @SerializedName("ne")
    private LatLng northest;
    @SerializedName("sw")
    private LatLng southest;

    public LatLng getNorthest() {
        return northest;
    }

    public void setNorthest(LatLng northest) {
        this.northest = northest;
    }

    public LatLng getSouthest() {
        return southest;
    }

    public void setSouthest(LatLng southest) {
        this.southest = southest;
    }
}
