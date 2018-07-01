package com.kotlin.usercenter.service.impl

import com.kotlin.base.ext.convert
import com.kotlin.base.rx.BaseFuncBoolean
import com.kotlin.usercenter.data.repository.UserRepository
import com.kotlin.usercenter.service.UserService
import rx.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {

        return repository.register(mobile, pwd, verifyCode)
                .flatMap(BaseFuncBoolean())
    }

    override fun register2(mobile: String, pwd: String, verifyCode: String): Observable<String> {
        return repository.register(mobile, pwd, verifyCode)
                .convert()
    }
}
