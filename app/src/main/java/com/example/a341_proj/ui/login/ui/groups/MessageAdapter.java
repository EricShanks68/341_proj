package com.example.a341_proj.ui.login.ui.groups;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a341_proj.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MsgViewHolder> {

    private Context con;
    private List<Message> messages;

    public MessageAdapter(Context context, List<Message> msgList) {
        con = context;
        messages = msgList;
    }

    @NonNull
    @Override
    public MsgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message, parent, false);
        return new MsgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MsgViewHolder holder, int position) {
        Message msg = messages.get(position);
        holder.bind(msg);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MsgViewHolder extends RecyclerView.ViewHolder {
        TextView text, time, user;

        MsgViewHolder(View v) {
            super(v);

            text = v.findViewById(R.id.msg_text);
            time = v.findViewById(R.id.msg_time);
            user = v.findViewById(R.id.msg_user);
        }

        void bind(Message m) {
            text.setText(m.getMessageText());
            user.setText(m.getMessageUser());
            time.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)", m.getMessageTime()));
        }
    }
}
