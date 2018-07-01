package com.kotlin.usercenter.injection.module

import com.kotlin.base.injection.scope.PerComponentScope
import com.kotlin.usercenter.service.UserService
import com.kotlin.usercenter.service.impl.UserServiceImpl
import com.kotlin.usercenter.service.impl.UserServiceImpl2
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UserModule {
    @Provides
    @PerComponentScope
    @Named("service1")
    fun provideUserService(service:UserServiceImpl): UserService {
        return service
    }
    @Provides
    @PerComponentScope
    @Named("service2")
    fun provideUserService2(service:UserServiceImpl2): UserService {
        return service
    }
}