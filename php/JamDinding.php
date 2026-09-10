<?php

declare(strict_types=1);

class JamDinding
{
    public function __construct(
        private readonly string $merk,
        private string $jenisTampilan,
        private int $baterai,
        private int $jam,
        private bool $isNyala = true
    ) {
        // Validasi Invarian 1 (Baterai)
        if ($baterai < 0 || $baterai > 100) {
            throw new InvalidArgumentException("Baterai harus berada di rentang 0 - 100%!");
        }

        // Validasi Invarian 2 (Jam)
        if ($jam < 0 || $jam > 23) {
            throw new InvalidArgumentException("Jam harus berada di rentang 0 - 23!");
        }
    }

    public function nyala(): void
    {
        $this->isNyala = true;
        echo "Jam dinding " . $this->merk . " dinyalakan.\n";
    }

    public function mati(): void
    {
        $this->isNyala = false;
        echo "Jam dinding " . $this->merk . " dimatikan.\n";
    }

    public function berdetak(): void
    {
        if (!$this->isNyala) {
            echo "Jam dinding " . $this->merk . " mati, tidak bisa berdetak.\n";
            return;
        }
        if ($this->baterai <= 0) {
            echo "Baterai habis! Jam dinding " . $this->merk . " berhenti berdetak.\n";
            return;
        }
        echo "Tik... tok... Jam " . $this->merk . " berdetak pada jam " . $this->jam . ":00.\n";
    }

    public function aturWaktu(int $jamBaru): void
    {
        if ($jamBaru < 0 || $jamBaru > 23) {
            throw new InvalidArgumentException("Pengaturan gagal! Jam baru harus antara 0 - 23.");
        }
        $this->jam = $jamBaru;
        echo "Waktu jam " . $this->merk . " berhasil diubah ke jam " . $this->jam . ":00.\n";
    }

    public function isiBaterai(int $jumlah): void
    {
        if ($jumlah <= 0) {
            throw new InvalidArgumentException("Jumlah isi baterai harus lebih besar dari 0!");
        }
        if ($this->baterai + $jumlah > 100) {
            throw new InvalidArgumentException("Baterai berlebih! Maksimal kapasitas baterai adalah 100%.");
        }
        $this->baterai += $jumlah;
        echo "Baterai jam " . $this->merk . " berhasil diisi menjadi " . $this->baterai . "%.\n";
    }

    public function tampilkanInfo(): void
    {
        $statusNyala = $this->isNyala ? "Nyala" : "Mati";
        echo "=== INFO JAM DINDING ===\n";
        echo "Merk           : {$this->merk}\n";
        echo "Jenis Tampilan : {$this->jenisTampilan}\n";
        echo "Status Baterai : {$this->baterai}%\n";
        echo "Waktu Saat Ini : {$this->jam}:00\n";
        echo "Status Jam     : {$statusNyala}\n";
        echo "========================\n\n";
    }

    public function getMerk(): string
    {
        return $this->merk;
    }

    public function getBaterai(): int
    {
        return $this->baterai;
    }

    public function getJam(): int
    {
        return $this->jam;
    }
}
