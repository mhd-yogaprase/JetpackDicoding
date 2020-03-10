package com.dicoding.picodiploma.jetpackdicoding.ui.home;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.dicoding.picodiploma.jetpackdicoding.R;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Movie;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Tv;
import com.dicoding.picodiploma.jetpackdicoding.utils.DataDummy;
import com.dicoding.picodiploma.jetpackdicoding.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
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
    private ArrayList<Movie> dummyMovie = DataDummy.generateDummyMovie();
    private ArrayList<Tv> dummyTv = DataDummy.generateDummyTv();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Before
    public void setUp(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity());
    }

    @After
    public void tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity());
    }

    @Test
    public void loadMovie(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(dummyMovie.size()));
    }

    @Test
    public void loadDetailMovie(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyMovie.get(0).getTitle())));
        onView(withId(R.id.tv_detail_date)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_date)).check(matches(withText(dummyMovie.get(0).getReleaseDate())));
    }

    @Test
    public void loadTv(){
        onView(withContentDescription(R.string.tab_tv)).perform(click());
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition(dummyTv.size()));
    }

    @Test
    public void loadDetailTv(){
        onView(withContentDescription(R.string.tab_tv)).perform(click());
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyTv.get(0).getName())));
        onView(withId(R.id.tv_detail_date)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_detail_date)).check(matches(withText(dummyTv.get(0).getFirstAirDate())));
    }
}