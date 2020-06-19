package com.example.myapplicationwithmvvmdignizent.api;

import com.example.myapplicationwithmvvmdignizent.model.EventModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequestData {
    @GET("demo_api.php")
    Call<EventModel> getEvent();
}
