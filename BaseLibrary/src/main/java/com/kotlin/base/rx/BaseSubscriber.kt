package com.kotlin.base.rx

import rx.Subscriber

open class BaseSubscriber<T>:Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
    }
}