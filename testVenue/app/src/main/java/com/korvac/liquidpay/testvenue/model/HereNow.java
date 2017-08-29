package com.korvac.liquidpay.testvenue.model;

import java.util.List;

/**
 * Created by aldi on 8/29/2017.
 */

public class HereNow {

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
}
