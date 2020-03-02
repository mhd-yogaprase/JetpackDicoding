package com.dicoding.picodiploma.jetpackdicoding.data;

public class MovieEntity {
    private String id;
    private String title;
    private String overview;
    private String releaseDate;
    private String originalLanguage;
    private String genre;
    private String poster;
    private String runtime;

    public MovieEntity(String id, String title, String overview, String releaseDate,
                       String originalLanguage, String genre, String poster, String runtime) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
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

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
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
