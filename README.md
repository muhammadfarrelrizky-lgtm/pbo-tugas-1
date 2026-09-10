# Tugas 1 - Pemrograman Berorientasi Objek (PBO)

Nama : Muhammad Farrel Rizky  
NPM  : 4525210117  

---

## 1. Domain & Class
- Domain: Jam Dinding
- Class Utama: `JamDinding`

---

## 2. Invarian & Alasannya

Dalam class `JamDinding`, terdapat 2 invarian (aturan bisnis yang harus selalu benar selama objek hidup):

1. Invarian Baterai (`0 <= baterai <= 100`)**
   - Alasan: Persentase daya baterai jam dinding secara fisik tidak pernah bernilai negatif (kurang dari 0) dan tidak bisa melebihi kapasitas maksimum 100%.
2. Invarian Waktu / Jam (`0 <= jam <= 23`)
   - Alasan: Pengaturan jam pada format waktu 24-jam berada pada rentang 0 hingga 23. Angka negatif atau melebihi 23 adalah waktu yang tidak sah secara logika.

---

## 3. Cara Menjalankan Program

### A. Versi Java
1. Buka terminal di folder `Tugas1`.
2. Masuk ke folder Java:
   ```bash
   cd java