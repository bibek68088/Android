package com.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    LinearLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list_activity);
        container = findViewById(R.id.container);
        databaseHelper = new DatabaseHelper(this);
        displayUsers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayUsers();
    }

    public void displayUsers() {
        ArrayList<Userinfo> list = databaseHelper.getUsers();
        container.removeAllViews();
        for (Userinfo info : list) {
            View itemView = LayoutInflater.from(this).inflate(R.layout.item_layout, null);

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
                    Intent intent = new Intent(UserListActivity.this, DetailActivity.class);
                    intent.putExtra("id", info.id);
                    Toast.makeText(UserListActivity.this, "id:" + info.id, Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });
            container.addView(itemView);
        }
    }
}
