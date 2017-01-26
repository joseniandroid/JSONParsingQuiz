package com.avidcoder.jsonparsingquiz.models;

import android.text.TextUtils;

import java.util.List;

public class Movie {

    private String mId;
    private String mTitle;
    private int mYear;
    private String mRated;
    private String mReleasedDate;
    private String mRuntime;
    private List<String> mGenres;
    private String mDirector;
    private List<String> mWriters;
    private List<String> mActors;
    private String mPlot;
    private String mLanguage;
    private String mCountry;
    private String mAwards;
    private String mPosterUrl;
    private int mMetaScore;
    private double mRating;
    private long mVotes;
    private String mType;

    public String getId() {
        return mId;
    }

    public Movie setId(String id) {
        mId = id;
        return this;
    }

    public String getTitle() {
        return mTitle;
    }

    public Movie setTitle(String title) {
        mTitle = title;
        return this;
    }

    public int getYear() {
        return mYear;
    }

    public Movie setYear(int year) {
        mYear = year;
        return this;
    }

    public String getRated() {
        return mRated;
    }

    public Movie setRated(String rated) {
        mRated = rated;
        return this;
    }

    public String getReleasedDate() {
        return mReleasedDate;
    }

    public Movie setReleasedDate(String releasedDate) {
        mReleasedDate = releasedDate;
        return this;
    }

    public String getRuntime() {
        return mRuntime;
    }

    public Movie setRuntime(String runtime) {
        mRuntime = runtime;
        return this;
    }

    public List<String> getGenres() {
        return mGenres;
    }

    public Movie setGenres(List<String> genres) {
        mGenres = genres;
        return this;
    }

    public String getDirector() {
        return mDirector;
    }

    public Movie setDirector(String director) {
        mDirector = director;
        return this;
    }

    public List<String> getWriters() {
        return mWriters;
    }

    public Movie setWriters(List<String> writers) {
        mWriters = writers;
        return this;
    }

    public List<String> getActors() {
        return mActors;
    }

    public Movie setActors(List<String> actors) {
        mActors = actors;
        return this;
    }

    public String getPlot() {
        return mPlot;
    }

    public Movie setPlot(String plot) {
        mPlot = plot;
        return this;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public Movie setLanguage(String language) {
        mLanguage = language;
        return this;
    }

    public String getCountry() {
        return mCountry;
    }

    public Movie setCountry(String country) {
        mCountry = country;
        return this;
    }

    public String getAwards() {
        return mAwards;
    }

    public Movie setAwards(String awards) {
        mAwards = awards;
        return this;
    }

    public String getPosterUrl() {
        return mPosterUrl;
    }

    public Movie setPosterUrl(String posterUrl) {
        mPosterUrl = posterUrl;
        return this;
    }

    public int getMetaScore() {
        return mMetaScore;
    }

    public Movie setMetaScore(int metaScore) {
        mMetaScore = metaScore;
        return this;
    }

    public double getRating() {
        return mRating;
    }

    public Movie setRating(double rating) {
        mRating = rating;
        return this;
    }

    public long getVotes() {
        return mVotes;
    }

    public Movie setVotes(long votes) {
        mVotes = votes;
        return this;
    }

    public String getType() {
        return mType;
    }

    public Movie setType(String type) {
        mType = type;
        return this;
    }

    /*
        NOTE: The implementation I have in this overridden toString() method is just a helper in
        displaying if all the properties were properly set as it will be shown to the UI. This is
        not advised to be followed and used in production codes.
     */
    @Override
    public String toString() {
        return "IMDB ID: " + mId + "\n" +
                "Title: " + mTitle + "\n" +
                "Year: " + mYear + "\n" +
                "Rated: " + mRated + "\n" +
                "Type: " + mType + "\n" +
                "Released: " + mReleasedDate + "\n" +
                "Runtime: " + mRuntime + "\n" +
                "Director: " + mDirector + "\n" +
                "Genres: " + TextUtils.join(",", mGenres) + "\n" +
                "Writers: " + TextUtils.join(",", mWriters) + "\n" +
                "Actors: " + TextUtils.join(",", mActors) + "\n" +
                "Plot: " + mPlot + "\n" +
                "Language: " + mLanguage + "\n" +
                "Country: " + mCountry + "\n" +
                "Awards: " + mAwards + "\n" +
                "Poster URL: " + mPosterUrl + "\n" +
                "MetaScore: " + mMetaScore + "\n" +
                "Rating: " + mRating + "\n" +
                "Votes: " + mVotes + "\n";
    }
}
