package com.kotlin.usercenter.injection.module

import com.kotlin.usercenter.service.UserService
import com.kotlin.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 *  Created by Administrator on 2018/6/28.
 */
@Module
class UserModule {
    @Provides
    fun provideUserService(service:UserServiceImpl):UserService{
        return service
    }
}