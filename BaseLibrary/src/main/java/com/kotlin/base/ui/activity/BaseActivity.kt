package com.kotlin.base.ui.activity

import android.os.Bundle
import com.kotlin.base.common.Appmanager
import com.trello.rxlifecycle.components.support.RxAppCompatActivity


open class BaseActivity : RxAppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Appmanager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        Appmanager.instance.finishActivity(this)
    }
}
