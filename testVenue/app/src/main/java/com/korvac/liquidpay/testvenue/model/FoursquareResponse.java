package com.korvac.liquidpay.testvenue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aldi on 8/29/2017.
 */

public class FoursquareResponse {

    @SerializedName("response")
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
