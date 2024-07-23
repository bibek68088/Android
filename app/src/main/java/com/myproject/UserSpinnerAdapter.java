package com.myproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserSpinnerAdapter extends ArrayAdapter<Userinfo> {
    Context context;

    public UserSpinnerAdapter(@NonNull Context context, ArrayList<Userinfo> list) {
        super(context, 0, list);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = new TextView(context);

        Userinfo item = getItem(position);
        textView.setText(item.firstname);
        return textView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = new TextView(context);

        Userinfo item = getItem(position);
        textView.setText(item.firstname);
        return textView;    }
}
