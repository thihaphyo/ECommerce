package com.padc.ecommerce.views.holders

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v4.widget.ImageViewCompat
import android.view.View
import com.bumptech.glide.Glide
import com.padc.ecommerce.data.vos.CategoryVO
import kotlinx.android.synthetic.main.view_holder_category.view.*

class CategoryViewHolder(itemView: View) : BaseViewHolder<CategoryVO>(itemView) {

    override fun setData(data: CategoryVO) {

        mData = data
        Glide.with(itemView.context)
            .load(data.icon)
            .into(itemView.ivCat)

        ImageViewCompat.setImageTintMode(itemView.ivCat, PorterDuff.Mode.SRC_ATOP);
        ImageViewCompat.setImageTintList(itemView.ivCat, ColorStateList.valueOf(Color.parseColor(data.color)))

        itemView.tvCatText.text = data.catName

    }

    override fun onClick(v: View?) {

    }
}