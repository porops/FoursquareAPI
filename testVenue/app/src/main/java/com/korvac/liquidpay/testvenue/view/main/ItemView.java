package com.korvac.liquidpay.testvenue.view.main;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.korvac.liquidpay.testvenue.R;
import com.korvac.liquidpay.testvenue.model.Item;
import com.korvac.liquidpay.testvenue.model.PrefSuf;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by aldi on 8/30/2017.
 */

public class ItemView extends LinearLayout {
    @Bind(R.id.image_view_icon)
    ImageView imageViewIcon;
    @Bind(R.id.text_view_name)
    TextView textViewName;
    @Bind(R.id.text_view_location)
    TextView textViewLocation;
    @Bind(R.id.text_view_image_view_rating_color)
    ImageView textViewImageViewRatingColor;
    @Bind(R.id.text_view_rating)
    TextView textViewRating;
    @Bind(R.id.text_view_distance)
    TextView textViewDistance;

    private Item item;

    public ItemView(Context context) {
        super(context);
        initView(context);
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_adapter, this, true);
        ButterKnife.bind(this, root);
    }

    public void setItem(@NonNull Item item) {
        this.item = item;
        updateView();
    }

    private void updateView() {

        textViewName.setText(item.getVenue().getName());
        textViewLocation.setText(item.getVenue().getLocation().getAddress());

        int ratingColor = Color.parseColor("#"+item.getVenue().getRatingColor());
        int iconColor = Color.LTGRAY;
        textViewRating.setTextColor(ratingColor);
        DrawableCompat.setTint(textViewImageViewRatingColor.getDrawable(), ratingColor);
        textViewRating.setText(String.valueOf(item.getVenue().getRating()));
        textViewDistance.setText(String.valueOf(item.getVenue().getLocation().getDistance()) + "km");

        String urlImage = "";

        if (item.getVenue().getCategories().get(0) != null) {
            PrefSuf prefSuf = item.getVenue().getCategories().get(0).getIcon();
            urlImage = prefSuf.getPrefix() + "88" + prefSuf.getSuffix();
        }
        if (!TextUtils.isEmpty(urlImage)) {
            Picasso.with(getContext()).load(urlImage).into(imageViewIcon);
        }
    }
}
