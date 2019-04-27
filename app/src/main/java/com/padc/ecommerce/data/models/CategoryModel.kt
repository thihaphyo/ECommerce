package com.padc.ecommerce.data.models

import com.padc.ecommerce.data.vos.CategoryVO

interface CategoryModel {

    fun loadCategory(
        accessToken: String,
        page: Int,
        delegate: CategoryDelegate
    ): MutableList<CategoryVO> ?

    interface CategoryDelegate {

        fun onSuccess(data: MutableList<CategoryVO>)

        fun onFail(err: String)
    }
}