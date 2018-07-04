package com.kotlin.usercenter.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.UserService
import javax.inject.Inject
import javax.inject.Named

class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    @field:[Named("service1")]
    lateinit var userService: UserService

    //    @Inject
//    @field:[Named("service2")]
//    lateinit var userService2:UserService
    fun register(mobile: String, verifyCode: String, pwd: String) {

        if (!checkNetWork()){
            println("网络不可用")
            return
        }
        mView.showLoading()
        //业务逻辑
        userService.register(mobile, verifyCode, pwd)
                .execute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(if (t) "注册成功" else "注册失败")
                    }
                }, lifecycleProvider)

    }


    fun register2(mobile: String, verifyCode: String, pwd: String) {
        //业务逻辑
        userService.register2(mobile, verifyCode, pwd)
                .execute(object : BaseSubscriber<String>(mView) {
                    override fun onNext(t: String) {
                        mView.onRegisterResult(t)
                    }
                }, lifecycleProvider)

    }

//    fun register2(mobile: String, verifyCode: String, pwd: String) {
//        //业务逻辑
//        userService2.register(mobile, verifyCode, pwd)
//                .execute(object : BaseSubscriber<String>(){
//                    override fun onNext(result: String) {
//                        mView.onRegisterResult(result)
//                    }
//                },lifecycleProvider)
//
//    }
}