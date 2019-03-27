package com.example.homework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    public static String EXTRA_VALUE = "CONST";
    public static String BROADCAST_ACTION = "SomeThing";
    BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("myl", "onCreate_Main");
        if (savedInstanceState == null)
            openFragment(new Fragment1());

        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Fragment2 numberFragment = new Fragment2();
                numberFragment.setNumber(intent.getStringExtra(EXTRA_VALUE));
                Log.d("myl", "onCreate");

                openFragment(numberFragment);
            }
        };
        IntentFilter intentFilter = new IntentFilter(BROADCAST_ACTION);
        registerReceiver(br, intentFilter);
    }

    private void openFragment(final Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fragment, fragment);


        if (fragment.getClass() != Fragment1.class) {
            transaction.addToBackStack(null);
        }
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("myl", "OnDestroyMain");
        unregisterReceiver(br);
    }
}