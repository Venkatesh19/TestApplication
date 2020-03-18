package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;


public class CoinJava extends AppCompatActivity {
    List<Coin> coinList = Coin.getCoins();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_java);
       Intent intent = getIntent();
        int value = intent.getIntExtra("message", 0);
        Bundle bundle = new Bundle();
        bundle.putInt("valuable", value);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new FragmentDetail();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.ScrollViewSmall, fragment).commit();





    }

}


