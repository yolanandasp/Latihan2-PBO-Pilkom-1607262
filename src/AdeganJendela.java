/*
    Adegan dipintu, ada state terkunci
 */

    public class AdeganJendela extends  Adegan { //nomor 2
        boolean isTerkunci = true;
        String narasiTerkunci = "Rudi mendekati Jendela. Rudi mencoba membuka Jendela. \"Ah terkunci\"";
        String narasiTerbuka  = "Rudi mencoba membuka Jendela dan terbuka! ADA ZOMBIEEEE!";

        //constructor
        public AdeganJendela () {
            narasi = narasiTerkunci;
        }

        /* user berhasil menggunakan obeng untuk membuka jendela */
        @Override
        public void gunakanBarang(Barang barangPilih) {
            super.gunakanBarang(barangPilih); //panggil parent
            isTerkunci = false;
            narasi = narasiTerbuka;

            //bertemu zombie
            Adegan adeganZombie = new AdeganZombie();

            Adegan adeganJendela = new AdeganJendela();

            adeganZombie.idBarangBisaDigunakan="Senjata"; //zombie akan dikalahkan jika player memilih senjata
            adeganZombie.narasi = "Rudi pelan-pelan membuka Jendela dan keluar dari kamar. Rudi sekarang berada di koridor " +
                    "yang sangat panjang. Dan Rudi Bertemu Zombie";
            Pilihan pilihanMenuju = new PilihanGantiAdegan(adeganZombie,"Serang Zombie");
            tambahPilihan(pilihanMenuju);

            //karena jendela sudah terbuka ada pilihan baru keluar dari kamar
            Adegan adeganKoridor = new Adegan();
            adeganKoridor.narasi = "Rudi pelan-pelan membuka Jendela dan keluar dari kamar. Rudi sekarang berada di koridor " +
                    "yang sangat panjang";
            Pilihan pilihanMenujuKoridor = new PilihanGantiAdegan(adeganKoridor,"Keluar kamar, ke koridor");
            tambahPilihan(pilihanMenujuKoridor);






        }

    }

