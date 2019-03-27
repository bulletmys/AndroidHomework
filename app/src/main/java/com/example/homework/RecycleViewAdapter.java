package com.example.homework;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


class RecycleViewHolder extends RecyclerView.ViewHolder {
    private TextView mTextView;

    RecycleViewHolder(final View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.item);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myl", "OnClick");
                Intent intent = new Intent(MainActivity.BROADCAST_ACTION);
                intent.putExtra(MainActivity.VALUE, mTextView.getText().toString());
                intent.putExtra(MainActivity.COLOR, String.valueOf(mTextView.getCurrentTextColor()));
                itemView.getContext().sendBroadcast(intent);
            }
        });
    }

    void setTextView(String num, int color) {
        mTextView.setText(num);
        mTextView.setTextColor(ContextCompat.getColor(this.mTextView.getContext(), color));
    }
}

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolder> {
    private Context context;
    private ArrayList<String> list;

    RecycleViewAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder recycleViewHolder, int i) {
        String num = list.get(i);
        recycleViewHolder.setTextView(num, i % 2 == 0 ? R.color.blue : R.color.red);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
