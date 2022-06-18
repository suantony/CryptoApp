package com.stockbit.repository

import com.stockbit.local.dao.ExampleDao
import com.stockbit.model.CryptoItem
import com.stockbit.remote.RemoteDatasource
import com.stockbit.remote.utils.StatusResponse
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface CryptoRepository {
    fun getCryptoData(): Flow<Resource<List<CryptoItem>>>
}

class CryptoRepositoryImpl(private val datasource: RemoteDatasource,
                            private val dao: ExampleDao): CryptoRepository {

    override fun getCryptoData(): Flow<Resource<List<CryptoItem>>> {
        return flow {
            emit(Resource.loading(null))
            val result = datasource.getCryptoData().first()
            when (result.status){
                StatusResponse.SUCCESS ->{
                    emit(Resource.success(result.body))
                }
                StatusResponse.EMPTY -> {
                    emit(Resource.empty(null))
                }
                StatusResponse.ERROR -> {
                    emit(Resource.error(result.message, null))
                }
            }
        }.flowOn(Dispatchers.IO)
    }

}