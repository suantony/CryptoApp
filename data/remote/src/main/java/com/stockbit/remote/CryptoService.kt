package com.stockbit.remote

import com.stockbit.model.CryptoModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoService {

    @GET("data/top/totalvolfull?tsym=USD")
    suspend fun getCryptoData(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("api_key") api_key: String,
    ): CryptoModel

}