package com.example.a341_proj.ui.login.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.a341_proj.R;

import com.example.a341_proj.R;


public class HomeFragment extends Fragment {
    private static final String TITLE_TEXT = "titleText";
    private static final String SPIN_1 = "spin1text";
    private static final String SPIN_2 = "spin2text";
    private static final String DATE = "spin2text";

    private String EditTextTitle;
    private String EventTime;
    private String Date;

    //private HomeViewModel homeViewModel;

    public static HomeFragment newInstance(String text,String text2, String text3, String text4  ){
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE_TEXT, text);
        bundle.putString(SPIN_1, text2);
        bundle.putString(SPIN_2, text3);
        bundle.putString(DATE, text4);
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        TextView eventTitle1 = (TextView) root.findViewById(R.id.event1Title);
        TextView eventTime = (TextView) root.findViewById(R.id.event1Time);
        TextView date = (TextView) root.findViewById(R.id.event1Desc);
       if (getArguments() != null){
           EditTextTitle = getArguments().getString(TITLE_TEXT);
           EventTime = getArguments().getString(SPIN_1 + "-" + SPIN_2);
           Date = getArguments().getString(DATE);
       }
       
        eventTitle1.setText(EditTextTitle);
       eventTime.setText(EventTime);
        date.setText(Date);
        return root;
//        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}