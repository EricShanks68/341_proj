package com.example.a341_proj.ui.login.ui.home;

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

    TextView eventTitle1;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
       // View root = inflater.inflate(R.layout.fragment_home, container, false);
      //  String EditTextTitle = getArguments().getString("keyEdit");
//        eventTitle1 = (TextView) getView().findViewById(R.id.event1Title);
//        eventTitle1.setText(EditTextTitle);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}