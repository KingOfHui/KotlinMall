package com.kotlin.base.injection.scope

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@Scope
@MustBeDocumented
@Retention(RUNTIME)
annotation class ActivityScope