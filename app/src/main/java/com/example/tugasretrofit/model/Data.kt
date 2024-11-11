package com.example.tugasretrofit.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("data")
    val data: List<User>
)
