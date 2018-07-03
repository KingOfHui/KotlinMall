package com.kotlin.usercenter.injection.component

import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.ui.activity.RegisterActivity
import dagger.Component

/**
 * Created by Administrator on 2018/6/28.
 */
@Component(modules = arrayOf(UserModule::class),dependencies = arrayOf(ActivityComponent::class))
interface UserComponent {
    fun inject(activity:RegisterActivity)
}