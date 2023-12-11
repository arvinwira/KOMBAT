package com.example.kombat2;

import android.os.Parcel;
import android.os.Parcelable;

public class Obat implements Produk, Parcelable {
    private String nama;
    private String jenis;
    private String deskripsi;
    private String harga;
    private int gambarResId;
    private int quantity; // Properti untuk menyimpan jumlah item


    // Konstruktor
    public Obat(String nama, String jenis, String deskripsi, String harga, int gambarResId) {
        this.nama = nama;
        this.jenis = jenis;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.gambarResId = gambarResId;
    }

    // Getter dan Setter

    // Konstruktor dan metode setter getter lainnya
    public Obat(int quantity) {
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
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
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
    protected Obat(Parcel in) {
        nama = in.readString();
        jenis = in.readString();
        deskripsi = in.readString();
        harga = in.readString();
        gambarResId = in.readInt();
    }

    public static final Parcelable.Creator<Obat> CREATOR = new Parcelable.Creator<Obat>() {
        @Override
        public Obat createFromParcel(Parcel in) {
            return new Obat(in);
        }

        @Override
        public Obat[] newArray(int size) {
            return new Obat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(jenis);
        dest.writeString(deskripsi);
        dest.writeString(harga);
        dest.writeInt(gambarResId);
    }
}
