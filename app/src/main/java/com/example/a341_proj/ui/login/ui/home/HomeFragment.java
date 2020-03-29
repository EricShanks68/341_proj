package com.example.a341_proj.ui.login.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a341_proj.R;

import com.example.a341_proj.R;
import com.example.a341_proj.ui.login.MainActivity;
import com.example.a341_proj.ui.login.ui.MyAdapter;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    //event recycler array
    ArrayList<String> title = new ArrayList<String>();
   // String s1[], s2[];
    //int images[] = {};
    // recycler
    RecyclerView recyclerView;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //RecyclerView arrays
        title.add("Event 1 Title");
        title.add("Event 2 Title");
        title.add("Event 3 Title");
        title.add("Event 4 Title");
        title.add("Event 5 Title");


//        s1 = getResources().getStringArray(R.array.prog_lang);
//        s2 = getResources().getStringArray(R.array.des);

        recyclerView = (RecyclerView) view.findViewById(R.id.RecycleEvents);

        //myadapter



        MyAdapter myAdapter = new MyAdapter(getActivity(), title);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return view;
    }

}