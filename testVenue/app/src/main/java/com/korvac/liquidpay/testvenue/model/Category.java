package com.korvac.liquidpay.testvenue.model;

/**
 * Created by aldi on 8/29/2017.
 */

public class Category {

    private String id;
    private String name;
    private String pluralName;
    private String shortName;
    private PrefSuf icon;
    private Boolean primary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public PrefSuf getIcon() {
        return icon;
    }

    public void setIcon(PrefSuf icon) {
        this.icon = icon;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }
}
