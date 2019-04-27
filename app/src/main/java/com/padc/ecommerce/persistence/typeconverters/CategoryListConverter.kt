package com.padc.ecommerce.persistence.typeconverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.ecommerce.data.vos.CategoryVO

class CategoryListConverter {

    @TypeConverter
    fun fromListToJson(list: MutableList<CategoryVO>): String {

        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromJsonToList(json: String): MutableList<CategoryVO> {

        val listType = object : TypeToken<MutableList<CategoryVO>>() {

        }.type

        return Gson().fromJson(json, listType)
    }
}