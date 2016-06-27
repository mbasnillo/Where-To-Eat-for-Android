package com.example.miles.wheretoeat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Miles on 6/21/2016.
 */
public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> web;
    public CustomList(Activity context,
                      ArrayList<String> web) {
        super(context, R.layout.list, web);
        this.context = context;
        this.web = web;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.list_text);

        txtTitle.setText(web.get(position));

        return rowView;
    }
}
