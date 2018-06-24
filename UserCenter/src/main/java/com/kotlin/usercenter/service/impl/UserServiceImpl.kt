package com.kotlin.usercenter.service.impl

import com.kotlin.usercenter.service.UserService
import rx.Observable

class UserServiceImpl:UserService {
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }
}