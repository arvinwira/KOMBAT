package com.example.kombat2;

import android.os.Parcel;
import android.os.Parcelable;

public class Vitamin implements Produk, Parcelable {
    private String nama;
    private String deskripsi;
    private String harga;
    private int gambarResId;
    private int quantity; // Properti untuk menyimpan jumlah item


    public Vitamin(String nama, String deskripsi, String harga, int gambarResId) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.gambarResId = gambarResId;
    }

    public Vitamin(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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


    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }


    public int getGambarResId() {
        return gambarResId;
    }

    public void setGambarResId(int gambarResId) {
        this.gambarResId = gambarResId;
    }


    // Parcelable implementation
    protected Vitamin(Parcel in) {
        nama = in.readString();
        deskripsi = in.readString();
        harga = in.readString();
        gambarResId = in.readInt();
    }

    public static final Parcelable.Creator<Vitamin> CREATOR = new Parcelable.Creator<Vitamin>() {
        @Override
        public Vitamin createFromParcel(Parcel in) {
            return new Vitamin(in);
        }

        @Override
        public Vitamin[] newArray(int size) {
            return new Vitamin[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(deskripsi);
        dest.writeString(harga);
        dest.writeInt(gambarResId);
    }
}

