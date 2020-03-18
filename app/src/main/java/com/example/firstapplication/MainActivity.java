package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Coin> coinList = Coin.getCoins();
    ArrayList<String> coinName = new ArrayList<>();
    ArrayList<String> coinValue = new ArrayList<>();
    private List<Coin> coinData = new ArrayList<Coin>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MyTag", "This is my message");
        RecyclerView recycleView = findViewById(R.id.recycler);
        coinData = Coin.getCoins();
        for (Coin c : coinList){
            coinName.add(String.valueOf(c.getName()));
            coinValue.add(String.valueOf(c.getValue()));
        }

        CoinAdaptor coinAdaptor = new CoinAdaptor(this, coinName, coinValue);
        recycleView.setAdapter(coinAdaptor);
        recycleView.setLayoutManager(new LinearLayoutManager(this));



    }

}
