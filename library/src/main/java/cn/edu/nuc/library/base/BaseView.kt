package cn.edu.nuc.library.base

/**
 * Author: Inno Fang
 * Time: 2017/8/14 15:10
 * Description:
 */

interface BaseView<T> {
    fun setPresenter(presenter: T)
}