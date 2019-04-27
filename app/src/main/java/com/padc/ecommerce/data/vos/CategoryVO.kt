package com.padc.ecommerce.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "category")
data class CategoryVO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id_auto")
    val catIDPK: Int,
    @SerializedName("category_id")
    @ColumnInfo(name = "category_id")
    val catID: Int,
    @SerializedName("category_name")
    @ColumnInfo(name = "category_name")
    val catName: String,
    @SerializedName("category_icon")
    @ColumnInfo(name = "category_icon")
    val icon: String,
    @SerializedName("category_color")
    @ColumnInfo(name = "category_color")
    val color: String
)