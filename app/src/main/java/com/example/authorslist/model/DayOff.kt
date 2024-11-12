package com.example.authorslist.model

import com.google.gson.annotations.SerializedName

data class DayOff (
    @SerializedName("tanggal")
    val tanggal: String,

    @SerializedName("keterangan")
    val keterangan: String,

    @SerializedName("isi_cuti")
    val isiCuti: Boolean
)