package com.stockbit.model

import com.google.gson.annotations.SerializedName

data class CryptoModel(
    @field:SerializedName("Data")
    val data: List<CryptoItem>,
)

data class CryptoItem(
    @field:SerializedName("CoinInfo")
    val coinInfo: CoinInfo?,

    @field:SerializedName("DISPLAY")
    val display: Display?,
)

data class CoinInfo(
    @field:SerializedName("Name")
    val name : String?,

    @field:SerializedName("FullName")
    val fullName : String?
)

data class Display(
    @field:SerializedName("USD")
    val usd : Usd?
)

data class Usd(
    @field:SerializedName("PRICE")
    val price : String?
)