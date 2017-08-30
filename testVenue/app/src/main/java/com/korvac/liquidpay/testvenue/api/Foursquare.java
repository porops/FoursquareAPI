package com.korvac.liquidpay.testvenue.api;

import com.korvac.liquidpay.testvenue.model.FoursquareResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by aldi on 8/29/2017.
 */

public interface Foursquare {

    @GET("v2/venues/explore?")
    Call<FoursquareResponse> getVenues(@Query("ll") String latlng, @Query("oauth_token") String token,
                                       @Query("m") String versioningM, @Query("v") String versioningV);
}
