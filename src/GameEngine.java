/*
    inisialisasi adegan dsb, jalankan adegan sampai permainan selesai.

 */

public class GameEngine {
    Player oPlayer;

    public GameEngine() {
        Barang koin = new Barang("koin","uang koin");
        oPlayer = new Player();
        oPlayer.tambahBarang(koin);  //dummy saja
        //perhatikan Adegan  disini adalah class, oPlayer adalah static atribut sehingga berlaku untuk semua objek
        //artinya semua objek adegan punya objek player yang sama
        Adegan.oPlayer = oPlayer;
    }

    public void mulai() {
        oPlayer.printIdentitas();
        oPlayer.printStatistik();
        do {
            oPlayer.adeganAktif.mainkan();
            oPlayer.pakai();
            }
            while (!oPlayer.isSelesai) ;
        }

    public static void main(String[] args) {

        Barang kunci = new Barang("kunci_besar","Kunci Besar");

        Adegan adeganPintu = new AdeganPintu();
        Adegan adeganMeja  = new Adegan();
        Adegan adeganJendela  = new AdeganJendela();
        Adegan adeganzombie  = new AdeganZombie();

        Pilihan pilihanMenujuPintu = new PilihanGantiAdegan(adeganPintu,"Menuju pintu");
        Pilihan pilihanMenujuJendela = new PilihanGantiAdegan(adeganJendela,"Menuju Jendela");
        Pilihan pilihanMenujuMeja  = new PilihanGantiAdegan(adeganMeja,"Menuju meja");

        //init data cerita
        // == adegan awal
        Adegan  adeganAwal = new Adegan();
        adeganAwal.narasi =
                "Rudi terbangun disebuah ruangan yang tidak dikenal. Dia melihat sekeliling, \n" +
                "terlihat jendela, pintu dan sebuah meja kecil";

        adeganAwal.tambahPilihan(pilihanMenujuPintu);
        adeganAwal.tambahPilihan(pilihanMenujuMeja);
        adeganAwal.tambahPilihan(pilihanMenujuJendela);

        // == adegan di depan pintu
        adeganPintu.tambahPilihan(pilihanMenujuMeja); //pilihan ke meja direuse
        adeganPintu.tambahPilihan(pilihanMenujuJendela); //pilihan ke Jendela direuse
        adeganPintu.idBarangBisaDigunakan = "kunci_besar"; //kunci_besar bisa digunakan di adegan ini
        adeganPintu.tambahBarang(new Barang("Obeng", "Obeng")); //nomor3

        // == adegan di depan meja
        adeganMeja.narasi = "Rudi mendekati meja. Ada beberapa barang di atas meja";
        adeganMeja.tambahBarang(new Barang("kunci_besar", "Kunci berukuran besar"));
        adeganMeja.tambahBarang(new Barang("senter", "Senter kecil"));
        adeganMeja.tambahBarang(new Barang("makanan", "Makanan"));
        adeganMeja.tambahBarang(new Barang("Senjata", "Senjata"));

        adeganMeja.tambahPilihan(pilihanMenujuPintu); //dari meja bisa ke pintu
        adeganMeja.tambahPilihan(pilihanMenujuJendela); //dari meja bisa ke Jendela

        // ==adegan di depan jendela
        adeganJendela.tambahPilihan(pilihanMenujuPintu); //pilihan ke pintu
        adeganJendela.tambahPilihan(pilihanMenujuMeja); //pilihan ke meja
        adeganJendela.idBarangBisaDigunakan = "Obeng"; //Obeng bisa digunakan di adegan ini (nomor3)

        //== init game engine
        GameEngine ge = new GameEngine();
        //ge.tambahAdegan(adeganMeja);
        ge.oPlayer.adeganAktif = adeganAwal; //start dari adegan awal
        ge.mulai();
    }
}
