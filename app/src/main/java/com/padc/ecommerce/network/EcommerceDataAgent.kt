package com.padc.ecommerce.network

import com.padc.ecommerce.delegates.CategoryDataResponseDelegate
import com.padc.ecommerce.delegates.ItemDataResponseDelegate

interface EcommerceDataAgent {

    fun loadCategory(
        accessToken: String,
        page: Int,
        delegate: CategoryDataResponseDelegate
    )

    fun loadItems(
        accessToken: String,
        page: Int,
        delegate: ItemDataResponseDelegate
    )
}