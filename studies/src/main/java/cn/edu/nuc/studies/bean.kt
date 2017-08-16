package cn.edu.nuc.studies

import android.support.annotation.StringRes
import java.io.Serializable

/**
 * Author: Inno Fang
 * Time: 2017/8/15 11:33
 * Description:
 */

class PageModel(@StringRes val titleRes: Int,
                val url: String,
                val host: String = "http://www.gapp.gov.cn")

data class ArticleItem(var title: String, var link: String): Serializable