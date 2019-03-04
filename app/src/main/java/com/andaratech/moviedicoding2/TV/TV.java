package com.andaratech.moviedicoding2.TV;

import android.os.Parcel;
import android.os.Parcelable;

public class TV implements Parcelable {
    private String name, release, description;
    private int photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.release);
        dest.writeString(this.description);
        dest.writeInt(this.photo);
    }

    public TV() {
    }

    protected TV(Parcel in) {
        this.name = in.readString();
        this.release = in.readString();
        this.description = in.readString();
        this.photo = in.readInt();
    }

    public static final Parcelable.Creator<TV> CREATOR = new Parcelable.Creator<TV>() {
        @Override
        public TV createFromParcel(Parcel source) {
            return new TV(source);
        }

        @Override
        public TV[] newArray(int size) {
            return new TV[size];
        }
    };
}
