package com.dicoding.picodiploma.jetpackdicoding.data;

public class TvEntity {
    private String id;
    private String name;
    private String overview;
    private String firstAirDate;
    private String originalLanguage;
    private String genre;
    private String poster;
    private String runtime;

    public TvEntity(String id, String name, String overview, String firstAirDate,
                    String originalLanguage, String genre, String poster, String runtime) {
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.firstAirDate = firstAirDate;
        this.originalLanguage = originalLanguage;
        this.genre = genre;
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

    public String getOverview() {
        return overview;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }


    public String getGenre() {
        return genre;
    }


    public String getPoster() {
        return poster;
    }


    public String getRuntime() {
        return runtime;
    }

}
