package com.example.kombat2;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class KeranjangManager {
    private static List<Produk> keranjangObatList = new ArrayList<>();
//    private static List<ItemKeranjang> keranjangList = new ArrayList<>();

    // Metode untuk menambahkan produk ke keranjang
    public static void addToKeranjang(Produk produk) {
        keranjangObatList.add(produk);
    }

    // Metode untuk mendapatkan total harga di keranjang
    public static int hitungTotalHarga() {
        int totalHarga = 0;

        for (Produk produk : keranjangObatList) {
            // Pastikan produk memiliki harga sebelum menambahkannya
            if (produk.getHarga() != null && !produk.getHarga().isEmpty()) {
                totalHarga += Integer.parseInt(produk.getHarga().replaceAll("\\D+", ""));
            }
        }

        return totalHarga;
    }

    public static int hitungJumlahItem() {
        int jumlahItem = 0;

        // Menghitung jumlah item dari setiap objek dalam keranjang
        for (Produk produk : keranjangObatList) {
            jumlahItem += produk.getQuantity();
        }

        return jumlahItem;
    }

    public static void clearKeranjang() {

        keranjangObatList.clear();

    }

    // Metode untuk mendapatkan list produk di keranjang
    public static List<Produk> getKeranjangObatList() {
        return keranjangObatList;
    }
}

