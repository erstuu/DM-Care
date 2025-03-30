package com.health.dmcare.util

import com.health.dmcare.R
import com.health.dmcare.models.DataCardDiabetes

object GenerateData {
    fun tandaGejalaDiabetes(): List<DataCardDiabetes> {
        return listOf(
            DataCardDiabetes(
                R.drawable.tg_gambar_toilet,
                "Sering kencing",
                "(Poliuri)"
            ),
            DataCardDiabetes(
                R.drawable.tg_gambar_cepat_lapar,
                "Cepat lapar",
                "(Polifagia)"
            ),
            DataCardDiabetes(
                R.drawable.tg_sering_haus,
                "Sering haus",
                "(Polidipsi)"
            ),
        )
    }

    fun detailTandaGejalaDiabetes(): List<DataCardDiabetes> {
        return listOf(
            DataCardDiabetes(
                R.drawable.tg_gambar_toilet,
                "Sering kencing\n(Poliuri)"
            ),
            DataCardDiabetes(
                R.drawable.tg_sering_haus,
                "Sering haus\n(Polidipsi)"
            ),
            DataCardDiabetes(
                R.drawable.tg_gambar_cepat_lapar,
                "Cepat lapar\n(Polifagia)"
            ),
            DataCardDiabetes(
                R.drawable.tg_berat_badan_menurun_cepat,
                "Berat badan menurun"
            ),
            DataCardDiabetes(
                R.drawable.tg_kesemutan,
                "Kesemutan"
            ),
            DataCardDiabetes(
                R.drawable.tg_gatal_daerah_kemaluan,
                "Gatal daerah kemaluan"
            ),
            DataCardDiabetes(
                R.drawable.tg_bisul_hilang_timbul,
                "Bisul hilang timbul"
            ),
            DataCardDiabetes(
                R.drawable.tg_penglihatan_kabur,
                "Pengliahata kabur"
            ),
            DataCardDiabetes(
                R.drawable.tg_cepat_lelah,
                "Cepat lelah"
            ),
            DataCardDiabetes(
                R.drawable.tg_luka_sulit_sembuh,
                "Luka sulit sembuh"
            ),
            DataCardDiabetes(
                R.drawable.tg_keputihan_pada_wanita,
                "Keputihan pada wanita"
            ),
            DataCardDiabetes(
                R.drawable.tg_mudah_mengantuk,
                "Mudah mengantuk"
            ),
            DataCardDiabetes(
                R.drawable.tg_impotensi_paga_pria,
                "Impotensi pada pria"
            ),
        )
    }

    fun bahayaDiabetesMelitusTidakTerkontrol(): List<DataCardDiabetes> {
        return listOf(
            DataCardDiabetes(
                R.drawable.bd_penyakit_kardiovaskuler,
                "Penyakit kardiovaskuler"
            ),
            DataCardDiabetes(
                R.drawable.tg_penglihatan_kabur,
                "Retinopati diabetik"
            ),
            DataCardDiabetes(
                R.drawable.bd_penyakit_neuropati,
                "Neuropati diabetik"
            ),
            DataCardDiabetes(
                R.drawable.bd_penyakit_neropati,
                "Nefropati diabetik"
            ),
        )
    }

    fun faktorDiabetesMelitus(): List<DataCardDiabetes> {
        return listOf(
            DataCardDiabetes(
                R.drawable.fa_berat_badan_berlebih,
                "Berat badan\nberlebih"
            ),
            DataCardDiabetes(
                R.drawable.fa_kurang_aktivitas_fisik,
                "Kurang aktivitas fisik"
            ),
            DataCardDiabetes(
                R.drawable.fa_faktor_keturunan,
                "Faktor keturunan"
            ),
            DataCardDiabetes(
                R.drawable.fa_riwayat_hipertensi,
                "Riwayat hipertensi\n> 140/90 mmHg"
            ),
            DataCardDiabetes(
                R.drawable.fa_riwayat_penyakit_kardiovaskuler,
                "Riwayat penyakit kardiovaskuler"
            ),
            DataCardDiabetes(
                R.drawable.fa_usia_lanjut,
                "Usia lanjut"
            ),
            DataCardDiabetes(
                R.drawable.fa_obesitas_berat,
                "Obesitas berat"
            ),
        )
    }

    fun pengaturanNutrisi(): List<DataCardDiabetes> {
        return listOf(
            DataCardDiabetes(
                R.drawable.pn_batasi_penggunaan_karbohidrat,
                "Batasi penggunaan karbohidrat"
            ),
            DataCardDiabetes(
                R.drawable.pn_hindari_penggunaan_karbohidrat_sederhana,
                "Hindari karbohidrat sederhana"
            ),
            DataCardDiabetes(
                R.drawable.pn_pilih_sumber_protein_rendah_lemak,
                "Sumber protein rendah lemak"
            ),
            DataCardDiabetes(
                R.drawable.pn_pilih_lemak_sehat,
                "Pilih lemak sehat"
            ),
            DataCardDiabetes(
                R.drawable.pn_perhatikan_ukuran_porsi_makanan,
                "Perhatikan porsi makan"
            ),
            DataCardDiabetes(
                R.drawable.pn_konsumsi_makanan_tinggi_serat,
                "Konsumsi makanan tinggi serat"
            ),
        )
    }

    fun aktivitasFisik(): List<DataCardDiabetes> {
        return listOf(
            DataCardDiabetes(
                R.drawable.daf_aerobik,
                "Aerobik"
            ),
            DataCardDiabetes(
                R.drawable.daf_bersepeda,
                "Bersepeda"
            ),
            DataCardDiabetes(
                R.drawable.daf_jogging,
                "Jogging"
            ),
            DataCardDiabetes(
                R.drawable.daf_berenang,
                "Berenang"
            )
        )
    }

    fun perawatanKaki(): List<DataCardDiabetes> {
        return listOf(
            DataCardDiabetes(
                R.drawable.pk_hindari_berjalan_tanpa_alas_kaki,
                "Hindari berjalan tanpa alas kaki"
            ),
            DataCardDiabetes(
                R.drawable.pk_periksa_kaki_apabila_terkelupas,
                "Periksa kaki apabila terkelupas"
            ),
            DataCardDiabetes(
                R.drawable.pk_periksa_alas_kaki_dari_benda_asing,
                "Periksa alas kaki dari benda asing"
            ),
            DataCardDiabetes(
                R.drawable.pk_menjaga_kaki_agar_selalu_bersih,
                "Menjaga kaki agar selalu bersih"
            ),
            DataCardDiabetes(
                R.drawable.pk_memotong_kuku,
                "Memotong kuku"
            ),
            DataCardDiabetes(
                R.drawable.pk_keringkan_kaki_dan_sela_sela_jari_kaki,
                "Keringkan kaki dan sela-sela jari kaki"
            ),
            DataCardDiabetes(
                R.drawable.pk_gunakan_kaos_kaki,
                "Gunakan kaos kaki"
            ),
            DataCardDiabetes(
                R.drawable.pk_jika_ada_mata_ikan,
                "Jika ada mata ikan, tipiskan secara teratur"
            ),
            DataCardDiabetes(
                R.drawable.pk_gunakan_alas_kaki_yang_dibuat_khusus,
                "Gunakan alas kaki yang dibuat khusus"
            ),
            DataCardDiabetes(
                R.drawable.pk_sepatu_tidak_boleh_terlalu_sempit,
                "Sepatu tidak boleh terlalu sempit"
            ),
            DataCardDiabetes(
                R.drawable.pk_hindari_penggunaan_botol_air_panas,
                "Hindari penggunaan botol air panas"
            ),
        )
    }

    fun imageResInt(): List<Int> {
        return listOf(
            R.drawable.fe_1, R.drawable.fe_2, R.drawable.fe_3,
            R.drawable.fe_4, R.drawable.fe_6, R.drawable.fe_7,
            R.drawable.fe_8, R.drawable.fe_9, R.drawable.fe_10,
            R.drawable.fe_11, R.drawable.fe_12, R.drawable.fe_13
        )
    }

    fun description(): List<String> {
        return listOf(
            "Posisikan pasien duduk tegak diatas bangku dengan kaki  menyentuh lantai.",
            "Letakkan tumit di lantai, jari-jari kedua belah kaki diluruskan  keatas lalu dibengkokan kembali ke bawah seperti cakar ayam sebanyak 10 kali",
            "Letakan tumit salah satu kaki di lantai, angkat telapak kaki ke atas pada kaki lainnya, jari-jari kaki diletakan di lantai dengan tumit kaki diangkatkan ke atas. Dilakukan pada kaki kiri dan kanan secara bergantian, diulangi sebanyak 10 kali",
            "Tumit kaki diletakan di lantai. Bagian ujung kaki diangkat keatas dan dibuat gerakan memutar dengan pergerakan pada pergelangan kaki sebanyak 10 kali.",
            "Jari-jari kaki diletakan di lantai. Tumit diangkat dan buat gerakan memutar dengan pergerakan pada pergelangan kaki sebanyak 10 kali.",
            "Angkat salah satu lutut kaki dan luruskan. Gerakan jari-jari kedepan turunkan kembali secara bergantian ke kiri dan kanan ulangi 10 kali.",
            "Angkat kedua kaki lalu luruskan. Ulangi langkah gerakan nomor 6, namun gunakan kedua kaki secara bersamaan ulangi 10 kali.",
            "Angkat kedua kaki dan luruskan. Pertahankan posisi tersebut gerakan pergelangan kaki kedepan dan kebelakang.",
            "Letakan kertas di lantai, kertas dibentuk menjadi bola dengan kedua kaki lalu membuka kertas yang sudah dibentuk bola menjadi kertas. Cara ini dilakukan 1 kali.",
            "Kemudian sobek kertas menjadi 2 bagian, memisahkan kertas menjadi dua bagian",
            "Salah satu kertas disobek jadi kecil menggunakan kedua kaki",
            "Pindahkan sobekan kertas dengan menggunakan kedua kaki, kemudian letakkan dibagian koran yang masih utuh. Bungkus semua kertas membentuk bola dengan menggunakan kedua kaki"
        )
    }
}