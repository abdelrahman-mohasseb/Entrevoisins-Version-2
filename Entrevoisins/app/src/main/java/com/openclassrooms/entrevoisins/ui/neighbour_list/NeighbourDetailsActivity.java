package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NeighbourDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_ID =
            "com.openclassrooms.entrevoisins.ui.neighbour_list.EXTRA_ID";

    @BindView(R.id.item_list_avatar)
    ImageView mNeighbourImage;
    @BindView(R.id.item_list_name)
    TextView mNeighbourName;
    @BindView(R.id.item_list_name2)
    TextView mNeighbourName2;
    @BindView(R.id.item_list_address)
    TextView mNeighbourAddress;
    @BindView(R.id.item_list_phonenumber)
    TextView mNeighbourPhonenumber;
    @BindView(R.id.item_list_aboutme)
    TextView mNeighbourAboutme;
    @BindView(R.id.neighbour_contact)
    TextView mNeighbourContact;
    @BindView(R.id.addToFavorit)
    FloatingActionButton addToFavoritButton;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    private NeighbourApiService mApiService;
    private Neighbour mNeighbour;
    private Long neighbourClicked_ID;
    private Boolean clicked = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_neighbour_details);
        super.onCreate(savedInstanceState);
        mApiService = DI.getNeighbourApiService();
        ButterKnife.bind(this);
        

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)) {
            neighbourClicked_ID = intent.getLongExtra(EXTRA_ID, -1);
        }
        mNeighbour = mApiService.getNeighbourById(neighbourClicked_ID);
        if(mNeighbour != null){

            Glide.with(mNeighbourImage.getContext()).load(mNeighbour.getAvatarUrl()).into(mNeighbourImage);
            mNeighbourName.setText(mNeighbour.getName());
            mNeighbourName2.setText(mNeighbour.getName());

            if(mNeighbour.getisFavorit()){
                addToFavoritButton.setImageResource(R.drawable.ic_star_white_24dp);
                clicked = true;
            }
            mNeighbourAddress.setText(mNeighbour.getAddress());
            mNeighbourPhonenumber.setText(mNeighbour.getPhoneNumber());
            mNeighbourAboutme.setText(mNeighbour.getAboutMe());
            mNeighbourContact.setText("\"www.facebook.fr/"+mNeighbour.getName());
        }

    }
    @OnClick(R.id.addToFavorit)
    void addToFavorit() {
        if(!clicked) {
            addToFavoritButton.setImageResource(R.drawable.ic_star_white_24dp);
            mApiService.addToFavorits(mNeighbour);
            mNeighbour.setFavorit(true);
            clicked = true;
        }
        else {
         addToFavoritButton.setImageResource(R.drawable.ic_star_border_white_24dp);
         mApiService.deleteFavorit(mNeighbour);
         mNeighbour.setFavorit(false);
         clicked=false;
        }
    }


}