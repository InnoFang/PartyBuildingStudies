package cn.edu.nuc.popularscience

import android.os.Bundle
import android.support.annotation.DrawableRes
import android.view.Gravity
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import cn.edu.nuc.library.base.BaseFragment
import cn.edu.nuc.library.utils.CustomPopupWindow
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * Author: Inno Fang
 * Time: 2017/8/14 21:42
 * Description:
 */
@Route(path = "/pbs_ps_fragment/1")
class PopularScienceFragment : BaseFragment() {

    companion object {
        fun newInstance(): PopularScienceFragment = PopularScienceFragment()
    }

    override val layoutResId: Int = R.layout.ps_fragment

    private val tvTitle by lazy { find<TextView>(R.id.ps_title_text_view) }
    private val wvContent by lazy { find<WebView>(R.id.ps_content_web_view) }
    private val popupWindow by lazy {
        CustomPopupWindow.Builder(activity)
                .setContentView(R.layout.ps_layout_popup)
                .setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .setFocus(true)
                .setOutsideCancel(true)
                .setElevation(3.0F)
                .build()
    }

    override fun createView(savedInstanceState: Bundle?) {


        wvContent.settings.javaScriptEnabled = true
        wvContent.loadUrl("file:///android_asset/ps_content.html")
       // wvContent.addJavascriptInterface(activity, "android")

        tvTitle.setOnClickListener {

            popupWindow.showAtLocation(R.layout.ps_fragment, Gravity.TOP, 0, 200)

            changeTitleNavigationIcon(R.drawable.ps_ic_expand_less)

            popupWindow.setOnClickListener(R.id.ps_content_title_one, {
                tvTitle.text = getString(R.string.ps_pbs_1_title)
                popupWindow.dismiss()
            })
            popupWindow.setOnClickListener(R.id.ps_content_title_two, {
                tvTitle.text = getString(R.string.ps_pbs_2_title)
                popupWindow.dismiss()
            })
            popupWindow.setOnClickListener(R.id.ps_content_title_three, {
                tvTitle.text = getString(R.string.ps_pbs_3_title)
                popupWindow.dismiss()
            })

            popupWindow.setOnDismissListener {
                val contentName = when (tvTitle.text) {
                    getString(R.string.ps_pbs_1_title) -> "ps_pbs_1.jpg"
                    getString(R.string.ps_pbs_2_title) -> "ps_pbs_2.jpg"
                    getString(R.string.ps_pbs_3_title) -> "ps_pbs_3.jpg"
                    else -> ""
                }
                if (contentName != "") {
                    wvContent.loadUrl("javascript:changeContent('$contentName')")
                }
                changeTitleNavigationIcon(R.drawable.ps_ic_expand_more)
            }
        }
    }


    private fun changeTitleNavigationIcon(@DrawableRes id: Int) {
        @Suppress("DEPRECATION")
        val drawable = resources.getDrawable(id)
        drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
        tvTitle.setCompoundDrawables(null, null, null, drawable)
    }
}