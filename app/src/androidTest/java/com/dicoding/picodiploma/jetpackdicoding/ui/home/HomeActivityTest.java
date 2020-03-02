package com.dicoding.picodiploma.jetpackdicoding.ui.home;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.dicoding.picodiploma.jetpackdicoding.R;
import com.dicoding.picodiploma.jetpackdicoding.data.MovieEntity;
import com.dicoding.picodiploma.jetpackdicoding.data.TvEntity;
import com.dicoding.picodiploma.jetpackdicoding.utils.DataDummy;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class HomeActivityTest {
    private ArrayList<MovieEntity> dummyMovie = DataDummy.generateDummyMovie();
    private ArrayList<TvEntity> dummyTv = DataDummy.generateDummyTv();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void loadMovies(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(dummyMovie.size()));
    }

    @Test
    public void loadTv(){
        onView(withContentDescription(R.string.tab_tv)).perform(click());
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition(dummyTv.size()));
    }

    @Test
    public void loadDetailMovies(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie.get(0).getTitle())));
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date)).check(matches(withText(dummyMovie.get(0).getReleaseDate())));
        onView(withId(R.id.tv_time)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_time)).check(matches(withText(dummyMovie.get(0).getRuntime())));
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyMovie.get(0).getGenre())));
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovie.get(0).getOverview())));
    }

    @Test
    public void loadDetailTv(){
        onView(withContentDescription(R.string.tab_tv)).perform(click());
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTv.get(0).getName())));
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date)).check(matches(withText(dummyTv.get(0).getFirstAirDate())));
        onView(withId(R.id.tv_time)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_time)).check(matches(withText(dummyTv.get(0).getRuntime())));
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyTv.get(0).getGenre())));
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyTv.get(0).getOverview())));

    }
}