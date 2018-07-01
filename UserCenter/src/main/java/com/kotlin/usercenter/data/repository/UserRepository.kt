package com.kotlin.usercenter.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.usercenter.data.api.UserApi
import com.kotlin.usercenter.data.protocol.RegisterReq
import rx.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(){
    fun register(mobile: String, pwd: String, vertifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(mobile,pwd,vertifyCode))
    }
}