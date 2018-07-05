package com.example.sey.dishies;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DishesAdapter extends ArrayAdapter<Dish> {
    private List<Dish> dList;
    Context context;

    public DishesAdapter(@NonNull Context context, @NonNull List<Dish> objects) {
        super(context, 0, objects);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        final Dish dish = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
        }

        // Lookup view for data population
        //Picasso.with(MainActivity.this).load(dish.imgUrl).into(convertView.findViewById(R.id.img));
        ImageView imageView =(ImageView) convertView.findViewById(R.id.img);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.titl);
        TextView tvDisc = (TextView) convertView.findViewById(R.id.disc);
        // Populate the data into the template view using the data object
        Picasso.with(getContext()).load(dish.imgUrl).fit().into(imageView);
        tvTitle.setText(dish.title);
        tvDisc.setText(dish.discription);
        // Return the completed view to render on screen
        return convertView;

    }

}
