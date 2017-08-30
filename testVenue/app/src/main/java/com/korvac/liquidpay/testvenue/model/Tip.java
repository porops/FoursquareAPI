package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aldi on 8/29/2017.
 */

public class Tip implements Parcelable {
    private String id;
    private Long createdAt;
    private String text;
    private String type;
    private String canonicalUrl;
    private Boolean logView;
    private Integer agreeCount;
    private Integer disagreeCount;
    private TipUser user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public Boolean getLogView() {
        return logView;
    }

    public void setLogView(Boolean logView) {
        this.logView = logView;
    }

    public Integer getAgreeCount() {
        return agreeCount;
    }

    public void setAgreeCount(Integer agreeCount) {
        this.agreeCount = agreeCount;
    }

    public Integer getDisagreeCount() {
        return disagreeCount;
    }

    public void setDisagreeCount(Integer disagreeCount) {
        this.disagreeCount = disagreeCount;
    }


    public TipUser getUser() {
        return user;
    }

    public void setUser(TipUser user) {
        this.user = user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeValue(this.createdAt);
        dest.writeString(this.text);
        dest.writeString(this.type);
        dest.writeString(this.canonicalUrl);
        dest.writeValue(this.logView);
        dest.writeValue(this.agreeCount);
        dest.writeValue(this.disagreeCount);
        dest.writeParcelable(this.user, flags);
    }

    public Tip() {
    }

    protected Tip(Parcel in) {
        this.id = in.readString();
        this.createdAt = (Long) in.readValue(Long.class.getClassLoader());
        this.text = in.readString();
        this.type = in.readString();
        this.canonicalUrl = in.readString();
        this.logView = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.agreeCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.disagreeCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.user = in.readParcelable(TipUser.class.getClassLoader());
    }

    public static final Parcelable.Creator<Tip> CREATOR = new Parcelable.Creator<Tip>() {
        @Override
        public Tip createFromParcel(Parcel source) {
            return new Tip(source);
        }

        @Override
        public Tip[] newArray(int size) {
            return new Tip[size];
        }
    };
}
