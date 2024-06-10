package View;
import Controller.Control_Pembayaran;
import Node.*;
import Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PembayaranView {

    Scanner scan = new Scanner(System.in);
    Control_Pembayaran controlPembayaran = new Control_Pembayaran();

    public void insertlangsungBayar(User user){
        System.out.println(" ");
        System.out.println("USER PEMBELI : "+user.getNama());
        System.out.println("=== Market =====");
        Model.modelProduk.viewAllbarang();
        System.out.println("Masukkan kode barang yang akan dibeli : ");
        int kode = scan.nextInt();
        if (Model.modelProduk.getProduk(kode) != null){
            Model.modelProduk.getProduk(kode).viewproduk();
        System.out.println("Berapakah jumlah barang yang akan dibeli : ");
        int brp = scan.nextInt();
       controlPembayaran.tambahPembayaran(user.getNama(), kode,brp);
       Model.modelProduk.commit();
        }else {
            System.out.println("BArang gaada bang");
        }
    }

    public void insertBayarkeranjang(User user, ArrayList<Keranjang> keranjangs) {
        System.out.println(" ");
        System.out.println("USER PEMBELI : " + user.getNama());
        System.out.println("=== Keranjang Belanja =====");
        System.out.println("=== Market =====");
        Model.modelProduk.viewAllbarang();
        System.out.println("Masukkan kode barang yang akan ditambahkan ke keranjang : ");
        int kode = scan.nextInt();
        if (Model.modelProduk.getProduk(kode) != null) {
            Model.modelProduk.getProduk(kode).viewproduk();
            System.out.println("Berapakah jumlah barang yang akan ditambahkan ke keranjang : ");
            int brp = scan.nextInt();
            Keranjang barang = new Keranjang(Model.modelProduk.getProduk(kode), brp);
            keranjangs.add(barang);
            System.out.println("Barang berhasil ditambahkan ke keranjang.");
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
    }

}
