package com.korvac.liquidpay.testvenue.view.main;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.korvac.liquidpay.testvenue.R;
import com.korvac.liquidpay.testvenue.model.Item;
import com.korvac.liquidpay.testvenue.model.PrefSuf;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by aldi on 8/29/2017.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Item> itemList;
    private Callback callback;

    public interface Callback{
        void onPlaceClick(Item item);
    }

    public Adapter(Context context, List<Item> itemList, Callback callback) {
        this.context = context;
        this.itemList = itemList;
        this.callback = callback;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(context).inflate(R.layout.item_adapter, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Item item = getItem(position);

        if (item != null) {
            ViewHolder vh = (ViewHolder) holder;

            vh.textViewName.setText(item.getVenue().getName());
            vh.textViewLocation.setText(item.getVenue().getLocation().getAddress());

            int ratingColor = Color.parseColor("#"+item.getVenue().getRatingColor());
            int iconColor = Color.LTGRAY;
            vh.textViewRating.setTextColor(ratingColor);
            DrawableCompat.setTint(vh.textViewImageViewRatingColor.getDrawable(), ratingColor);
            vh.textViewRating.setText(String.valueOf(item.getVenue().getRating()));
            vh.textViewDistance.setText(String.valueOf(item.getVenue().getLocation().getDistance()) + "km");

            String urlImage = "";

            if (item.getVenue().getCategories().get(0) != null) {
                PrefSuf prefSuf = item.getVenue().getCategories().get(0).getIcon();
                urlImage = prefSuf.getPrefix() + "88" + prefSuf.getSuffix();
            }
            if (!TextUtils.isEmpty(urlImage)) {
                Picasso.with(context).load(urlImage).into(vh.imageViewIcon);
            }

            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) {
                        callback.onPlaceClick(item);
                    }
                }
            });

        }

    }

    public Item getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
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

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
