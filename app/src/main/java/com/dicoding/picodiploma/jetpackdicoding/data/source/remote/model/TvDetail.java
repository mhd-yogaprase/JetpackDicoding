package com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TvDetail implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("first_air_date")
    private String firstAirDate;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("overview")
    private String overview;

    @SerializedName("status")
    private String status;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("vote_average")
    private double voteAverage;

    public TvDetail() {
    }

    public TvDetail(int id, String name, String firstAirDate, String posterPath,
                    String backdropPath, String overview, String status, int voteCount, double voteAverage) {
        this.id = id;
        this.name = name;
        this.firstAirDate = firstAirDate;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.overview = overview;
        this.status = status;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
    }

    protected TvDetail(Parcel in) {
        id = in.readInt();
        name = in.readString();
        firstAirDate = in.readString();
        posterPath = in.readString();
        backdropPath = in.readString();
        overview = in.readString();
        status = in.readString();
        voteCount = in.readInt();
        voteAverage = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(firstAirDate);
        dest.writeString(posterPath);
        dest.writeString(backdropPath);
        dest.writeString(overview);
        dest.writeString(status);
        dest.writeInt(voteCount);
        dest.writeDouble(voteAverage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TvDetail> CREATOR = new Creator<TvDetail>() {
        @Override
        public TvDetail createFromParcel(Parcel in) {
            return new TvDetail(in);
        }

        @Override
        public TvDetail[] newArray(int size) {
            return new TvDetail[size];
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

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
