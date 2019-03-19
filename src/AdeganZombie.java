public class AdeganZombie extends Adegan { //bonus2

        boolean isTerkunci = true; //sudah dikalahkan/belum
        String narasiTerkunci = "Rudi keluar dari jendela. Rudi bertemu zombie.";
        String narasiTerbuka  = "Rudi mengalahkan zombie!";

        //constructor
        public AdeganZombie () {
            narasi = narasiTerkunci;
        }

        /* user berhasil menggunakan senjata untuk mengalahkan zombie */
        @Override
        public void gunakanBarang(Barang barangPilih) {
            super.gunakanBarang(barangPilih); //panggil parent
            isTerkunci = false;
            narasi = narasiTerbuka;

            //karena jendela sudah terbuka ada pilihan baru keluar dari kamar
            Adegan adeganKoridor = new Adegan();
            adeganKoridor.narasi = "Rudi pelan-pelan membuka Jendela dan keluar dari kamar. Rudi sekarang berada di koridor " +
              "yang sangat panjang";
            Pilihan pilihanMenujuKoridor = new PilihanGantiAdegan(adeganKoridor,"Keluar kamar, ke koridor");
            tambahPilihan(pilihanMenujuKoridor);




        }

    }

