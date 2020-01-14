package com.example.cemilan.Model;

import com.google.gson.annotations.SerializedName;

public class Makanan {

    @SerializedName("id")
    private String id;
    @SerializedName("img")
    private String img;
    @SerializedName("nama")
    private String nama;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("harga")
    private int harga;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
