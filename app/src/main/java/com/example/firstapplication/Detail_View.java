package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.os.Bundle;
import android.widget.TextView;

public class Detail_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__view);
        Intent intent = getIntent();
        String value = intent.getStringExtra("message");
        TextView textElement;
        textElement = (TextView) findViewById(R.id.textToBeReplaced);
        textElement.setText(value);


    }

    public void openVideo(View view){
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=-JmYWHCml0A");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
