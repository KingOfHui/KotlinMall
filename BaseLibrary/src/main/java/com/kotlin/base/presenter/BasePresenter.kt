package com.kotlin.base.presenter

import com.kotlin.base.presenter.view.BaseView

open class BasePresenter<T:BaseView> {
    lateinit var mView:T

}