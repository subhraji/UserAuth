package com.example.userauth.model.pojo


import com.google.gson.annotations.SerializedName

data class SignUpModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
)