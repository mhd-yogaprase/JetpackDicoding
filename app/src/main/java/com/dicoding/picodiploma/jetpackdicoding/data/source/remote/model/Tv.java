package com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Tv implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("first_air_date")
    private String firstAirDate;

    @SerializedName("poster_path")
    private String posterPath;

    public Tv() {
    }

    public Tv(int id, String name, String firstAirDate, String posterPath) {
        this.id = id;
        this.name = name;
        this.firstAirDate = firstAirDate;
        this.posterPath = posterPath;
    }

    protected Tv(Parcel in) {
        id = in.readInt();
        name = in.readString();
        firstAirDate = in.readString();
        posterPath = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(firstAirDate);
        dest.writeString(posterPath);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tv> CREATOR = new Creator<Tv>() {
        @Override
        public Tv createFromParcel(Parcel in) {
            return new Tv(in);
        }

        @Override
        public Tv[] newArray(int size) {
            return new Tv[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

}
