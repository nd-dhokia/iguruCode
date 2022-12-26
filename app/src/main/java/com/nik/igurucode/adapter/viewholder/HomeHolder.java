package com.nik.igurucode.adapter.viewholder;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.nik.igurucode.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imgApp)
    public ImageView imgApp;
    @BindView(R.id.txtTimeStamp)
    public TextView txtTimeStamp;
    @BindView(R.id.imgProfile)
    public ImageView imgProfile;
    @BindView(R.id.txtUserName)
    public TextView txtUserName;
    @BindView(R.id.linearItem)
    public RelativeLayout linearItem;
    @BindView(R.id.txtTitle)
    public TextView txtTitle;
    @BindView(R.id.txtDiscription)
    public TextView txtDiscription;
    @BindView(R.id.imgLike)
    public ImageView imgLike;
    @BindView(R.id.txtLike)
    public TextView txtLike;
    @BindView(R.id.imgComment)
    public ImageView imgComment;
    @BindView(R.id.txtComment)
    public TextView txtComment;
    @BindView(R.id.imgShare)
    public ImageView imgShare;
    @BindView(R.id.txtShare)
    public TextView txtShare;
    @BindView(R.id.cardViewRoot)
    public CardView cardViewRoot;

    public HomeHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
