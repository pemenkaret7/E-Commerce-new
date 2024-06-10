package Node;

import java.util.ArrayList;

public class User {
    public int ID,saldo;
    public String nama;
    public String pass;
    public ArrayList<Keranjang> keranjang = new ArrayList<>();

    //buat user baru
    public User(int ID,String nama, String pass) {
        this.nama = nama;
        this.pass = pass;
        this.ID = ID;
        this.saldo = 0;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    //buat update dll.
    public User(int ID, int saldo, String nama, String pass) {
        this.ID = ID;
        this.saldo = saldo;
        this.nama = nama;
        this.pass = pass;
    }

    public String getNama() {
        return nama;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPass() {
        return pass;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void kurangiSaldo(int jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println("Saldo anda dikurangi. Saldo anda sekarang: " + saldo);
        } else {
            System.out.println("Saldo tidak mencukupi untuk transaksi ini.");
        }
    }

    public void viewUser(){
        System.out.println("Id User : " + ID);
        System.out.println("======");
        System.out.println("Nama User : " + nama);
        System.out.println("Password User : " + pass);
        System.out.println("Saldo user : "+ saldo);
        System.out.println("=========================");
    }

    public void addKeranjang(Keranjang barang){
        this.keranjang.add(barang);
    }

    public void deleteKeranjang(int index){
        this.keranjang.remove(index);
    }

    public ArrayList<Keranjang> getKeranjang() {
        return keranjang;
    }
}
