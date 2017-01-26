package com.avidcoder.jsonparsingquiz.util;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Helper class used to handle string manipulations.
 */
public class StringUtils {

    /**
     * Converts a comma separated value into a list of String.
     */
    public static List<String> toList(String csv) {
        if (TextUtils.isEmpty(csv)) {
            return null;
        }
        List<String> data = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(csv, ",", false);
        while (st.hasMoreTokens()) {
            data.add(st.nextToken().trim());
        }
        return data;
    }
}
