package com.kotlin.usercenter.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.UserService
import javax.inject.Inject
import javax.inject.Named

class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    @field:[Named("service1")]
    lateinit var userService:UserService

    @Inject
    @field:[Named("service2")]
    lateinit var userService2:UserService
    fun register(mobile: String, verifyCode: String, pwd: String) {
        //业务逻辑
        userService.register(mobile, verifyCode, pwd)
                .execute(object : BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                },lifecycleProvider)

    }
    fun register2(mobile: String, verifyCode: String, pwd: String) {
        //业务逻辑
        userService2.register(mobile, verifyCode, pwd)
                .execute(object : BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                },lifecycleProvider)

    }
}