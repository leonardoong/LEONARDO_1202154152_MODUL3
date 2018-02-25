package com.example.android.leonardo_1202154152_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                //Untuk lanjut ke LoginActivity setelah 2 detik
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                //Agar activity lain tidak dapat kembali lagi ke activity ini
                finish();
            }
        },2000);
    }
}
