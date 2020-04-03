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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a341_proj.R;

import com.example.a341_proj.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    public static ArrayList<Event> events = new ArrayList<>();
    private EventAdapter eventAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView homeEvents = root.findViewById(R.id.eventList);
        eventAdapter = new EventAdapter(this.getContext(), events);
        homeEvents.setAdapter(eventAdapter);
        homeEvents.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return root;
//        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}