package com.padc.ecommerce.network.responses

import com.google.gson.annotations.SerializedName
import com.padc.ecommerce.data.vos.ItemVO

data class ItemResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("apiVersion") val apiVersion: String,
    @SerializedName("page") val page: String,
    @SerializedName("products") val productList: MutableList<ItemVO>
) {

    fun isResponseSuccess(): Boolean {

        return code == 200 && !productList.isEmpty()
    }
}