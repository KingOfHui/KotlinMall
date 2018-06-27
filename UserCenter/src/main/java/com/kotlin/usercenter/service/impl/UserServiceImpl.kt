package com.kotlin.usercenter.service.impl

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseException
import com.kotlin.usercenter.data.repository.UserRepository
import com.kotlin.usercenter.service.UserService
import rx.Observable
import rx.functions.Func1

class UserServiceImpl : UserService {
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        val repository = UserRepository()

        return repository.register(mobile, pwd, verifyCode).flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {
            override fun call(t: BaseResp<String>?): Observable<Boolean> {
                if (t!!.status != 0) {
                    return Observable.error(BaseException(t.status,t.message))
                }
                return Observable.just(true)
            }

        })
    }
}