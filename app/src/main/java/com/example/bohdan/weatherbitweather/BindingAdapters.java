package com.example.bohdan.weatherbitweather;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BindingAdapters {



    @BindingAdapter("bind:items")
    public static void listBindGridview (RecyclerView view, List<Datum> forecastday){
        Adapternew adapterNew = new Adapternew(forecastday);
        view.setAdapter(adapterNew);
    }

}
