package com.example.authorslist.model

import com.google.gson.annotations.SerializedName

data class Authors(

    @SerializedName("id") // bagian yang atas ini buat akses json
    val id: Int,

    @SerializedName("email")
    val email: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("avatar")
    val avatar: String

    )
