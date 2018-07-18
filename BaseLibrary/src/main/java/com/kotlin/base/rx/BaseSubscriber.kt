package com.kotlin.base.rx

import com.kotlin.base.presenter.view.BaseView
import rx.Subscriber

open class BaseSubscriber<T>(val  mBaseView:BaseView):Subscriber<T>() {
    override fun onNext(t: T) {
        mBaseView.hideLoading()
    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
        mBaseView.hideLoading()
//        if (e is BaseException) {
        if (e != null) {
            mBaseView.onError(e.message!!)
        }
//        }
    }
}