package com.korvac.liquidpay.testvenue;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

/**
 * Created by aldi on 8/30/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public static String BASE_URL = "https://api.foursquare.com/";
    public static String CLIENT_ID = "KMLVAEY1YHFN5N52HJPUB2QSGGHJZUKOIBX5LNHSBQZE1K5K";
    public static String CLIENT_SECRET = "HEIAWT1QXBVTXZ5PETQKYQOBT3O1VSCNDBI2U3FOHQH0S5MD";
    public static String VERSIONING_MODE = "foursquare"; //frousquare
    public static String VERSIONING_V = ""; //date yyyyMMdd

    public static SharedPreferences PREFERENCES;
    private static String KEY_AUTH_CODE = "foursquare_auth_code";
    private static String KEY_ACCESS_TOKEN = "foursquare_access_token";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PREFERENCES = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void setFoursquareAuthCode(String authCode) {

        SharedPreferences.Editor edit = PREFERENCES.edit();
        edit.putString(KEY_AUTH_CODE, authCode);
        edit.commit();
    }

    public String getFoursquareAuthCode() {
        String authCode = PREFERENCES.getString(KEY_AUTH_CODE, "");
        return authCode;
    }

    public void setFoursquareAccessToken(String accessToken) {
        SharedPreferences.Editor edit = PREFERENCES.edit();
        edit.putString(KEY_ACCESS_TOKEN, accessToken);
        edit.commit();
    }

    public String getFoursquareAccessToken() {
        String accessToken = PREFERENCES.getString(KEY_ACCESS_TOKEN, "");
        return accessToken;
    }
}
