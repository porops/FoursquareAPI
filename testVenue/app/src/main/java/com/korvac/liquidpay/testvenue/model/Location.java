package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aldi on 8/29/2017.
 */

public class Location implements Parcelable {

    private String address;
    private Double lat;
    private Double lng;
    private List<Object> labeledLatLngs;
    private Double distance;
    private String postalCode;
    private String cc;
    private String city;
    private String state;
    private String country;
    private List<String> formattedAddress;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public List<Object> getLabeledLatLngs() {
        return labeledLatLngs;
    }

    public void setLabeledLatLngs(List<Object> labeledLatLngs) {
        this.labeledLatLngs = labeledLatLngs;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(List<String> formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeValue(this.lat);
        dest.writeValue(this.lng);
        dest.writeList(this.labeledLatLngs);
        dest.writeValue(this.distance);
        dest.writeString(this.postalCode);
        dest.writeString(this.cc);
        dest.writeString(this.city);
        dest.writeString(this.state);
        dest.writeString(this.country);
        dest.writeStringList(this.formattedAddress);
    }

    public Location() {
    }

    protected Location(Parcel in) {
        this.address = in.readString();
        this.lat = (Double) in.readValue(Double.class.getClassLoader());
        this.lng = (Double) in.readValue(Double.class.getClassLoader());
        this.labeledLatLngs = new ArrayList<Object>();
        in.readList(this.labeledLatLngs, Object.class.getClassLoader());
        this.distance = (Double) in.readValue(Double.class.getClassLoader());
        this.postalCode = in.readString();
        this.cc = in.readString();
        this.city = in.readString();
        this.state = in.readString();
        this.country = in.readString();
        this.formattedAddress = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
