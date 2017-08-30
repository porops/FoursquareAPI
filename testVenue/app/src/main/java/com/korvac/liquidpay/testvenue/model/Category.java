package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aldi on 8/29/2017.
 */

public class Category implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.pluralName);
        dest.writeString(this.shortName);
        dest.writeParcelable(this.icon, flags);
        dest.writeValue(this.primary);
    }

    public Category() {
    }

    protected Category(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.pluralName = in.readString();
        this.shortName = in.readString();
        this.icon = in.readParcelable(PrefSuf.class.getClassLoader());
        this.primary = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
