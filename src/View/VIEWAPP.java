package View;

import java.util.Scanner;
import Node.*;

public class VIEWAPP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UserView userView = new UserView();
        ProdukView produkView = new ProdukView();
        PembayaranView pembayaranView = new PembayaranView();

        int pilihanAwal;
        do {
            System.out.println("=== Aplikasi E-commerce ===");
            System.out.println("1. Tambah User");
            System.out.println("2. Update User");
            System.out.println("3. Login");
            System.out.println("4. Exit");
            System.out.print("Pilih menu: ");
            pilihanAwal = scan.nextInt();
            scan.nextLine();

            switch (pilihanAwal) {
                case 1:
                    userView.ADDUSER();
                    break;
                case 2:
                    userView.UpdateUSER();
                    break;
                case 3:
                    User user = userView.login();
                    if (user != null) {
                        menuUtama(scan, user, userView, produkView, pembayaranView);
                    } else {
                        System.out.println("Login gagal. Silakan coba lagi.");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihanAwal != 4);
    }

    public static void menuUtama(Scanner scan, User user, UserView userView, ProdukView produkView, PembayaranView pembayaranView) {
        while (true) {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Update Produk");
            System.out.println("3. Hapus Produk");
            System.out.println("4. Beli Produk");
            System.out.println("5. Tambah Saldo");
            System.out.println("6. Logout");
            System.out.print("Pilih menu: ");
            int pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1:
                    produkView.insertProduk();
                    break;
                case 2:
                    produkView.UPDATEPRODUK();
                    break;
                case 3:
                    produkView.DELETEPRODUK();
                    break;
                case 4:
                    pembayaranView.insertlangsungBayar(user);
                    break;
                case 5:
                    userView.tambahSaldo(user);
                    break;
                case 6:
                    System.out.println("Logout berhasil.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
