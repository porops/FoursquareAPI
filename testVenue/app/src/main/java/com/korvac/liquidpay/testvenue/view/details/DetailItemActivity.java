package com.korvac.liquidpay.testvenue.view.details;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.korvac.liquidpay.testvenue.BaseActivity;
import com.korvac.liquidpay.testvenue.R;
import com.korvac.liquidpay.testvenue.model.Item;
import com.korvac.liquidpay.testvenue.model.Tip;
import com.korvac.liquidpay.testvenue.utils.CommonUtils;
import com.korvac.liquidpay.testvenue.view.main.ItemView;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailItemActivity extends BaseActivity {

    @Bind(R.id.item_view)
    ItemView itemView;

    @Bind(R.id.image_view_map_snippet)
    ImageView imageViewMapSnippet;

    @Bind(R.id.linear_layout_preview)
    LinearLayout linearLayoutPreview;
    @Bind(R.id.text_view_preview)
    TextView textViewPreview;

    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        ButterKnife.bind(this);

        if (getIntent().hasExtra("ITEM")) {
            item = getIntent().getParcelableExtra("ITEM");
            updateView();

        }
    }

    private void updateView() {
        if (item != null) {
            itemView.setItem(item);

            String lat = String.valueOf(item.getVenue().getLocation().getLat());
            String lng = String.valueOf(item.getVenue().getLocation().getLng());
            String markerPlace = item.getVenue().getLocation().getAddress();

            String snippetMap = CommonUtils.getSnippetMap(lat, lng, "");

            Picasso.with(getApplicationContext()).load(snippetMap).into(imageViewMapSnippet);

            if (item.getTips().size() > 0) {
                textViewPreview.setVisibility(View.GONE);
                for (Tip tip : item.getTips()) {
                    PreviewView previewView = new PreviewView(getApplicationContext());
                    previewView.setTip(tip);
                    linearLayoutPreview.addView(previewView);
                }
            }
        }
    }


}
