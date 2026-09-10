public class JamDinding {
    private final String merk;
    private String jenisTampilan; // contoh: "Analog" atau "Digital"
    private int baterai; // Invarian 1: 0 <= baterai <= 100
    private int jam; // Invarian 2: 0 <= jam <= 23
    private boolean isNyala;

    public JamDinding(String merk, String jenisTampilan, int bateraiAwal, int jamAwal) {
        if (bateraiAwal < 0 || bateraiAwal > 100) {
            throw new IllegalArgumentException("Baterai harus berada di rentang 0 - 100%");
        }
        if (jamAwal < 0 || jamAwal > 23) {
            throw new IllegalArgumentException("Jam harus berada di rentang 0 - 23!");
        }

        this.merk = merk;
        this.jenisTampilan = jenisTampilan;
        this.baterai = bateraiAwal;
        this.jam = jamAwal;
        this.isNyala = true; // Secara default jam langsung menyala
    }

    // --- Methods ---

    public void nyala() {
        this.isNyala = true;
        System.out.println("Jam dinding " + this.merk + " dinyalakan.");
    }

    public void mati() {
        this.isNyala = false;
        System.out.println("Jam dinding " + this.merk + " dimatikan.");
    }

    public void berdetak() {
        if (!isNyala) {
            System.out.println("Jam dinding " + this.merk + " mati, tidak bisa berdetak.");
            return;
        }
        if (baterai <= 0) {
            System.out.println("Baterai habis! Jam dinding " + this.merk + " berhenti berdetak.");
            return;
        }
        System.out.println("Tik... tok... Jam " + this.merk + " berdetak pada jam " + this.jam + ":00.");
    }

    public void aturWaktu(int jamBaru) {
        if (jamBaru < 0 || jamBaru > 23) {
            throw new IllegalArgumentException("Pengaturan gagal! Jam baru harus antara 0 - 23.");
        }
        this.jam = jamBaru;
        System.out.println("Waktu jam " + this.merk + " berhasil diubah ke jam " + this.jam + ":00.");
    }

    public void isiBaterai(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah isi baterai harus lebih besar dari 0!");
        }
        if (this.baterai + jumlah > 100) {
            throw new IllegalArgumentException("Baterai berlebih! Maksimal kapasitas baterai adalah 100%.");
        }
        this.baterai += jumlah;
        System.out.println("Baterai jam " + this.merk + " berhasil diisi menjadi " + this.baterai + "%.");
    }

    public void tampilkanInfo() {
        System.out.println("=== INFO JAM DINDING ===");
        System.out.println("Merk           : " + this.merk);
        System.out.println("Jenis Tampilan : " + this.jenisTampilan);
        System.out.println("Status Baterai : " + this.baterai + "%");
        System.out.println("Waktu Saat Ini : " + this.jam + ":00");
        System.out.println("Status Jam     : " + (this.isNyala ? "Nyala" : "Mati"));
        System.out.println("========================\n");
    }

    public String getMerk() {
        return merk;
    }

    public int getBaterai() {
        return baterai;
    }

    public int getJam() {
        return jam;
    }
}