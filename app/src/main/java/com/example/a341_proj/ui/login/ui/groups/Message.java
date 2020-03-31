package com.example.a341_proj.ui.login.ui.groups;

import java.util.Date;

public class Message {

    private String msgText;
    private String msgUser;
    private long msgTime;

    public Message(String text, String name) {
        this.msgText = text;
        this.msgUser = name;

        // Initialize to current time
        msgTime = new Date().getTime();
    }

    public String getMessageText() {
        return msgText;
    }

    public void setMessageText(String text) {
        this.msgText = text;
    }

    public String getMessageUser() {
        return msgUser;
    }

    public void setMessageUser(String name) {
        this.msgUser = name;
    }

    public long getMessageTime() {
        return msgTime;
    }

    public void setMessageTime(long time) {
        this.msgTime = time;
    }
}
