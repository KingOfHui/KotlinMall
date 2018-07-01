package com.kotlin.base.presenter.view

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(message:String)
}