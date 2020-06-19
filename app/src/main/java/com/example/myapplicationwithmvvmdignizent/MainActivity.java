package com.example.myapplicationwithmvvmdignizent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplicationwithmvvmdignizent.adapter.UserAdapter;
import com.example.myapplicationwithmvvmdignizent.databinding.ActivityMainBinding;
import com.example.myapplicationwithmvvmdignizent.model.EventModel;
import com.example.myapplicationwithmvvmdignizent.util.NetworkStatus;
import com.example.myapplicationwithmvvmdignizent.viewmodel.EventViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Activity activity = null;
    private static final String TAG = "MainActivity";
    private Toolbar toolbar;
    private LinearLayoutManager layoutManager = null;
    private RecyclerView rvItemList = null;

    private EventViewModel eventViewModel;
    UserAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activity = MainActivity.this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppCompatTextView txtHeaderNname = (AppCompatTextView) toolbar.findViewById(R.id.actv_header_name);
        txtHeaderNname.setText(getString(R.string.mayurpractical));

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);

        // eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        eventViewModel = new ViewModelProvider(this).get(EventViewModel.class);

        if (NetworkStatus.getConnectivityStatusString(activity)) {
        getData();
    } else {
        Toast.makeText(activity, "No Internet Connection!", Toast.LENGTH_LONG).show();
    }
}

    private void getData() {
        eventViewModel.getAllUsers().observe(this, userList -> {
            adapter.setUserList((ArrayList<EventModel.Data>) userList);
        });
    }
}