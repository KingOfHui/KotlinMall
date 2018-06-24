package com.kotlin.usercenter.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.impl.UserServiceImpl

class RegisterPresenter : BasePresenter<RegisterView>() {
    fun register(mobile: String, verifyCode: String, pwd: String) {
        //业务逻辑
        val userService = UserServiceImpl()
        userService.register(mobile, verifyCode, pwd)
                .execute(object : BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })
    }
}