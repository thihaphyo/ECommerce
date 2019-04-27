package com.padc.ecommerce.data.vos

import com.google.gson.annotations.SerializedName

data class ProductImageVO(

    @SerializedName("id") val id: Int,
    @SerializedName("image_url") val imageUrl: String
)