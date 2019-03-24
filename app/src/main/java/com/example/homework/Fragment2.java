package com.example.homework;
//
//import android.content.res.Resources;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//public class Fragment2 extends Fragment {
//    private String mNumber;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    public void setmNumber(String value) {
//        mNumber = value;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment2, container, false);
//        TextView textNum = view.findViewById(R.id.text2);
//        textNum.setText(String.valueOf(mNumber));
//        Resources res = getResources();
//        int color = (Integer.parseInt(mNumber) % 2 == 0) ? res.getColor(R.color.red)
//                : res.getColor(R.color.blue);
//        textNum.setTextColor(color);
//        return view;
//    }
//}

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    private String number;

    public Fragment2() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    public void setNumber(String number){
        this.number=number;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view!=null){
            TextView title=(TextView)view.findViewById(R.id.big_text);
            title.setText(number);
            if (Integer.parseInt(number)%2==0) {
                title.setTextColor(getContext().getResources().getColor(R.color.red));
            }else {
                title.setTextColor(getContext().getResources().getColor(R.color.blue));
            }
        }
    }

}
