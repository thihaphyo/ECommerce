package com.padc.ecommerce.views.holders

import android.view.View
import com.bumptech.glide.Glide
import com.padc.ecommerce.R
import com.padc.ecommerce.data.vos.ItemVO
import com.padc.ecommerce.delegates.ItemActionDelegate
import kotlinx.android.synthetic.main.view_holder_items.view.*

class ItemViewHolder(

    itemView: View,
    private val mDeleagete: ItemActionDelegate

) : BaseViewHolder<ItemVO>(itemView) {


    override fun setData(data: ItemVO) {

        mData = data

        itemView.tvItemName.text = data.productName

        Glide.with(itemView.context)
            .load(data.getHighLightImage())
            .into(itemView.ivCat)

        if (data.availability) {

            itemView.btnLike.setImageResource(R.drawable.ic_favorite_black_24dp)
        } else {

            itemView.btnLike.setImageResource(R.drawable.ic_favorite_red_24dp)

        }

        itemView.tvPrice.text = data.price


    }

    override fun onClick(v: View?) {

        mDeleagete.onClickItem(mData!!)
    }
}