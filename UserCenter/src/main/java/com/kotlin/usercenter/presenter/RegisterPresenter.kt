package com.kotlin.usercenter.presenter

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.usercenter.presenter.view.RegisterView

class RegisterPresenter: BasePresenter<RegisterView>() {
    fun register(mobile: String, verifyCode: String) {
        //业务逻辑
        mView.onRegisterResult(true)
    }
}