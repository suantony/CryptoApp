package com.stockbit.local.dao

import androidx.room.Dao
import com.stockbit.model.CryptoEntity

@Dao
abstract class ExampleDao: BaseDao<CryptoEntity>() {

//    @Query("SELECT * FROM ExampleModel WHERE name = :name LIMIT 1")
//    abstract suspend fun getExample(name: String): ExampleModel
//
//    suspend fun save(data: ExampleModel) {
//        insert(data)
//    }
//
//    suspend fun save(datas: List<ExampleModel>) {
//        insert(datas)
//    }
}