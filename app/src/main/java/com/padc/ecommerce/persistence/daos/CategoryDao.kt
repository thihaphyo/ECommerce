package com.padc.ecommerce.persistence.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.padc.ecommerce.data.vos.CategoryVO

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(categoryList: MutableList<CategoryVO>)

    @Query("SELECT * FROM category")
    fun getAllCategory(): MutableList<CategoryVO>
}