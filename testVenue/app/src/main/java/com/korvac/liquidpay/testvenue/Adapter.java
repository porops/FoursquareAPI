package com.korvac.liquidpay.testvenue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.korvac.liquidpay.testvenue.model.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aldi on 8/29/2017.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Item> itemList;

    public Adapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(context).inflate(R.layout.item_adapter, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Item item = getItem(position);

        if (item != null) {
            ViewHolder vh = (ViewHolder) holder;

            vh.textViewName.setText(item.getVenue().getName());
            vh.textViewLocation.setText(item.getVenue().getLocation().getAddress());

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
        @BindView(R.id.text_view_name)
        TextView textViewName;
        @BindView(R.id.text_view_location)
        TextView textViewLocation;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
