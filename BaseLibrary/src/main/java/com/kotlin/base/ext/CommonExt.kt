package com.kotlin.base.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.base.utils.GlideUtils
import com.kotlin.base.widgets.DefaultTextWatcher
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>,lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(rx.schedulers.Schedulers.io())
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


fun Button.enable(et: EditText, method: () -> Boolean) {
    val btn=this
    et.addTextChangedListener(object :DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            super.onTextChanged(s, start, before, count)
            btn.isEnabled=method()
        }
    })
}

/*
    ImageView加载网络图片
 */
fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}