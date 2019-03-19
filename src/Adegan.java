import java.util.ArrayList;
import java.util.Scanner;

public class Adegan {

    //static, satu objek player yang sama untuk semua objek adegan
    public static Player oPlayer;

    //pilihan yang ada di semua adegan
    PilihanGunakanKantong oPilihanGunakanKantong;  //lihat barang milik player dan gunakan
    PilihanLihatBarang oPilihanLihatBarang;        //lihat barang di dalam adegan dan pindahkan ke kantong player

    //barang yg valid digunakan dalam adegan ini (misal kunci dalam adegan pintu)
    String idBarangBisaDigunakan;


    String narasi;
    //idealnya menggunakan ArrayList
    //pilihan yang bisa dipilih user untuk setiap adegan
    int jumPil = 0;
    ArrayList<Pilihan> arrpilihan = new ArrayList<>(); //array diubah menjadi arraylist


    //constructor
    public Adegan() {
        //setiap adegan memiliki 2 pilihan yg sama yaitu untuk melihat barang milik player dan melihat barang dalam adegan tsb.
        oPilihanGunakanKantong = new PilihanGunakanKantong(this,"Lihat dan gunakan barang yang dimiliki player");
        tambahPilihan(oPilihanGunakanKantong);

        oPilihanLihatBarang = new PilihanLihatBarang(this,"Lihat barang di sekitar...");
        tambahPilihan(oPilihanLihatBarang);


    }

    //tambah barang yg berada di adegan
    public void tambahBarang(Barang vBarang) {
        oPilihanLihatBarang.tambahBarang(vBarang);
    }


    /*
       tambah pilihan
     */
    public void tambahPilihan(Pilihan oPilihan) {
        //arrPilihan[jumPil] = oPilihan;
        arrpilihan.add(oPilihan);
        jumPil++;
    }


    public void mainkan() {
        //print narasi dan pilihan
        System.out.println(""); //spasi
        System.out.println(narasi);

        //print pilihan
        int data=0;
        for(Pilihan i:arrpilihan){
            data++;
            System.out.println(String.format("%d. %s", data, i.deskripsi));
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Pilihan anda:");
        int pilihan = sc.nextInt();
        System.out.println(""); //spasi

        //eksekusi pilihan yang dipilih user
        arrpilihan.get(pilihan-1).aksi();
    }

    //User memilih barang yang dimiliki player. lihat class PilihanGunakanKantong
    public void gunakanBarang(Barang barangPilih) {
          System.out.println(String.format("Rudi mengambil %s dan menggunakannya...",barangPilih.deskripsi));
    }
}
