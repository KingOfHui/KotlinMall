package com.kotlin.base.injection.component

import android.app.Activity
import android.content.Context
import com.kotlin.base.injection.module.ActivityModule
import dagger.Component

/**
 *  Created by Administrator on 2018/6/28.
 */
@Component(modules = arrayOf(ActivityModule::class),dependencies = arrayOf(AppComponent::class))
interface ActivityComponent {

    fun getActivity(): Activity

    fun context():Context
}