package com.example.firstapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FragmentDetail extends Fragment {
    List<Coin> coinList = Coin.getCoins();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_detail, container, false);
        int value = getArguments().getInt("valuable");

        TextView name_of_coin =  view.findViewById(R.id.coinName);
        TextView abbreviation = view.findViewById(R.id.coinAbbreviation);
        TextView coin_value = view.findViewById(R.id.coinValue);
        TextView change_one_hour = view.findViewById(R.id.coinChange);
        TextView change_24_hour = view.findViewById(R.id.coinChange24);
        TextView change_7_day = view.findViewById(R.id.coinChange7d);
        TextView market_cap = view.findViewById(R.id.marketCapValue);
        TextView volume_coin = view.findViewById(R.id.volumeValue);
        // Inflate the layout for this fragment


        
        Coin returnCoin = coinList.get(value);
        name_of_coin.setText(String.valueOf(returnCoin.getName()));
        abbreviation.setText(String.valueOf(returnCoin.getSymbol()));
        coin_value.setText(String.valueOf(returnCoin.getValue()));
        change_one_hour.setText(String.valueOf(returnCoin.getChange1h()));
        change_24_hour.setText(String.valueOf(returnCoin.getChange24h()));
        change_7_day.setText(String.valueOf(returnCoin.getChange7d()));
        market_cap.setText(String.valueOf(returnCoin.getMarketcap()));
        volume_coin.setText(String.valueOf(returnCoin.getVolume()));

        return view;
    }

}
