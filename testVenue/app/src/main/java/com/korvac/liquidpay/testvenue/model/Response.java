package com.korvac.liquidpay.testvenue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldi on 8/29/2017.
 */

public class Response {

    @SerializedName("suggestedFilters")
    private Object suggestedFilter;
    @SerializedName("suggestedRadius")
    private Integer suggestedRadius;
    @SerializedName("headerLocation")
    private String headerLocation;
    @SerializedName("headerFullLocation")
    private String headerFullLocaition;
    @SerializedName("headerLocationGranularity")
    private String headerLocationGranularity;
    @SerializedName("totalResults")
    private Integer totalResults;
    @SerializedName("suggestedBounds")
    private SuggestedBounds suggestedBounds;
    @SerializedName("groups")
    private List<Groups> groups;

    public Object getSuggestedFilter() {
        return suggestedFilter;
    }

    public void setSuggestedFilter(Object suggestedFilter) {
        this.suggestedFilter = suggestedFilter;
    }

    public Integer getSuggestedRadius() {
        return suggestedRadius;
    }

    public void setSuggestedRadius(Integer suggestedRadius) {
        this.suggestedRadius = suggestedRadius;
    }

    public String getHeaderLocation() {
        return headerLocation;
    }

    public void setHeaderLocation(String headerLocation) {
        this.headerLocation = headerLocation;
    }

    public String getHeaderFullLocaition() {
        return headerFullLocaition;
    }

    public void setHeaderFullLocaition(String headerFullLocaition) {
        this.headerFullLocaition = headerFullLocaition;
    }

    public String getHeaderLocationGranularity() {
        return headerLocationGranularity;
    }

    public void setHeaderLocationGranularity(String headerLocationGranularity) {
        this.headerLocationGranularity = headerLocationGranularity;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public SuggestedBounds getSuggestedBounds() {
        return suggestedBounds;
    }

    public void setSuggestedBounds(SuggestedBounds suggestedBounds) {
        this.suggestedBounds = suggestedBounds;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}

