package com.example.miles.wheretoeat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String food_type = "nothing";

    ArrayList<String> restaurants = new ArrayList<String>(Arrays.asList(
            "Jollibee",
            "McDonalds",
            "KFC",
            "Mang Inasal",
            "Chowking",
            "El Burrito",
            "Tofis",
            "Tess and Ylloys",
            "Big D's Ramen",
            "Big B's Burgers",
            "Gastronomeats",
            "Campus Boulevard",
            "Stable",
            "Pizza Pop",
            "Bugong",
            "Big Bellys"
    ));

    ArrayList<String> foods = new ArrayList<String>(Arrays.asList(
            "All",
            "Pork",
            "Chicken",
            "Beef",
            "Seafood",
            "Veggies"
    ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_food3);

        //CODE FOR DROPDOWN
        final Spinner dd_food = (Spinner) findViewById(R.id.dropdown_food);
        ArrayAdapter<String> food_adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, foods);
        dd_food.setAdapter(food_adapter);


        //CODE FOR RANDOMIZE BUTTOn
        Button btnRand = (Button) findViewById(R.id.btn_randomize);
        btnRand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food_type = dd_food.getSelectedItem().toString();
                randomize();
            }
        });

        //CODE FOR ADD-A-RESTAURANT BUTTON
        Button btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRestaurant();
            }
        });

        //CODE FOR VIEW-ALL-RESTAURANTS BUTTON
        Button btnView = (Button) findViewById(R.id.btn_view);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRestaurants();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void randomize(){
        Bundle b = new Bundle();
        b.putStringArrayList("RESTAURANTS", restaurants);
        Intent intent = new Intent(this, RandomizeActivity.class);
        intent.putExtras(b);
        intent.putExtra("type", food_type);
        startActivity(intent);
    }

    public void addRestaurant(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog, null);
        builder.setView(dialogView);

        final EditText adder = (EditText) dialogView.findViewById(R.id.addRest);

        builder.setTitle("Enter name of restaurant");
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = adder.getText().toString();
                restaurants.add(name);

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void viewRestaurants(){
        Bundle b = new Bundle();
        b.putStringArrayList("RESTAURANTS", restaurants);
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtras(b);
        startActivity(intent);
    }
}
