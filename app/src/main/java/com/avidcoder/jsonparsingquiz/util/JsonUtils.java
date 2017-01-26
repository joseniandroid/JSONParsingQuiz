package com.avidcoder.jsonparsingquiz.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Utility class to handle json string validation.
 */
public class JsonUtils {

    public static boolean isJsonValid(String jsonToTest) {
        try {
            new JSONObject(jsonToTest);
        } catch (JSONException e1) {
            try {
                new JSONArray(jsonToTest);
            } catch (JSONException e2) {
                return false;
            }
        }
        return true;
    }
}
