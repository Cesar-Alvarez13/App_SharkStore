package com.example.app_cesaralvarez;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class SplashScreen extends AppCompatActivity {
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        runnable = new Runnable(){

            @Override
            public void run(){
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable,4000);
    }

    @Override
    public  void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}