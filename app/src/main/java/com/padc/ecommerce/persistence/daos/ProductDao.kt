package com.padc.ecommerce.persistence.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.padc.ecommerce.data.vos.ItemVO

@Dao
interface ProductDao {

    @Insert
    fun insertProduct(dataList: MutableList<ItemVO>)

    @Query("SELECT * FROM products")
    fun getAllProduct(): MutableList<ItemVO>

    @Query("SELECT * FROM products WHERE product_id = :id")
    fun getProductByID(id: Int): ItemVO
}