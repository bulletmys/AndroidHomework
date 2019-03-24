package com.example.homework;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class Fragment1 extends Fragment {

    private RecyclerView recyclerView;
    private RecycleViewAdapter adapter;
    private ArrayList<String> list = new ArrayList<>();
    private TextView counterView;
    private Button addButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        int size = (savedInstanceState == null) ? 100 : savedInstanceState.getInt("Count", 100);
        Log.d("myl", "OnCreate_Fragment");

        for (int i = 1; i <= size; i++) {
            list.add(i + "");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment1, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        addButton = rootView.findViewById(R.id.button1);
        Log.d("myl", "OnCreate_Fragment_View");
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? 3 : 4));
        recyclerView.setAdapter(new RecycleViewAdapter(getContext(), list));
    }

    @Override
    public void onStart() {
        super.onStart();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add((list.size() + 1) + "");
                Objects.requireNonNull(recyclerView.getAdapter()).notifyItemInserted(list.size());
            }
        });
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle state) {
        super.onSaveInstanceState(state);
        state.putInt("Count", list.size());
        Log.d("myl", "OnSaveInstance");
    }

}
