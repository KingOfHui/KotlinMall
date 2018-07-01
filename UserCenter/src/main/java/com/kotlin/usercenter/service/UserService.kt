package com.kotlin.usercenter.service

import rx.Observable

interface UserService {
    fun register(mobile:String,pwd:String,verifyCode:String): Observable<Boolean>
    fun register2(mobile:String,pwd:String,verifyCode:String): Observable<String>
}