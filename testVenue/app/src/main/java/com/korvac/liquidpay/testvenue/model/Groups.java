package com.korvac.liquidpay.testvenue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldi on 8/29/2017.
 */

public class Groups {

    @SerializedName("type")
    private String type;
    @SerializedName("name")
    private String name;
    @SerializedName("items")
    private List<Item> items;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
