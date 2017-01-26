package com.avidcoder.jsonparsingquiz;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.avidcoder.jsonparsingquiz.controllers.MoviesController;
import com.avidcoder.jsonparsingquiz.models.Movie;
import com.avidcoder.jsonparsingquiz.util.JsonUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class MoviesControllerTests {

    private String mJsonToAssert;
    private Movie mExpectedMovie;
    private MoviesController mController;

    private static final String testJson = "{\"Title\":\"Batman v Superman: Dawn of Justice\",\"Year\":\"2016\",\"Rated\":\"PG-13\",\"Released\":\"25 Mar 2016\",\"Runtime\":\"151 min\",\"Genre\":\"Action, Adventure, Sci-Fi\",\"Director\":\"Zack Snyder\",\"Writer\":\"Chris Terrio, David S. Goyer, Bob Kane (Batman created by), Bill Finger (Batman created by), Jerry Siegel (Superman created by), Joe Shuster (Superman created by)\",\"Actors\":\"Ben Affleck, Henry Cavill, Amy Adams, Jesse Eisenberg\",\"Plot\":\"The general public is concerned over having Superman on their planet and letting the \\\"Dark Knight\\\" - Batman - pursue the streets of Gotham. While this is happening, a power-phobic Batman tries to attack Superman.,Meanwhile Superman tries to settle on a decision, and Lex Luthor, the criminal mastermind and millionaire, tries to use his own advantages to fight the \\\"Man of Steel\\\".\",\"Language\":\"English\",\"Country\":\"USA\",\"Awards\":\"3 wins & 14 nominations.\",\"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BYThjYzcyYzItNTVjNy00NDk0LTgwMWQtYjMwNmNlNWJhMzMyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\",\"Metascore\":\"44\",\"imdbRating\":\"6.7\",\"imdbVotes\":\"438,291\",\"imdbID\":\"tt2975590\",\"Type\":\"movie\",\"Response\":\"True\"}";

    @Before
    public void setup() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.avidcoder.jsonparsingquiz", appContext.getPackageName());

        mJsonToAssert = MoviesController.getBatmanJson(appContext);

        String[] genres = {"Action", "Adventure", "Sci-Fi"};
        String[] writers = {
                "Chris Terrio",
                "David S. Goyer",
                "Bob Kane (Batman created by)",
                "Bill Finger (Batman created by)",
                "Jerry Siegel (Superman created by)",
                "Joe Shuster (Superman created by)"};
        String[] actors = {"Ben Affleck", "Henry Cavill", "Amy Adams", "Jesse Eisenberg"};
        String fullPlot = "The general public is concerned over having Superman on their planet " +
                "and letting the \"Dark Knight\" - Batman - pursue the streets of Gotham. While " +
                "this is happening, a power-phobic Batman tries to attack Superman.,Meanwhile " +
                "Superman tries to settle on a decision, and Lex Luthor, the criminal mastermind " +
                "and millionaire, tries to use his own advantages to fight the \"Man of Steel\".";

        mExpectedMovie = new Movie()
                .setId("tt2975590")
                .setTitle("Batman v Superman: Dawn of Justice")
                .setYear(2016)
                .setRated("PG-13")
                .setReleasedDate("25 Mar 2016")
                .setRuntime("151 min")
                .setGenres(Arrays.asList(genres))
                .setDirector("Zack Snyder")
                .setWriters(Arrays.asList(writers))
                .setActors(Arrays.asList(actors))
                .setPlot(fullPlot)
                .setLanguage("English")
                .setCountry("USA")
                .setAwards("3 wins & 14 nominations.")
                .setPosterUrl("https://images-na.ssl-images-amazon.com/images/M/MV5BYThjYzcyYzItNTVjNy00NDk0LTgwMWQtYjMwNmNlNWJhMzMyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg")
                .setMetaScore(44)
                .setRating(6.7)
                .setVotes(438291)
                .setType("movie");
        mController = new MoviesController();
    }

    @Test
    public void shouldReturnJsonStringObject() throws Exception {
        assertNotNull("json string must not be null", mJsonToAssert);
        assertTrue("json string must not be empty", !mJsonToAssert.isEmpty());
    }

    @Test
    public void shouldReturnValidJsonString() throws Exception {
        assertTrue("string must be a valid JSON format", JsonUtils.isJsonValid(mJsonToAssert));
    }

    @Test
    public void shouldNotReturnNullMovieFromValidJson() {
        Assert.assertNotNull("Movie must not be null if json string is valid", mController.getMovieFromJson(testJson));
    }

    @Test
    public void shouldReturnNullMovieFromInvalidJson() {
        assertNull("Movie must be null if json string is null", mController.getMovieFromJson(null));
        assertNull("Movie must be null if json string is empty", mController.getMovieFromJson(""));
        assertNull("Movie must be null if json string is invalid", mController.getMovieFromJson(testJson.substring(1)));
    }

    @Test
    public void shouldHaveCorrectId() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Id is incorrect", mExpectedMovie.getId(), movie.getId());
    }

    @Test
    public void shouldHaveCorrectTitle() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Title is incorrect", mExpectedMovie.getTitle(), movie.getTitle());
    }

    @Test
    public void shouldHaveCorrectYear() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Year is incorrect", mExpectedMovie.getYear(), movie.getYear());
    }

    @Test
    public void shouldHaveCorrectRated() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Rated is incorrect", mExpectedMovie.getRated(), movie.getRated());
    }

    @Test
    public void shouldHaveCorrectReleasedDate() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Released Date is incorrect", mExpectedMovie.getReleasedDate(), movie.getReleasedDate());
    }

    @Test
    public void shouldHaveCorrectRuntime() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Runtime is incorrect", mExpectedMovie.getRuntime(), movie.getRuntime());
    }

    @Test
    public void shouldHaveCorrectGenres() {
        Movie movie = mController.getMovieFromJson(testJson);
        Assert.assertNotNull("Movie must not be null", movie);

        List<String> expected = mExpectedMovie.getGenres();
        List<String> actual = movie.getGenres();

        Assert.assertNotNull("Genres must not be null", actual);
        Assert.assertTrue("Genres must not be empty", actual.size() > 0);
        Assert.assertEquals("Genre list number are not equal to the expected genres", expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals("Genre is incorrect", expected.get(i), actual.get(i));
        }
    }

    @Test
    public void shouldHaveCorrectDirector() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Director name is incorrect", mExpectedMovie.getDirector(), movie.getDirector());
    }

    @Test
    public void shouldHaveCorrectWriters() {
        Movie movie = mController.getMovieFromJson(testJson);
        Assert.assertNotNull("Movie must not be null", movie);

        List<String> expected = mExpectedMovie.getWriters();
        List<String> actual = movie.getWriters();

        Assert.assertNotNull("Writers must not be null", actual);
        Assert.assertTrue("Writers must not be empty", actual.size() > 0);
        Assert.assertEquals("No. of writers are not equal to the expected writer list", expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals("Writer is incorrect", expected.get(i), actual.get(i));
        }
    }

    @Test
    public void shouldHaveCorrectActors() {
        Movie movie = mController.getMovieFromJson(testJson);
        Assert.assertNotNull("Movie must not be null", movie);

        List<String> expected = mExpectedMovie.getActors();
        List<String> actual = movie.getActors();

        Assert.assertNotNull("Actors must not be null", actual);
        Assert.assertTrue("Actors must not be empty", actual.size() > 0);
        Assert.assertEquals("No. of actors are not equal to the expected actor list", expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals("Actor is incorrect", expected.get(i), actual.get(i));
        }
    }

    @Test
    public void shouldHaveCorrectPlot() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Full plot is incorrect", mExpectedMovie.getPlot(), movie.getPlot());
    }

    @Test
    public void shouldHaveCorrectLanguage() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Language is incorrect", mExpectedMovie.getLanguage(), movie.getLanguage());
    }

    @Test
    public void shouldHaveCorrectCountry() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Country is incorrect", mExpectedMovie.getCountry(), movie.getCountry());
    }

    @Test
    public void shouldHaveCorrectAwards() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Awards are incorrect", mExpectedMovie.getAwards(), movie.getAwards());
    }

    @Test
    public void shouldHaveCorrectPosterUrl() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Poster URL is incorrect", mExpectedMovie.getPosterUrl(), movie.getPosterUrl());
    }

    @Test
    public void shouldHaveCorrectMetaScore() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("MetaScore is incorrect", mExpectedMovie.getMetaScore(), movie.getMetaScore());
    }

    @Test
    public void shouldHaveCorrectRating() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Rating is incorrect", mExpectedMovie.getRating(), movie.getRating());
    }

    @Test
    public void shouldHaveCorrectVotes() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("No. of votes is incorrect", mExpectedMovie.getVotes(), movie.getVotes());
    }

    @Test
    public void shouldHaveCorrectType() {
        Movie movie = mController.getMovieFromJson(testJson);

        Assert.assertNotNull("Movie must not be null", movie);
        Assert.assertEquals("Type is incorrect", mExpectedMovie.getType(), movie.getType());
    }
}
