package com.avidcoder.jsonparsingquiz.controllers;

import android.content.Context;

import com.avidcoder.jsonparsingquiz.models.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MoviesController {

    public Movie getMovieFromJson(String jsonString) {
        // TODO: Implement me
        return null;
    }

    public static String getBatmanJson(Context context) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader br = null;
        String s;

        try {
            // Locates batman.json file from assets folder
            inputStream = context.getAssets().open("batman.json");
            br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
