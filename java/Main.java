public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST 1: MEMBUAT OBJEK VALID ===");
        // Objek valid: Merk Seiko, Analog, Baterai 80%, Jam 10
        JamDinding jamSeiko = new JamDinding("Seiko", "Analog", 80, 10);
        jamSeiko.tampilkanInfo();

        System.out.println("=== TEST 2: PERUBAHAN SAH ===");
        // Mengubah waktu ke jam 15 (SAH)
        jamSeiko.aturWaktu(15);
        jamSeiko.berdetak();
        jamSeiko.tampilkanInfo();

        System.out.println("=== TEST 3: OPERASI TIDAK SAH 1 (Invarian Waktu) ===");
        try {
            // Mencoba atur jam ke 25 (TIDAK SAH) -> Objek menolak!
            System.out.println("Mencoba mengatur jam ke 25...");
            jamSeiko.aturWaktu(25);
        } catch (IllegalArgumentException e) {
            System.out.println("DITOLAK: " + e.getMessage() + "\n");
        }

        System.out.println("=== TEST 4: OPERASI TIDAK SAH 2 (Invarian Baterai) ===");
        try {
            // Mencoba mengisi baterai berlebihan sehingga > 100% (TIDAK SAH) -> Objek
            // menolak!
            System.out.println("Mencoba menambah baterai sebesar 50% (Baterai awal 80%)...");
            jamSeiko.isiBaterai(50);
        } catch (IllegalArgumentException e) {
            System.out.println("DITOLAK: " + e.getMessage() + "\n");
        }

        System.out.println("=== KONDISI AKHIR OBJEK (Tetap Aman) ===");
        jamSeiko.tampilkanInfo();
    }
}