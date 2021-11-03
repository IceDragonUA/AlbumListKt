package com.rnd.app.common.base

/**
 * @author Vladyslav Havrylenko
 * @since 09.10.2020
 */
interface AdapterItemClickListener<T> {

    fun onClicked(item: T)

}