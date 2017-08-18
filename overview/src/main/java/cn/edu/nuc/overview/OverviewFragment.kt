package cn.edu.nuc.overview

import android.os.Bundle
import android.webkit.WebView
import cn.edu.nuc.library.base.BaseFragment
import cn.edu.nuc.library.extensions.toast
import com.zhouwei.mzbanner.MZBannerView

/**
 * Author: Inno Fang
 * Time: 2017/8/18 12:55
 * Description:
 */

class OverviewFragment : BaseFragment() {

    companion object {
        fun newInstance(): OverviewFragment = OverviewFragment()
    }

    private val res = intArrayOf(
            R.drawable.banner_1,
            R.drawable.banner_2,
            R.drawable.banner_3,
            R.drawable.banner_4,
            R.drawable.banner_5)

    private val banner by lazy { find<MZBannerView<Int>>(R.id.banner) }
    private val wvContent by lazy { find<WebView>(R.id.content_web_view) }

    override val layoutResId: Int = R.layout.ov_fragment

    override fun createView(savedInstanceState: Bundle?) {
        banner.setBannerPageClickListener { _, pos -> toast("click page $pos") }
        banner.setPages(res.toMutableList()) { BannerViewHolder() }

        wvContent.settings.javaScriptEnabled = true
        wvContent.loadUrl("file:///android_asset/ov_index.html")
    }

    override fun onPause() {
        super.onPause()
        banner.pause()
    }

    override fun onResume() {
        super.onResume()
        banner.start()
    }

}