package com.example.android.leonardo_1202154152_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);
    }

    //Method yang dijalankan ketika button login ditekan
    public void login(View view) {
        //Mengecek apakah data yang dimasukkan ke dalam EditText user dan pass sudah sesuai atau belum
        if(user.getText().toString().equals("EAD") && pass.getText().toString().equals("MOBILE")){
            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class) ;
            startActivity(intent);
        }else{
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
        }
    }
}

