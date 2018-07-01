package com.kotlin.base.injection.component

import android.content.Context
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun context():Context
}