-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 12 Bulan Mei 2020 pada 12.17
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loker2`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(7, '2014_10_12_000000_create_users_table', 1),
(8, '2020_04_20_040439_create_sektor_table', 1),
(9, '2020_04_20_040449_create_perusahaan_table', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `perusahaan`
--

CREATE TABLE `perusahaan` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `sektor_id` bigint(20) UNSIGNED NOT NULL,
  `nama_perusahaan` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pekerjaan` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lokasi` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gaji` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `deskripsi` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `syarat` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `no_hp` bigint(20) NOT NULL,
  `website` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `perusahaan`
--

INSERT INTO `perusahaan` (`id`, `sektor_id`, `nama_perusahaan`, `pekerjaan`, `lokasi`, `gaji`, `deskripsi`, `syarat`, `no_hp`, `website`, `created_at`, `updated_at`) VALUES
(1, 2, 'Bank Central Asia - Surabaya', 'Customer Service', 'Surabaya, Jawa Timur', '7 Juta', 'PT Bank Central Asia Tbk adalah bank swasta terbesar di Indonesia. Bank ini didirikan pada 21 Februari 1957 dengan nama Bank Central Asia NV dan pernah menjadi bagian penting dari Salim Group.', '- Diperlukan karyawan yang memiliki pengalaman kerja selama 5 tahun', 82651789009, 'bcasurabaya.co.id', '2020-04-29 03:17:51', '2020-04-29 03:17:51'),
(2, 2, 'Bank BRI - Surakarta', 'Teller', 'Surakarta, Jawa Timur', '9 Juta', 'PT Bank Rakyat Indonesia, Tbk adalah salah satu bank milik pemerintah terbesar di Indonesia.', '- Diperlukan karyawan yang memiliki pengalaman kerja selama 5 tahun', 81425678909, 'brisurakarta.co.id', '2020-04-29 03:17:51', '2020-04-29 03:17:51'),
(3, 2, 'BNI SKM Sidoarjo', 'Customer Service', 'Sidoarjo, Jawa Timur', '6 Juta', 'Bank Negara Indonesia atau BNI adalah sebuah institusi bank milik pemerintah, dalam hal ini adalah perusahaan BUMN, di Indonesia.', '- Diperlukan karyawan yang memiliki pengalaman kerja selama 5 tahun', 81423333456, 'bnisidoarjo.co.id', '2020-04-29 03:17:51', '2020-04-29 03:17:51'),
(4, 3, 'Dinas Pendidikan - Bogor', 'Staf', 'Bogor, Jawa Barat', '3 Juta', 'Pendidikan yang bermutu merupakan tuntutan masyarakat Indonesia sebagai wahana untuk menghasilkan sumber daya manusia bermutu yang mampu bersaing secara global.', '- Diperlukan karyawan yang memiliki gelar sarjana', 82423333456, 'dipendikbogor.co.id', '2020-04-29 03:17:51', '2020-04-29 03:17:51'),
(5, 3, 'Dinas Pendidikan - Bandung', 'Manager', 'Bandung, Jawa Barat', '8 Juta', 'Pendidikan yang bermutu merupakan tuntutan masyarakat Indonesia sebagai wahana untuk menghasilkan sumber daya manusia bermutu yang mampu bersaing secara global.', '- Diperlukan karyawan yang memiliki gelar sarjana', 83523333456, 'dipendikbandung.co.id', '2020-04-29 03:17:52', '2020-04-29 03:17:52'),
(6, 3, 'Dinas Pendidikan - Yogyakarta', 'Ketua Bidang', 'Yogyakarta, Jawa Tengah', '5 Juta', 'Pendidikan yang bermutu merupakan tuntutan masyarakat Indonesia sebagai wahana untuk menghasilkan sumber daya manusia bermutu yang mampu bersaing secara global.', '- Diperlukan karyawan yang memiliki gelar sarjana', 81423333456, 'dipendikjogja.co.id', '2020-04-29 03:17:52', '2020-04-29 03:17:52'),
(7, 4, 'PT-KAI', 'Construction Engineering', 'DKI Jakarta', '7 Juta', 'PT-KAI sebuah BUMN yang bekerja pada sektor perkeretaapian', '- Diperlukan karyawan yang memiliki gelar sarjana teknik', 81423333456, 'kai.co.id', '2020-04-29 03:17:52', '2020-04-29 03:17:52'),
(8, 4, 'PT.Pertamina (Persero)', 'Staff Administrasi', 'Surabaya, Jawa Timur', '6 Juta', 'Pertamina atau nama resminya PT Pertamina adalah sebuah BUMN yang bertugas mengelola penambangan minyak dan gas bumi di Indonesia. Pertamina masuk urutan ke 122 dalam Fortune Global 500 pada tahun 2013.', '- Diperlukan karyawan yang memiliki gelar sarjana teknik', 81425333490, 'pertamina.com', '2020-04-29 03:17:52', '2020-04-29 03:17:52'),
(9, 5, 'GOJEK - Jakarta', 'Product Engineer', 'DKI Jakarta', '10 Juta', 'Gojek (sebelumnya ditulis GO-JEK) merupakan sebuah perusahaan teknologi asal Indonesia yang melayani angkutan melalui jasa ojek.', '- Diperlukan karyawan yang memiliki gelar sarjana komputer', 81423333456, 'gojek.co.id', '2020-04-29 03:17:52', '2020-04-29 03:17:52'),
(10, 5, 'Tokopedia - Surabaya', 'Engineering', 'DKI Jakarta', '12 Juta', 'Tokopedia merupakan perusahaan perdagangan elektronik atau sering disebut toko daring. Sejak didirikan pada tahun 2009, Tokopedia telah bertransformasi menjadi sebuah unicorn yang berpengaruh tidak hanya di Indonesia tetapi juga di Asia Tenggara.', '- Diperlukan karyawan yang memiliki gelar sarjana komputer', 83723333451, 'tokopedia.com', '2020-04-29 03:17:52', '2020-04-29 03:17:52'),
(11, 5, 'Bukalapak - South Jakarta', 'Senior Data Scientist - Machine Learning', 'South Jakarta', '17 Juta', 'Bukalapak merupakan perusahaan e-commerce / online marketplace di Indonesia (biasa dikenal juga dengan jaringan toko daring) yang dioperasikan oleh PT. Bukalapak.com sejak tahun 2010.', '- Diperlukan karyawan yang memiliki gelar sarjana komputer', 82723333457, 'bukalapak.com', '2020-04-29 03:17:52', '2020-04-29 03:17:52'),
(12, 6, 'RSUD - Dr.Sutomo', 'Dokter', 'Surabaya, Jawa Timur', '10 Juta', 'RSUD sebuah rumah sakit yang melayani masyarakat yang sedang sakit', '- Diperlukan karyawan yang memiliki gelar sarjana dokter', 81423333456, 'RSUDsutomo.co.id', '2020-04-29 03:17:52', '2020-04-29 03:17:52'),
(13, 6, 'RSU Bunda Jakarta', 'Perawat', 'DKI Jakarta', '6 Juta', 'RSUD sebuah rumah sakit yang melayani masyarakat yang sedang sakit', '- Diperlukan karyawan yang memiliki gelar sarjana keperawatan', 82423333456, 'RSUDbundajakarta.co.id', '2020-04-29 03:17:52', '2020-04-29 03:17:52'),
(14, 7, 'Pengadilan Negeri Yogyakarta', 'Hakim', 'Yogyakarta, Jawa Tengah', '12 Juta', 'Pengadilan Negeri mengurus masyarakat yang terlibat oleh hukum pada suatu negara.', '- Diperlukan karyawan yang memiliki gelar sarjana hukum', 81423333456, 'pnyogya.co.id', '2020-04-29 03:17:52', '2020-04-29 03:17:52'),
(15, 7, 'Pengadilan Negeri Surabaya', 'Hakim', 'Surabaya, Jawa Timur', '15 Juta', 'Pengadilan Negeri mengurus masyarakat yang terlibat oleh hukum pada suatu negara.', '- Diperlukan karyawan yang memiliki gelar sarjana hukum', 82423333451, 'pnsby.co.id', '2020-04-29 03:17:52', '2020-04-29 03:17:52');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sektor`
--

CREATE TABLE `sektor` (
  `id_sektor` bigint(20) UNSIGNED NOT NULL,
  `nama_sektor` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `sektor`
--

INSERT INTO `sektor` (`id_sektor`, `nama_sektor`, `created_at`, `updated_at`) VALUES
(1, 'All', '2020-04-29 03:17:51', '2020-04-29 03:17:51'),
(2, 'Bank', '2020-04-29 03:17:51', '2020-04-29 03:17:51'),
(3, 'Pendidikan', '2020-04-29 03:17:51', '2020-04-29 03:17:51'),
(4, 'Teknik', '2020-04-29 03:17:51', '2020-04-29 03:17:51'),
(5, 'Teknologi', '2020-04-29 03:17:51', '2020-04-29 03:17:51'),
(6, 'Kesehatan', '2020-04-29 03:17:51', '2020-04-29 03:17:51'),
(7, 'Hukum', '2020-04-29 03:17:51', '2020-04-29 03:17:51');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `created_at`, `updated_at`) VALUES
(1, 'Dolly Stanton', 'sstanton@example.org', '$2y$10$3J5ZDjoJIpWOxeeoSHipgOb1CHLXfTJ1Abzxyw72I3b.jaysqoouG', '2020-04-29 03:17:51', '2020-04-29 03:17:51'),
(2, 'Frederic Simonis', 'ykulas@example.org', '$2y$10$7tzwD6.eJez1U5x1SODa/eFRx6Zb6nFGfA8J7Pus5NdNWqTVIUJMK', '2020-04-29 03:17:51', '2020-04-29 03:17:51');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `perusahaan`
--
ALTER TABLE `perusahaan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `perusahaan_sektor_id_foreign` (`sektor_id`);

--
-- Indeks untuk tabel `sektor`
--
ALTER TABLE `sektor`
  ADD PRIMARY KEY (`id_sektor`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `perusahaan`
--
ALTER TABLE `perusahaan`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT untuk tabel `sektor`
--
ALTER TABLE `sektor`
  MODIFY `id_sektor` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `perusahaan`
--
ALTER TABLE `perusahaan`
  ADD CONSTRAINT `perusahaan_sektor_id_foreign` FOREIGN KEY (`sektor_id`) REFERENCES `sektor` (`id_sektor`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
