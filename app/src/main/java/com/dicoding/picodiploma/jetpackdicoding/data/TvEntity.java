package com.dicoding.picodiploma.jetpackdicoding.data;

public class TvEntity {
    private String id;
    private String name;
    private String overview;
    private String releaseDate;
    private String poster;
    private String runtime;

    public TvEntity(String id, String name, String overview, String releaseDate, String poster, String runtime) {
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.poster = poster;
        this.runtime = runtime;
    }

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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }
}
