package com.example.homework;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    private String number;
    private int color;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        Log.d("myl", "OnCreate_Fragment2");
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    public void setNumber(String number, String color) {
        this.number = number;
        this.color = Integer.parseInt(color);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = view.findViewById(R.id.big_text);
            title.setText(number);
            title.setTextColor(color);
        }
    }

}
