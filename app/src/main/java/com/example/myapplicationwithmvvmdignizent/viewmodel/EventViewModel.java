package com.example.myapplicationwithmvvmdignizent.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplicationwithmvvmdignizent.model.EventModel;
import com.example.myapplicationwithmvvmdignizent.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;


public class EventViewModel extends AndroidViewModel {
    EventRepository repository;

    public EventViewModel(@NonNull Application application) {
        super(application);
        repository = new EventRepository(application);
    }

    public LiveData<List<EventModel.Data>> getAllUsers() {
        return repository.getEvents();
    }
}
