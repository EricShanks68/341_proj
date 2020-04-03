package com.example.a341_proj.ui.login.ui.home;

import java.util.Date;

public class Event {

    private String eventTitle;
    private String eventDesc;
    private String eventTime;

    public Event(String title, String desc, String time) {
        this.eventTitle = title;
        this.eventDesc = desc;
        this.eventTime = time;
    }

    public String getTitle() {
        return eventTitle;
    }

    public void setEventTitle(String text) {
        this.eventTitle = text;
    }

    public String getDesc() {
        return eventDesc;
    }

    public void setEventDesc(String text) {
        this.eventDesc = text;
    }

    public String getTime() {
        return eventTime;
    }

    public void setEventTime(String text) {
        this.eventTime = text;
    }
}
