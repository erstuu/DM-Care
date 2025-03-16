package com.health.dmcare.util

import com.health.dmcare.R
import com.health.dmcare.models.TandaGejalaDiabetes

object GenerateData {
    fun tandaGejalaDiabetes(): List<TandaGejalaDiabetes> {
        return listOf(
            TandaGejalaDiabetes(
                R.drawable.tg_gambar_toilet,
                "Sering kencing",
                "(Poliuri)"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_gambar_cepat_lapar,
                "Cepat lapar",
                "(Polifagia)"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_sering_haus,
                "Sering haus",
                "(Polidipsi)"
            ),
        )
    }

    fun detailTandaGejalaDiabetes(): List<TandaGejalaDiabetes> {
        return listOf(
            TandaGejalaDiabetes(
                R.drawable.tg_gambar_toilet,
                "Sering kencing\n(Poliuri)"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_sering_haus,
                "Sering haus\n(Polidipsi)"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_gambar_cepat_lapar,
                "Cepat lapar\n(Polifagia)"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_berat_badan_menurun_cepat,
                "Berat badan menurun"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_kesemutan,
                "Kesemutan"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_gatal_daerah_kemaluan,
                "Gatal daerah kemaluan"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_bisul_hilang_timbul,
                "Bisul hilang timbul"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_penglihatan_kabur,
                "Pengliahata kabur"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_cepat_lelah,
                "Cepat lelah"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_luka_sulit_sembuh,
                "Luka sulit sembuh"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_keputihan_pada_wanita,
                "Keputihan pada wanita"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_mudah_mengantuk,
                "Mudah mengantuk"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_impotensi_paga_pria,
                "Impotensi pada pria"
            ),
        )
    }

    fun bahayaDiabetesMelitusTidakTerkontrol(): List<TandaGejalaDiabetes> {
        return listOf(
            TandaGejalaDiabetes(
                R.drawable.bd_penyakit_kardiovaskuler,
                "Penyakit kardiovaskuler"
            ),
            TandaGejalaDiabetes(
                R.drawable.tg_penglihatan_kabur,
                "Retinopati diabetik"
            ),
            TandaGejalaDiabetes(
                R.drawable.bd_penyakit_neuropati,
                "Neuropati diabetik"
            ),
            TandaGejalaDiabetes(
                R.drawable.bd_penyakit_neropati,
                "Neronopati diabetik"
            ),
        )
    }

    fun faktorDiabetesMelitus(): List<TandaGejalaDiabetes> {
        return listOf(
            TandaGejalaDiabetes(
                R.drawable.fa_berat_badan_berlebih,
                "Bera badan\nberlebih"
            ),
            TandaGejalaDiabetes(
                R.drawable.fa_kurang_aktivitas_fisik,
                "Kurang aktivitas fisik"
            ),
            TandaGejalaDiabetes(
                R.drawable.fa_faktor_keturunan,
                "Faktor keturunan"
            ),
            TandaGejalaDiabetes(
                R.drawable.fa_riwayat_hipertensi,
                "Riwat hipertensi\n> 140/90 mmHg"
            ),
            TandaGejalaDiabetes(
                R.drawable.fa_riwayat_penyakit_kardiovaskuler,
                "Riwat penyakit kardiovaskuler"
            ),
            TandaGejalaDiabetes(
                R.drawable.fa_usia_lanjut,
                "Usia lanjut"
            ),
            TandaGejalaDiabetes(
                R.drawable.fa_obesitas_berat,
                "Obeistas berat"
            ),
        )
    }
}