<?php

declare(strict_types=1);

require_once 'JamDinding.php';

echo "=== TEST 1: MEMBUAT OBJEK VALID ===\n";
// Objek valid: Merk Seiko, Analog, Baterai 80%, Jam 10
$jamSeiko = new JamDinding("Seiko", "Analog", 80, 10);
$jamSeiko->tampilkanInfo();

echo "=== TEST 2: PERUBAHAN SAH ===\n";
// Mengubah waktu ke jam 15 (SAH)
$jamSeiko->aturWaktu(15);
$jamSeiko->berdetak();
$jamSeiko->tampilkanInfo();

echo "=== TEST 3: OPERASI TIDAK SAH 1 (Invarian Waktu) ===\n";
try {
    // Mencoba atur jam ke 25 (TIDAK SAH) -> Objek menolak!
    echo "Mencoba mengatur jam ke 25...\n";
    $jamSeiko->aturWaktu(25);
} catch (InvalidArgumentException $e) {
    echo "DITOLAK: " . $e->getMessage() . "\n\n";
}

echo "=== TEST 4: OPERASI TIDAK SAH 2 (Invarian Baterai) ===\n";
try {
    // Mencoba menambah baterai sebesar 50% (Baterai awal 80%) -> Objek menolak!
    echo "Mencoba menambah baterai sebesar 50%...\n";
    $jamSeiko->isiBaterai(50);
} catch (InvalidArgumentException $e) {
    echo "DITOLAK: " . $e->getMessage() . "\n\n";
}

echo "=== KONDISI AKHIR OBJEK (Tetap Aman) ===\n";
$jamSeiko->tampilkanInfo();
