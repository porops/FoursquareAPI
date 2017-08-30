package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aldi on 8/29/2017.
 */

public class Venue implements Parcelable {

    private String id;
    private String name;
//    private Object contact;
    private Location location;
    private List<Category> categories;
    private Boolean verified;
    private Stat stats;
    private Price price;
    private Double rating;
    private String ratingColor;
    private Integer ratingSignals;
    private Boolean allowMenuUrlEdit;
    private BeenHere beenHere;
    private Hour hours;
    private Photo photos;
    private HereNow hereNow;

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

//    public Object getContact() {
//        return contact;
//    }

//    public void setContact(Object contact) {
//        this.contact = contact;
//    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Stat getStats() {
        return stats;
    }

    public void setStats(Stat stats) {
        this.stats = stats;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public Integer getRatingSignals() {
        return ratingSignals;
    }

    public void setRatingSignals(Integer ratingSignals) {
        this.ratingSignals = ratingSignals;
    }

    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public BeenHere getBeenHere() {
        return beenHere;
    }

    public void setBeenHere(BeenHere beenHere) {
        this.beenHere = beenHere;
    }

    public Hour getHours() {
        return hours;
    }

    public void setHours(Hour hours) {
        this.hours = hours;
    }

    public Photo getPhotos() {
        return photos;
    }

    public void setPhotos(Photo photos) {
        this.photos = photos;
    }

    public HereNow getHereNow() {
        return hereNow;
    }

    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeParcelable(this.location, flags);
        dest.writeList(this.categories);
        dest.writeValue(this.verified);
        dest.writeParcelable(this.stats, flags);
        dest.writeParcelable(this.price, flags);
        dest.writeValue(this.rating);
        dest.writeString(this.ratingColor);
        dest.writeValue(this.ratingSignals);
        dest.writeValue(this.allowMenuUrlEdit);
        dest.writeParcelable(this.beenHere, flags);
        dest.writeParcelable(this.hours, flags);
        dest.writeParcelable(this.photos, flags);
        dest.writeParcelable(this.hereNow, flags);
    }

    public Venue() {
    }

    protected Venue(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.categories = new ArrayList<Category>();
        in.readList(this.categories, Category.class.getClassLoader());
        this.verified = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.stats = in.readParcelable(Stat.class.getClassLoader());
        this.price = in.readParcelable(Price.class.getClassLoader());
        this.rating = (Double) in.readValue(Double.class.getClassLoader());
        this.ratingColor = in.readString();
        this.ratingSignals = (Integer) in.readValue(Integer.class.getClassLoader());
        this.allowMenuUrlEdit = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.beenHere = in.readParcelable(BeenHere.class.getClassLoader());
        this.hours = in.readParcelable(Hour.class.getClassLoader());
        this.photos = in.readParcelable(Photo.class.getClassLoader());
        this.hereNow = in.readParcelable(HereNow.class.getClassLoader());
    }

    public static final Parcelable.Creator<Venue> CREATOR = new Parcelable.Creator<Venue>() {
        @Override
        public Venue createFromParcel(Parcel source) {
            return new Venue(source);
        }

        @Override
        public Venue[] newArray(int size) {
            return new Venue[size];
        }
    };
}
