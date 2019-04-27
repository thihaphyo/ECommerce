package com.padc.ecommerce.delegates

import com.padc.ecommerce.data.vos.ItemVO

interface ItemActionDelegate {

    fun onClickItem(item: ItemVO)
}