package com.padc.ecommerce.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.padc.ecommerce.data.vos.CategoryVO
import com.padc.ecommerce.data.vos.ItemVO
import com.padc.ecommerce.persistence.daos.CategoryDao
import com.padc.ecommerce.persistence.daos.ProductDao
import com.padc.ecommerce.persistence.typeconverters.CategoryListConverter
import com.padc.ecommerce.persistence.typeconverters.ProductImageUrlConverter

@Database(
    entities = [ItemVO::class, CategoryVO::class]
    , version = 3
    , exportSchema = false
)
@TypeConverters(ProductImageUrlConverter::class, CategoryListConverter::class)

abstract class EcommerceDB : RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun categoryDao(): CategoryDao

    companion object {

        private val DB_NAME = "SFC-Ecommerce.DB"
        private var INSTANCE: EcommerceDB? = null

        fun getDatabase(context: Context): EcommerceDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, EcommerceDB::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                    .build()
            }
            return INSTANCE!!
        }
    }

    fun isProductEmpty(): Boolean {

        return productDao().getAllProduct().isEmpty()
    }

    fun isCategoryEmpty(): Boolean {

        return categoryDao().getAllCategory().isEmpty()
    }
}