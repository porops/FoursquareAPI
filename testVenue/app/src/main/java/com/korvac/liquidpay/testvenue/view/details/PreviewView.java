package com.korvac.liquidpay.testvenue.view.details;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.korvac.liquidpay.testvenue.R;
import com.korvac.liquidpay.testvenue.model.PrefSuf;
import com.korvac.liquidpay.testvenue.model.Tip;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by aldi on 8/30/2017.
 */

public class PreviewView extends LinearLayout {
    @Bind(R.id.image_view_user_image)
    ImageView imageViewUserImage;
    @Bind(R.id.text_view_user_name)
    TextView textViewUserName;
    @Bind(R.id.text_view_review_date)
    TextView textViewReviewDate;
    @Bind(R.id.text_view_review_message)
    TextView textViewReviewMessage;

    private Tip tip;

    public PreviewView(Context context) {
        super(context);
        initView(context);
    }

    public PreviewView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PreviewView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View root = LayoutInflater.from(context).inflate(R.layout.layout_review, this, true);
        ButterKnife.bind(this, root);
    }

    public void setTip(Tip tip) {
        this.tip = tip;
        updateView();
    }

    private void updateView() {
        PrefSuf prefSuf = tip.getUser().getPhoto();
        String userId = tip.getUser().getId();
        String urlImage = prefSuf.getPrefix() + userId + prefSuf.getSuffix();
        String userName = tip.getUser().getFirstName() + " " + tip.getUser().getLastName();
        String userMessage = tip.getText();

        Log.e("UrlImage", " : " + urlImage);

        Picasso.with(getContext()).load(urlImage).resize(48, 48).into(imageViewUserImage);

        textViewUserName.setText(userName);
        textViewReviewMessage.setText(Html.fromHtml(userMessage));
        textViewReviewDate.setText(new SimpleDateFormat("yyyy, dd MMM").format(tip.getCreatedAt()));
    }
}
