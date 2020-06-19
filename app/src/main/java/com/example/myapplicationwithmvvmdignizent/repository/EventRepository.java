package com.example.myapplicationwithmvvmdignizent.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplicationwithmvvmdignizent.api.ApiRequestData;
import com.example.myapplicationwithmvvmdignizent.api.RetroServer;
import com.example.myapplicationwithmvvmdignizent.custom_views.CustomProgressDialog;
import com.example.myapplicationwithmvvmdignizent.model.EventModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRepository {

    private ArrayList<EventModel.Data> userArrayList = new ArrayList<>();
    private MutableLiveData<List<EventModel.Data>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public EventRepository(Application application) {
        this.application = application;
    }

    /*  public MutableLiveData<List<EventModel.Data>> getEvents() {
          ApiRequestData apiService = RetroServer.getRetrofitServer();
          Call<List<EventModel.Data>> call = apiService.getEvent();
          call.enqueue(new Callback<List<EventModel.Data>>() {
              @Override
              public void onResponse(Call<List<EventModel.Data>> call, Response<List<EventModel.Data>> response) {
                  if (response.body() != null) {
                      userArrayList = (ArrayList<EventModel.Data>) response.body();
                      mutableLiveData.setValue(userArrayList);
                      Log.e("Response", String.valueOf(userArrayList));
                  }
              }
              @Override
              public void onFailure(Call<List<EventModel.Data>> call, Throwable t) {
                  Log.e("Response", "String.valueOf(userArrayList)");
              }
          });
          return mutableLiveData;
      }
  */
    public MutableLiveData<List<EventModel.Data>> getEvents() {
        ApiRequestData apiService = RetroServer.getRetrofitInstance().create(ApiRequestData.class);
        Call<EventModel> call = apiService.getEvent();

        call.enqueue(new Callback<EventModel>() {
            @Override
            public void onResponse(Call<EventModel> call, Response<EventModel> response) {
                if (response.body() != null) {
                    userArrayList = (ArrayList<EventModel.Data>) response.body().getData();
                    mutableLiveData.setValue(userArrayList);
                    Log.e("Response", userArrayList.toString());
                }
            }
            @Override
            public void onFailure(Call<EventModel> call, Throwable t) {
                Log.e("Response", t.getMessage());
            }
        });
        return mutableLiveData;
    }
}