package com.example.firstapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CoinAdaptor extends RecyclerView.Adapter<CoinAdaptor.MyViewHolder>     {

    public ArrayList<String> coin_name;
    public ArrayList<String> coin_value;
    public List<Coin> coinData = new ArrayList<Coin>();
    Context context;

    public CoinAdaptor(Context ct, ArrayList<String> coinName, ArrayList<String> coinValue){
        context = ct;
        coin_name = coinName;
        coin_value = coinValue;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rows, parent,  false);
        return new MyViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.myText1.setText(coin_name.get(position));
        holder.myText2.setText(coin_value.get(position));
       /* holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(context, CoinJava.class);
                intent.putExtra("message", String.valueOf(coin_name.get(position)));
                context.startActivity(intent);
            }
        });
        */

    }

    @Override
    public int getItemCount() {
        return coin_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myText1, myText2;
        CoinAdaptor adapter;

        //ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView, CoinAdaptor coinAdaptor) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.coinBagName);
            myText2 = itemView.findViewById(R.id.coinBagValue);
            this.adapter = coinAdaptor;
            itemView.setOnClickListener(this);
            //mainLayout = itemView.findViewById(R.id.detailView);

        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
//            Coin coin = coinData.get(position);
            Fragment fragment = new FragmentDetail();
            Bundle bundle = new Bundle();
            bundle.putInt("valuable", position);
            fragment.setArguments(bundle);
            Intent intent = new Intent(v.getContext(), CoinJava.class);
            intent.putExtra("message", position);
            v.getContext().startActivity(intent);


        }
    }
}
