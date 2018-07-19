package com.kotlin.mall.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.mall.R
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavBar.checkMsgBadgeVisible(true)
        bottomNavBar.checkCartBadge(20)
        Observable.timer(3,TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { bottomNavBar.checkMsgBadgeVisible(true) }
        Observable.timer(6,TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { bottomNavBar.checkCartBadge(0) }
    }
}
