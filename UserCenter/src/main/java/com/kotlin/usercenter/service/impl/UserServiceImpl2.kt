package com.kotlin.usercenter.service.impl

import com.kotlin.usercenter.data.repository.UserRepository
import com.kotlin.usercenter.service.UserService
import rx.Observable
import javax.inject.Inject

class UserServiceImpl2 @Inject constructor() : UserService {
    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {

//        return repository.register(mobile, pwd, verifyCode).flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {
//            override fun call(t: BaseResp<String>?): Observable<Boolean> {
//                if (t!!.status != 0) {
//                    return Observable.error(BaseException(t.status, t.message))
//                }
//                return Observable.just(false)
//            }
//
//        })
                return Observable.just(false)
    }
}