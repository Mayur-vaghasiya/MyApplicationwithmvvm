package com.example.myapplicationwithmvvmdignizent.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class EventModel implements Serializable {
    @SerializedName("data")
    @Expose
    private ArrayList<Data> data = null;
    private final static long serialVersionUID = -8256540722513043083L;
    public ArrayList<Data> getData() {
        return data;
    }
    public void setData(ArrayList<Data> data) {
        this.data = data;
    }
    public class Data implements Serializable
    {
        @SerializedName("event_id")
        @Expose
        private Integer eventId;
        @SerializedName("event_title")
        @Expose
        private String eventTitle;
        @SerializedName("event_time")
        @Expose
        private Integer eventTime;
        @SerializedName("event_image")
        @Expose
        private String eventImage;
        @SerializedName("event_descriptio")
        @Expose
        private String eventDescriptio;
        @SerializedName("event_date")
        @Expose
        private String eventDate;
        private final static long serialVersionUID = -3826541459441441267L;

        public Integer getEventId() {
            return eventId;
        }

        public void setEventId(Integer eventId) {
            this.eventId = eventId;
        }

        public String getEventTitle() {
            return eventTitle;
        }

        public void setEventTitle(String eventTitle) {
            this.eventTitle = eventTitle;
        }

        public Integer getEventTime() {
            return eventTime;
        }

        public void setEventTime(Integer eventTime) {
            this.eventTime = eventTime;
        }

        public String getEventImage() {
            return eventImage;
        }

        public void setEventImage(String eventImage) {
            this.eventImage = eventImage;
        }

        public String getEventDescriptio() {
            return eventDescriptio;
        }

        public void setEventDescriptio(String eventDescriptio) {
            this.eventDescriptio = eventDescriptio;
        }

        public String getEventDate() {
            return eventDate;
        }

        public void setEventDate(String eventDate) {
            this.eventDate = eventDate;
        }
    }
}

