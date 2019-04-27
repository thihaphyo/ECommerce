package com.padc.ecommerce.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.Nullable
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products")
data class ItemVO(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pid_auto_inc")
    val pidAutoIncrement: Int,

    @ColumnInfo(name = "product_id")
    @SerializedName("product_id")
    val productID: Int,

    @ColumnInfo(name = "product_name")
    @SerializedName("product_name")
    val productName: String,

    @SerializedName("product_image_url")
    val productImageUrl: MutableList<ProductImageVO>,

    @ColumnInfo(name = "product_desc")
    @SerializedName("product_desc")
    val desc: String,

    @ColumnInfo(name = "product_price")
    @SerializedName("product_price")
    val price: String,

    @SerializedName("category")
    val category: MutableList<CategoryVO>,

    @ColumnInfo(name = "uploaded_time")
    @SerializedName("uploaded_time")
    val uploadedTime: String? = "",

    @ColumnInfo(name = "uploaded_date")
    @SerializedName("uploaded_date")
    val uploadedDate: String? = "",

    @Embedded(prefix = "seller_")
    @SerializedName("seller")
    val seller: SellerVO,

    @ColumnInfo(name = "availability")
    @SerializedName("availability")
    val availability: Boolean
) {

    fun getHighLightImage(): String {

        if (productImageUrl.isNotEmpty()) {

            return productImageUrl[0].imageUrl
        }

        return ""
    }
}