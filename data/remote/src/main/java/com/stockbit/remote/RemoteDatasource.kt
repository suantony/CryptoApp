package com.stockbit.remote

import com.stockbit.model.CryptoItem
import com.stockbit.remote.utils.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Implementation of [ExampleService] interface
 */
class RemoteDatasource(private val cryptoService: CryptoService) {

    val api_key = "e7494ba684e09e61c6bb881b699c0a15e9a5b6c9285365dce57c75e64c2f4fce"
    suspend fun getCryptoData() : Flow<ApiResponse<List<CryptoItem>>>{
        return flow {
            try {
                val response = cryptoService.getCryptoData(50,0, api_key)
                val dataArray = response.data
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.success(body = response.data))
                } else {
                    emit(ApiResponse.empty())
                }
            } catch (e : Exception){
//                Log.wtf("masuk error", e.toString())
//                emit(ApiResponse.error(msg = e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

}