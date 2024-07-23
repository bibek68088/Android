package com.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Log.i("Lifecycle", "oncreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Lifecycle", "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Lifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Lifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Lifecycle", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Lifecycle", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecycle", "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.homepage_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
//        switch (id){
//            case R.id.register:
//
//                break;
//            case R.id.menu1:
//
//                break;
//
//            default:
//
//
//
//
//
//        }


        if (id == R.id.register) {
            startActivity(new Intent(HomeActivity.this, RegisterActivity.class));
        } else if (id == R.id.menu1) {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));

        } else if (id == R.id.menu2) {
            startActivity(new Intent(this, ViewpagerActivity.class));
        } else if (id == R.id.submenu1) {
            Toast.makeText(this, "This is submenu 1", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, UserListActivity.class));
        }else if (id == R.id.submenu2) {
            Toast.makeText(this, "This is submenu 2", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, UserListViewActivity.class));
        }

        else if (id == R.id.logout) {
            getSharedPreferences("Userinfo", 0).edit().putBoolean("rememberme", false).commit();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
