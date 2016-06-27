package com.example.miles.wheretoeat;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RandomizeActivity extends AppCompatActivity {

    boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomize);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ArrayList<String> restaurants;
        restaurants = getIntent().getStringArrayListExtra("RESTAURANTS");
        String food_type = getIntent().getExtras().getString("type");

        //CODE FOR THE ANIMATION
        final TextView list = (TextView) findViewById(R.id.random);
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable(){
            int i=0;

            @Override
            public void run(){
                list.setText(restaurants.get(i));
                i++;
                if(i > restaurants.size() - 1){
                    i=0;
                }
                handler.postDelayed(this, 100);
            }
        };
        handler.postDelayed(runnable, 100);

        //CODE FOR TAP-TO-STOP
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = !running;
                if (!running) {
                    handler.removeCallbacks(runnable);
                } else {
                    handler.postDelayed(runnable, 100);
                }
            }
        });
    }

}
