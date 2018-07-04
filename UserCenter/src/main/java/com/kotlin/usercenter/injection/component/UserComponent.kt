package com.kotlin.usercenter.injection.component

import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.scope.PerComponentScope
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.ui.activity.RegisterActivity
import dagger.Component

@PerComponentScope
@Component(modules = arrayOf(UserModule::class),dependencies = arrayOf(ActivityComponent::class))
interface UserComponent {
    fun inject(registerActivity: RegisterActivity)

}