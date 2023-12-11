package com.example.kombat2;

import java.util.ArrayList;
import java.util.List;

public class ObatSayaManager {
    private static List<Produk> obatSayaList = new ArrayList<>();

    public static List<Produk> getObatSayaList() {

        return obatSayaList;
    }

    public static void addToObatSaya(Produk produk){
        obatSayaList.add(produk);
    }

    public static void removeFromObatSaya(Obat obat) {
        obatSayaList.remove(obat);
    }
}
