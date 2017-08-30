package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aldi on 8/30/2017.
 */

public class Hour implements Parcelable {
    @SerializedName("status")
    private String status;
    @SerializedName("richStatus")
    private Richstatus richstatus;
    @SerializedName("isOpen")
    private boolean isopen;
    @SerializedName("isLocalHoliday")
    private boolean islocalholiday;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Richstatus getRichstatus() {
        return richstatus;
    }

    public void setRichstatus(Richstatus richstatus) {
        this.richstatus = richstatus;
    }

    public boolean getIsopen() {
        return isopen;
    }

    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }

    public boolean getIslocalholiday() {
        return islocalholiday;
    }

    public void setIslocalholiday(boolean islocalholiday) {
        this.islocalholiday = islocalholiday;
    }

    public static class Entities {
    }

    public static class Richstatus implements Parcelable {
        @SerializedName("entities")
        private List<Entities> entities;
        @SerializedName("text")
        private String text;

        public List<Entities> getEntities() {
            return entities;
        }

        public void setEntities(List<Entities> entities) {
            this.entities = entities;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeList(this.entities);
            dest.writeString(this.text);
        }

        public Richstatus() {
        }

        protected Richstatus(Parcel in) {
            this.entities = new ArrayList<Entities>();
            in.readList(this.entities, Entities.class.getClassLoader());
            this.text = in.readString();
        }

        public static final Creator<Richstatus> CREATOR = new Creator<Richstatus>() {
            @Override
            public Richstatus createFromParcel(Parcel source) {
                return new Richstatus(source);
            }

            @Override
            public Richstatus[] newArray(int size) {
                return new Richstatus[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeParcelable(this.richstatus, flags);
        dest.writeByte(this.isopen ? (byte) 1 : (byte) 0);
        dest.writeByte(this.islocalholiday ? (byte) 1 : (byte) 0);
    }

    public Hour() {
    }

    protected Hour(Parcel in) {
        this.status = in.readString();
        this.richstatus = in.readParcelable(Richstatus.class.getClassLoader());
        this.isopen = in.readByte() != 0;
        this.islocalholiday = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Hour> CREATOR = new Parcelable.Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel source) {
            return new Hour(source);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };
}
