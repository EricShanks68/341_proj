package com.example.a341_proj.ui.login.ui.groups;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a341_proj.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class MessagingActivity extends AppCompatActivity {

    private static HashMap<Integer, ArrayList<Message>> messages = new HashMap<>();

    private MessageAdapter adapter;

    public static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);
        int groupNum = GroupsFragment.group_num;
        if(messages.get(groupNum) == null) {
            messages.put(groupNum, new ArrayList<Message>());
        }
        final ArrayList<Message> msgList = messages.get(groupNum);

        Button sendBtn = findViewById(R.id.button_send);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text = findViewById(R.id.message_input);
                msgList.add(new Message(text.getText().toString(), username));
                text.setText("");
            }
        });

        RecyclerView messageRecyclerView = findViewById(R.id.message_list);

        adapter = new MessageAdapter(this, msgList);
        messageRecyclerView.setAdapter(adapter);
        messageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }





}
