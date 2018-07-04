package com.kotlin.base.ext

import android.view.View
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseSubscriber
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>,lifecycleProvider: LifecycleProvider<*>) {
    this
            .observeOn(AndroidSchedulers.mainThread())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribe(subscriber)
}
//View的点击事件扩展方法
fun View.onClick(method: () -> Unit) {
    this.setOnClickListener { method() }
}

//
fun <T>Observable<BaseResp<T>>.convert():Observable<T>{
    return this.flatMap(com.kotlin.base.rx.BaseFunc())
}

fun <T>Observable<BaseResp<T>>.convertBoolean():Observable<Boolean>{
    return this.flatMap(com.kotlin.base.rx.BaseFuncBoolean())
}