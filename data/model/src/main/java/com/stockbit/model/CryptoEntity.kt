package com.stockbit.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CryptoEntity (
    @PrimaryKey
    @SerializedName("id")
    val id: Int?
)