package com.korvac.liquidpay.testvenue.utils;

/**
 * Created by aldi on 8/30/2017.
 */

public class CommonUtils {
    private static String GOOGLE_STATIC_MAP_URL = "http://maps.google.com/maps/api/staticmap?";

    public static String getSnippetMap(String lat, String lng, String markerPlace) {

        String snippetUrl = GOOGLE_STATIC_MAP_URL + "center=" + lat + "," + lng + "&zoom=18&size=800x400&sensor=false";
        return snippetUrl;
    }

}
