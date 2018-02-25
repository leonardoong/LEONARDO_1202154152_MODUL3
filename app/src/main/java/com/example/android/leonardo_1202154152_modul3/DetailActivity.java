package com.example.android.leonardo_1202154152_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {
    private ImageView level;
    private TextView levelIndicator, judul;
    private int minLevel = 0;
    private int currentLevel = 0;
    private int maxLevel = 6;
    private String txtIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        judul = (TextView) findViewById(R.id.judul);
        levelIndicator = (TextView) findViewById(R.id.airIndicator);
        String judul1 = intent.getStringExtra("judul");

        judul.setText(judul1);

        level = (ImageView)findViewById(R.id.airLevel);
    }
    //method untuk menambahkan level pada icon botol
    public void addLevel(View view) {
        //jika di klik pada level akan naik 1 level
        currentLevel+=1;

        //pengecekkan ketika level yang sekarang belum sampai maxlevel
        if (currentLevel<=maxLevel){
            level.setImageLevel(currentLevel+=1);
            levelIndicator.setText(currentLevel+"L");

            //pengecekan ketika level sekarang sudah sampai maxlevel
            if (currentLevel==maxLevel){
                //akan muncul toast untuk pemberitahuan
                Toast.makeText(this, "Air sudah penuh", Toast.LENGTH_SHORT).show();
            }
            Log.d("current level", "Current Level: "+currentLevel);

            //else untuk menjaga agar level tidak melebihi maksimum level
        }else{
            currentLevel=maxLevel;
            txtIndicator=currentLevel+"L";
        }


    }
    //method untuk mengurangi level pada icon botol
    public void decreaseLevel(View view) {
        //jika di klik maka level berkurang 1 level
        currentLevel-=1;
        //if statement untuk pengecekan apakah level kurang dari minimum level
        if (currentLevel>=minLevel){
            level.setImageLevel(currentLevel-=1);
            levelIndicator.setText(currentLevel+"L");

            //menampilkan toast jika level sama dengan minimum level
            if  (currentLevel==minLevel){
                Toast.makeText(this, "Air sedikit", Toast.LENGTH_SHORT).show();
            }
            //else untuk menjaga agar level tidak kurang dari minimum level
        }else{
            currentLevel=minLevel;
            txtIndicator=currentLevel+"L";;
        }
    }
}
