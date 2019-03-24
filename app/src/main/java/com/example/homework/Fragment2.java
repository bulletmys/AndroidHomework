package com.example.homework;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

public class Fragment2 extends Fragment {

    private String number;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        Log.d("myl", "OnCreate_Fragment2");
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = view.findViewById(R.id.big_text);
            title.setText(number);
            if (Integer.parseInt(number) % 2 == 0) {
                title.setTextColor(Objects.requireNonNull(getContext()).getResources().getColor(R.color.red));
            } else {
                title.setTextColor(Objects.requireNonNull(getContext()).getResources().getColor(R.color.blue));
            }
        }
    }

}
