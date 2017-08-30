package com.korvac.liquidpay.testvenue;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.foursquare.android.nativeoauth.FoursquareOAuth;
import com.foursquare.android.nativeoauth.model.AccessTokenResponse;
import com.foursquare.android.nativeoauth.model.AuthCodeResponse;
import com.korvac.liquidpay.testvenue.view.main.MainPageActivity;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private static int REQUEST_CODE_FSQ_CONNECT = 0x99;
    private static int REQUEST_CODE_FSQ_TOKEN_EXCHANGE = 0x100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    public void authFour(View view) {
        Intent intent = FoursquareOAuth.getConnectIntent(getApplicationContext(), CLIENT_ID);
        if (FoursquareOAuth.isPlayStoreIntent(intent)) {
            Log.e("isPlayStoreIntent", "start");
            startActivity(intent);
        } else {
            Log.e("authFour", "start");
            startActivityForResult(intent, REQUEST_CODE_FSQ_CONNECT);
        }
    }

    private void startToken() {
        Intent intent = FoursquareOAuth.getTokenExchangeIntent(this, CLIENT_ID, CLIENT_SECRET, getFoursquareAuthCode());
        startActivityForResult(intent, REQUEST_CODE_FSQ_TOKEN_EXCHANGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_FSQ_CONNECT) {
            AuthCodeResponse codeResponse = FoursquareOAuth.getAuthCodeFromResult(resultCode, data);
            setFoursquareAuthCode(codeResponse.getCode());
            if (!TextUtils.isEmpty(codeResponse.getCode()) && codeResponse.getException() == null) {
                startToken();
            }
        }
        if (requestCode == REQUEST_CODE_FSQ_TOKEN_EXCHANGE) {
            AccessTokenResponse tokenResponse = FoursquareOAuth.getTokenFromResult(resultCode, data);
            if (tokenResponse.getException() == null) {
                setFoursquareAccessToken(tokenResponse.getAccessToken());
                startMainPage();
            }
        }
    }

    private void startMainPage() {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
    }
}
