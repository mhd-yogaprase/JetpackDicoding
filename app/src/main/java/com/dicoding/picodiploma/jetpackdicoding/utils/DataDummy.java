package com.dicoding.picodiploma.jetpackdicoding.utils;

import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Movie;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.MovieDetail;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Tv;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.TvDetail;

import java.util.ArrayList;

public class DataDummy {
    public static ArrayList<Movie> generateDummyMovie(){
        ArrayList<Movie> movie = new ArrayList<>();

        movie.add(new Movie(
                475303,
                "A Rainy Day in New York",
                "2019-07-26",
                "/uPGq1mkEXznUpapDmOSxbsybjfp.jpg"));
        movie.add(new Movie(
                666750,
                "Dragonheart: Vengeance",
                "2020-02-04",
                "/qZ1KAgfdeNbzrNYKW4BIRHdEBJ9.jpg"));
        movie.add(new Movie(
                512200,
                "Jumanji: The Next Level",
                "2019-12-04",
                "/bB42KDdfWkOvmzmYkmK58ZlCa9P.jpg"));
        movie.add(new Movie(
                454626,
                "Sonic the Hedgehog",
                "2020-02-12",
                "/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg"));
        movie.add(new Movie(
                419704,
                "Ad Astra",
                "2019-09-17",
                "/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg"));

        return movie;
    }

    public static ArrayList<Tv> generateDummyTv(){
        ArrayList<Tv> tv = new ArrayList<>();

        tv.add(new Tv(
                456,
                "The Simpsons",
                "1989-12-17",
                "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg"));
        tv.add(new Tv(
                93533,
                "Thieves of the Wood",
                "2020-01-02",
                "/jQNOzoiaIQWxJAx8OUighnvnhRA.jpg"));
        tv.add(new Tv(
                2734,
                "Law & Order: Special Victims Unit",
                "1999-09-20",
                "/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg"));
        tv.add(new Tv(
                4194,
                "Star Wars: The Clone Wars",
                "2008-10-03",
                "/p6s2svEHHLsQ1TOw4Si54c1dD5L.jpg"));
        tv.add(new Tv(
                60735,
                "The Flash",
                "2014-10-07",
                "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"));

        return tv;
    }

    public static MovieDetail generateDummyMovieDetail(int movieId){
        return new MovieDetail(
                movieId,
                "A Rainy Day in New York",
                "2019-07-26",
                "/uPGq1mkEXznUpapDmOSxbsybjfp.jpg",
                "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                "Released",
                621,
                6.7);
    }

    public static TvDetail generateDummyTvDetail(int tvId){
        return new TvDetail(
                tvId,
                "The Simpsons",
                "1989-12-17",
                "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                "/mRYqoCJMmlbtrU6r7vMgzCVnSsX.jpg",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "Returning Series",
                2460,
                7.2);
    }
}
