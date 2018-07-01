package com.kotlin.usercenter.ui.activity

import android.os.Bundle
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
//        mPresenter=RegisterPresenter()
        initInjection()

        registerBtn.setOnClickListener {
            //            startActivity(intentFor<LoginActivity>("id" to 5))
//            startActivity<LoginActivity>("id" to 10)
            mPresenter.register(mobileEt.text.toString(), verifyCodeEt.text.toString(), pwdEt.text.toString())
        }
//        dynamicCodeBtn.setOnClickListener {
//            mPresenter.register2("", "", "")
//        }
        dynamicCodeBtn.onClick { mPresenter.register2("", "", "") }
    }

    override fun initInjection() {
//        DaggerUserComponent.builder().build().inject(this)
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
            toast(result)
    }
}
