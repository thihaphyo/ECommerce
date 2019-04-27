package com.padc.ecommerce.data.models

import com.padc.ecommerce.data.vos.ItemVO

interface ItemModel {

    fun loadProducts(
        accessToken: String,
        page: Int,
        delegate: ProductDelegate
    ): MutableList<ItemVO> ?

    fun getProductByID(id:Int) : ItemVO?

    interface ProductDelegate {

        fun onSuccess(data: MutableList<ItemVO>)

        fun onFail(err: String)
    }
}