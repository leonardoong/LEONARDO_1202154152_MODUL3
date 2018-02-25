package com.example.android.leonardo_1202154152_modul3;

/**
 * Created by Leonardo on 2/25/2018.
 */

//Pembuatan class MerkAir
public class MerkAir {
    private String nama;
    private String info;
    private int gambar;

    //Mehod/Constructor untuk class MerkAir yang memiliki parameter nama, info dan gambar
    public MerkAir(String nama, String info, int gambar){
        this.nama = nama;
        this.info = info;
        this.gambar = gambar;
    }

    //3 method get dibawah untuk mengambil attribute dari class MerkAir
    public String getNama(){
        return nama;
    }

    public String getInfo(){
        return info;
    }

    public int getGambar(){
        return gambar;
    }
}
