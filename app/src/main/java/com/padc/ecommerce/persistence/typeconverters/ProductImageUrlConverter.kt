package com.padc.ecommerce.persistence.typeconverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.ecommerce.data.vos.ProductImageVO

class ProductImageUrlConverter {

    @TypeConverter
    fun fromListToJson(list: MutableList<ProductImageVO>): String {

        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromJsonToList(json: String): MutableList<ProductImageVO> {

        val listType = object : TypeToken<MutableList<ProductImageVO>>() {

        }.type

        return Gson().fromJson(json, listType)
    }
}