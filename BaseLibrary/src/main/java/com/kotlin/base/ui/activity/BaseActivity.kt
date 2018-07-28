package com.kotlin.base.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.kotlin.base.common.Appmanager
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import org.jetbrains.anko.find


open class BaseActivity : RxAppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Appmanager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        Appmanager.instance.finishActivity(this)
    }
    //获取Window中视图content
    val contentView: View
        get() {
            val content = find<FrameLayout>(android.R.id.content)
            return content.getChildAt(0)
        }
}
