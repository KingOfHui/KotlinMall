package com.kotlin.base.ui.activity

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView

open class BaseMvpActivity<T:BasePresenter<*>>: BaseActivity(),BaseView {
    override fun showLoading() {

    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    lateinit var mPresenter: T
}