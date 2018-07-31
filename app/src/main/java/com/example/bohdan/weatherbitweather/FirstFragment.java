package com.example.bohdan.weatherbitweather;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bohdan.weatherbitweather.databinding.FragmentOneBinding;

import java.io.Serializable;

public class FirstFragment extends Fragment implements Serializable {

    public Model model;
    public String s = "uzhorod";
    FragmentOneBinding fragmentOneBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentOneBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_one,container,false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        fragmentOneBinding.gridListView.setLayoutManager(layoutManager);
        fragmentOneBinding.gridListView.addItemDecoration(new DividerItemDecoration
                (container.getContext(), DividerItemDecoration.VERTICAL));

        MainActivity activityHome = (MainActivity) container.getContext();
        CallbackClass callbacks = new CallbackClass();
        callbacks.registerCallBack(activityHome);



        try {
            model = callbacks.loadObject(s);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fragmentOneBinding.setModelFor(model);


        return fragmentOneBinding.getRoot();



    }





}
