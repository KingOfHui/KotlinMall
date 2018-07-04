package com.kotlin.usercenter.ui.activity

import android.os.Bundle
import com.kotlin.base.common.Appmanager
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.base.widgets.VerifyButton
import com.kotlin.usercenter.R
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    private var pressTime:Long=0

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
        dynamicCodeBtn.setOnVerifyBtnClick(object : VerifyButton.OnVerifyBtnClick {
            override fun onClick() {
                toast("获取验证码")
            }

        })
        dynamicCodeBtn.onClick {
            dynamicCodeBtn.requestSendVerifyNumber()
            mPresenter.register2("", "", "")
        }
    }

    override fun initInjection() {
//        DaggerUserComponent.builder().build().inject(this)
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
            toast(result)
    }

    override fun onBackPressed() {
        val time=System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再按一次退出程序")
            pressTime=time
        }else{
            Appmanager.instance.exitApp(this)
        }
    }
}
