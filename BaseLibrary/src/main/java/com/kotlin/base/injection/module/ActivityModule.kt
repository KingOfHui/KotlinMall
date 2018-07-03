package com.kotlin.base.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/6/28.
 */
@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    fun provideActivity():Activity{
        return this.activity
    }
}