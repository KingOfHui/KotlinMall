package com.kotlin.mall.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.mall.R
import com.kotlin.mall.ui.fragment.HomeFragment
import com.kotlin.mall.ui.fragment.MeFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    private val mHomeFragment: HomeFragment by lazy { HomeFragment() }
    private val mCategoryFragment: HomeFragment by lazy { HomeFragment() }
    private val mCartFragment: HomeFragment by lazy { HomeFragment() }
    private val mMsgFragment: HomeFragment by lazy { HomeFragment() }
    private val mMeFragment: MeFragment by lazy { MeFragment() }

    private val mFragmentStack= Stack<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavBar.checkMsgBadgeVisible(false)
        bottomNavBar.checkCartBadge(20)
//        Observable.timer(3, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { bottomNavBar.checkMsgBadgeVisible(true) }
//        Observable.timer(6, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { bottomNavBar.checkCartBadge(0) }

        initFragment()
        changeFragment()
        initBottomNav()
    }

    private fun initFragment() {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.mContainer, mHomeFragment)
        transaction.add(R.id.mContainer, mCategoryFragment)
        transaction.add(R.id.mContainer, mCartFragment)
        transaction.add(R.id.mContainer, mMsgFragment)
        transaction.add(R.id.mContainer, mMeFragment)
        transaction.commit()

        mFragmentStack.add(mHomeFragment)
        mFragmentStack.add(mCategoryFragment)
        mFragmentStack.add(mCartFragment)
        mFragmentStack.add(mMsgFragment)
        mFragmentStack.add(mMeFragment)
    }

    private fun changeFragment(position: Int = 0) {
        val transaction = supportFragmentManager.beginTransaction()
        for (fragment in mFragmentStack) {
            transaction.hide(fragment)
        }
        transaction.show(mFragmentStack[position])
        transaction.commit()
    }

    private fun initBottomNav() {
        bottomNavBar.setTabSelectedListener(object :BottomNavigationBar.OnTabSelectedListener{
            override fun onTabReselected(position: Int) {
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })
    }
}
