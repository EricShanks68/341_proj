package com.example.a341_proj.ui.login.ui.home;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a341_proj.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private Context con;
    private List<Event> events;

    public EventAdapter(Context context, List<Event> eventList) {
        con = context;
        events = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event e = events.get(position);
        holder.bind(e);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        TextView title, time, desc;

        EventViewHolder(View v) {
            super(v);

            title = v.findViewById(R.id.event1Title);
            time = v.findViewById(R.id.event1Time);
            desc = v.findViewById(R.id.event1Desc);
        }

        void bind(Event e) {
            title.setText(e.getTitle());
            desc.setText(e.getDesc());
            time.setText(e.getTime());
        }
    }
}

