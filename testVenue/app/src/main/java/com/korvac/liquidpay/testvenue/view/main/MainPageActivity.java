package com.korvac.liquidpay.testvenue.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.korvac.liquidpay.testvenue.BaseActivity;
import com.korvac.liquidpay.testvenue.view.details.DetailItemActivity;
import com.korvac.liquidpay.testvenue.R;
import com.korvac.liquidpay.testvenue.api.Foursquare;
import com.korvac.liquidpay.testvenue.model.FoursquareResponse;
import com.korvac.liquidpay.testvenue.model.Item;
import com.korvac.liquidpay.testvenue.utils.NetworkUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aldi on 8/30/2017.
 */

public class MainPageActivity extends BaseActivity {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ButterKnife.bind(this);


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public void getNearby(View view) {

        VERSIONING_V = new SimpleDateFormat("yyyyMMdd").format(new Date());

        Foursquare api = NetworkUtils.getRetrofit(BASE_URL).create(Foursquare.class);

        Call<FoursquareResponse> call = api.getVenues("1.299807,103.789155", getFoursquareAccessToken(), VERSIONING_MODE, VERSIONING_V);

        call.enqueue(new Callback<FoursquareResponse>() {
            @Override
            public void onResponse(Call<FoursquareResponse> call, Response<FoursquareResponse> response) {
                if (response.message().equalsIgnoreCase("OK")) {
                    handleResponse(response.body().getResponse().getGroups().get(0).getItems());
                }
            }

            @Override
            public void onFailure(Call<FoursquareResponse> call, Throwable t) {
            }
        });


    }

    private void handleResponse(List<Item> items) {

        if (items != null && items.size() > 0) {
            Adapter adapter = new Adapter(getApplicationContext(), items, new Adapter.Callback() {
                @Override
                public void onPlaceClick(Item item) {
                    startItemDetail(item);
                }
            });

            recyclerView.setAdapter(adapter);
        }
    }

    public void startItemDetail(@NonNull Item item) {

        Intent intent = new Intent(this, DetailItemActivity.class);
        intent.putExtra("ITEM", item);

        startActivity(intent);
    }
}
