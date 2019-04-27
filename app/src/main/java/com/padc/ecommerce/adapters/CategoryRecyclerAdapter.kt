package com.padc.ecommerce.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.padc.ecommerce.R
import com.padc.ecommerce.data.vos.CategoryVO
import com.padc.ecommerce.views.holders.BaseViewHolder
import com.padc.ecommerce.views.holders.CategoryViewHolder

class CategoryRecyclerAdapter(context: Context) : BaseRecyclerAdapter<CategoryViewHolder, CategoryVO>(context) {


    override fun onCreateViewHolder(vg: ViewGroup, position: Int): BaseViewHolder<CategoryVO> {

        val view: View = mLayoutInflator.inflate(R.layout.view_holder_category, vg, false)
        return CategoryViewHolder(view)
    }


}