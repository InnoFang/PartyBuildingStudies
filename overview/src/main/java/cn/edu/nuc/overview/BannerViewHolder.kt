package cn.edu.nuc.overview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.zhouwei.mzbanner.holder.MZViewHolder

/**
 * Author: Inno Fang
 * Time: 2017/8/18 13:15
 * Description:
 */

class BannerViewHolder:MZViewHolder<Int> {

    private lateinit var imageView: ImageView

    override fun createView(context: Context?): View {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.ov_layout_banner_item, null)
        imageView = view.findViewById(R.id.banner_image_view) as ImageView
        return view
    }

    override fun onBind(context: Context?, pos: Int, data: Int?) {
       imageView.setImageResource(data!!)
    }


}