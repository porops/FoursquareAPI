package com.korvac.liquidpay.testvenue.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aldi on 8/29/2017.
 */

public class TipUser implements Parcelable {

    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private PrefSuf photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PrefSuf getPhoto() {
        return photo;
    }

    public void setPhoto(PrefSuf photo) {
        this.photo = photo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.gender);
        dest.writeParcelable(this.photo, flags);
    }

    public TipUser() {
    }

    protected TipUser(Parcel in) {
        this.id = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.gender = in.readString();
        this.photo = in.readParcelable(PrefSuf.class.getClassLoader());
    }

    public static final Parcelable.Creator<TipUser> CREATOR = new Parcelable.Creator<TipUser>() {
        @Override
        public TipUser createFromParcel(Parcel source) {
            return new TipUser(source);
        }

        @Override
        public TipUser[] newArray(int size) {
            return new TipUser[size];
        }
    };
}
