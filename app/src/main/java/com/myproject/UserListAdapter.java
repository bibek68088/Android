package com.myproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserListAdapter extends ArrayAdapter<Userinfo> {

    Context context;
    public UserListAdapter(@NonNull Context context, ArrayList<Userinfo>list) {
        super(context, 0, list);
        this.context = context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, null);

        Userinfo info = getItem(position);
        ImageView imageView = itemView.findViewById(R.id.image);
        TextView firstname = itemView.findViewById(R.id.firstname);
        TextView email = itemView.findViewById(R.id.email);
        TextView phone = itemView.findViewById(R.id.phone);
        firstname.setText(info.firstname);
        email.setText(info.email);
        phone.setText(info.lastname);
        if (info.image != null)
            imageView.setImageBitmap(RegisterActivity.getBitmap(info.image));
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", info.id);
                Toast.makeText(context, "id:" + info.id, Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });

        return itemView;
    }
}
