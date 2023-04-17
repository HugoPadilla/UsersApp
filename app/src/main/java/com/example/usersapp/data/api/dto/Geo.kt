package com.example.usersapp.data.api.dto


import com.google.gson.annotations.SerializedName

data class Geo(
    @SerializedName("lat")
    val lat: String? = "",
    @SerializedName("lng")
    val lng: String? = ""
)