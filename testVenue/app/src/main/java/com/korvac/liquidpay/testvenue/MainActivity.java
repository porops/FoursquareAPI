package com.korvac.liquidpay.testvenue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.foursquare.android.nativeoauth.FoursquareOAuth;
import com.foursquare.android.nativeoauth.model.AccessTokenResponse;
import com.foursquare.android.nativeoauth.model.AuthCodeResponse;
import com.korvac.liquidpay.testvenue.model.FoursquareResponse;
import com.korvac.liquidpay.testvenue.model.Item;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static String CLIENT_ID = "KMLVAEY1YHFN5N52HJPUB2QSGGHJZUKOIBX5LNHSBQZE1K5K";
    public static String CLIENT_SECRET = "HEIAWT1QXBVTXZ5PETQKYQOBT3O1VSCNDBI2U3FOHQH0S5MD";
    public static String AUTH_CODE = "";
    public static String ACCESS_TOKEN = "";
    private static int REQUEST_CODE_FSQ_CONNECT = 0x99;
    private static int REQUEST_CODE_FSQ_TOKEN_EXCHANGE = 0x100;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

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
            Log.e("isPlayStoreIntent", "start");
            startActivityForResult(intent, REQUEST_CODE_FSQ_CONNECT);
        }
    }

    private void startToken() {
        Intent intent = FoursquareOAuth.getTokenExchangeIntent(this, CLIENT_ID, CLIENT_SECRET, AUTH_CODE);
        startActivityForResult(intent, REQUEST_CODE_FSQ_TOKEN_EXCHANGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_FSQ_CONNECT) {
            AuthCodeResponse codeResponse = FoursquareOAuth.getAuthCodeFromResult(resultCode, data);
            AUTH_CODE = codeResponse.getCode();
            Log.e("codeResponse", "AUTH_CODE: " + AUTH_CODE);
            if (!TextUtils.isEmpty(AUTH_CODE) && codeResponse.getException() == null) {
                startToken();
            }
        }
        if (requestCode == REQUEST_CODE_FSQ_TOKEN_EXCHANGE) {
            AccessTokenResponse tokenResponse = FoursquareOAuth.getTokenFromResult(resultCode, data);
            if (tokenResponse.getException() == null) {
                ACCESS_TOKEN = tokenResponse.getAccessToken();
                Log.e("codeResponse", "ACCESS_TOKEN: " + ACCESS_TOKEN);
            }
        }
    }

    public void getNearby(View view) {

        API api = RetrofitFactory.getInstance().create(API.class);

        Observable<FoursquareResponse> call = api.getVenues("1.299807,103.789155", ACCESS_TOKEN);

        call.subscribeOn(Schedulers.io()).timeout(20, TimeUnit.SECONDS);

        call.subscribe(new Subscriber<FoursquareResponse>() {
            @Override
            public void onCompleted() {
                Log.e("onCompleted", "message");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("onError", "message:" + e.toString());
            }

            @Override
            public void onNext(FoursquareResponse foursquareResponse) {
                Log.e("onNext", "message");
                Log.e("test", "" + foursquareResponse.getResponse().toString());
            }
        });

    }

    private void handleResponse(List<Item> items) {

        if (items != null && items.size() > 0) {
            Adapter adapter = new Adapter(getApplicationContext(), items);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(adapter);
        }
    }
}
