package com.kotlin.usercenter.ui.activity

import android.os.Bundle
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initInjection()
        mPresenter.mView=this
        registerBtn.setOnClickListener {
//            startActivity(intentFor<LoginActivity>("id" to 5))
//            startActivity<LoginActivity>("id" to 10)
            mPresenter.register(mobileEt.text.toString(), verifyCodeEt.text.toString(),pwdEt.text.toString())
        }
    }

    private fun initInjection() {
        DaggerUserComponent.builder().build().inject(this)
    }

    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }
}
