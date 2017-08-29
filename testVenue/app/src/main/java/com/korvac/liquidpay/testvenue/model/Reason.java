package com.korvac.liquidpay.testvenue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldi on 8/29/2017.
 */

public class Reason {

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
}
