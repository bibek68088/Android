package com.myproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TabUsingFragmentActivity extends AppCompatActivity {

    TextView tab1, tab2;

    TopFragment topFragment;
    BottomFragment bottomFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_using_fragment);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);

        topFragment = new TopFragment();
        bottomFragment = new BottomFragment();
        tab1.setBackgroundColor(Color.RED);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,topFragment).commit();
    }


    public void tabClickListener(View view){
        if(view.getId()==R.id.tab1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,topFragment).commit();
            tab1.setBackgroundColor(Color.RED);
            tab2.setBackgroundColor(Color.WHITE);

        } else{
            tab2.setBackgroundColor(Color.RED);
            tab1.setBackgroundColor(Color.WHITE);
            getSupportFragmentManager().beginTransaction().replace(R.id.container,bottomFragment).commit();

        }
    }
}
