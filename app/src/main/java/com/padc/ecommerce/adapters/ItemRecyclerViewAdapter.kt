package com.padc.ecommerce.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.padc.ecommerce.R
import com.padc.ecommerce.data.vos.ItemVO
import com.padc.ecommerce.delegates.ItemActionDelegate
import com.padc.ecommerce.views.holders.BaseViewHolder
import com.padc.ecommerce.views.holders.ItemViewHolder

class ItemRecyclerViewAdapter(

    context: Context,
    private val actionDelegate: ItemActionDelegate

) : BaseRecyclerAdapter<ItemViewHolder, ItemVO>(context) {


    override fun onCreateViewHolder(vg: ViewGroup, position: Int): BaseViewHolder<ItemVO> {

        val view: View = mLayoutInflator.inflate(R.layout.view_holder_items, vg, false)
        return ItemViewHolder(view, actionDelegate)

    }

}