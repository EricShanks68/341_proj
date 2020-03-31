package com.example.a341_proj.ui.login.ui.groups;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.a341_proj.R;
import com.example.a341_proj.ui.login.LoginActivity;


public class GroupsFragment extends Fragment {

    private GroupsViewModel groupsViewModel;

    public static int group_num;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        groupsViewModel =
                ViewModelProviders.of(this).get(GroupsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_groups, container, false);
        final Button btn = root.findViewById(R.id.groupButton1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                group_num = 1;
                Intent intent = new Intent(getActivity(),  MessagingActivity.class);
                startActivity(intent);
            }
        });

        final Button btn2 = root.findViewById(R.id.groupButton2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                group_num = 2;
                Intent intent = new Intent(getActivity(),  MessagingActivity.class);
                startActivity(intent);
            }
        });



        return root;
    }
}