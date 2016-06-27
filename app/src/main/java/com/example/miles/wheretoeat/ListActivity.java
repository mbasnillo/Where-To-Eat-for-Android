package com.example.miles.wheretoeat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<String> restaurants;
        restaurants = getIntent().getStringArrayListExtra("RESTAURANTS");

        CustomList adapter = new CustomList(this, restaurants);
        ListView list = (ListView) findViewById(R.id.list_all);
        list.setAdapter(adapter);
    }

}
