package com.kotlin.base.widgets

import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.kotlin.base.R

class BottomNavBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {
    private val mCartBadgeItem:TextBadgeItem
    private val mMsgBadgeItem:ShapeBadgeItem
    init {
        //首页
        val homeItem = BottomNavigationItem(R.drawable.btn_nav_home_press, resources.getString(R.string.nav_bar_home))
                .setInactiveIconResource(R.drawable.btn_nav_home_normal)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)
        //分类
        val categoryItem = BottomNavigationItem(R.drawable.btn_nav_category_press, resources.getString(R.string.nav_bar_category))
                .setInactiveIconResource(R.drawable.btn_nav_category_normal)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)
        //购物车
        val cartItem = BottomNavigationItem(R.drawable.btn_nav_cart_press, resources.getString(R.string.nav_bar_cart))
                .setInactiveIconResource(R.drawable.btn_nav_cart_normal)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)
        mCartBadgeItem= TextBadgeItem()
        cartItem.setBadgeItem(mCartBadgeItem)

        //消息
        val messageItem = BottomNavigationItem(R.drawable.btn_nav_msg_press, resources.getString(R.string.nav_bar_msg))
                .setInactiveIconResource(R.drawable.btn_nav_msg_normal)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)
        mMsgBadgeItem= ShapeBadgeItem()
        mMsgBadgeItem.setShape(ShapeBadgeItem.SHAPE_OVAL)
        messageItem.setBadgeItem(mMsgBadgeItem)
        //我的
        val userItem = BottomNavigationItem(R.drawable.btn_nav_user_press, resources.getString(R.string.nav_bar_user))
                .setInactiveIconResource(R.drawable.btn_nav_user_normal)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)
        setMode(BottomNavigationBar.MODE_FIXED)
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        setBarBackgroundColor(R.color.common_white)

        addItem(homeItem)
                .addItem(categoryItem)
                .addItem(cartItem)
                .addItem(messageItem)
                .addItem(userItem)
                .setFirstSelectedPosition(0)
                .initialise()
    }

    public fun checkCartBadge(num: Int) {
        if (num == 0) {
            mCartBadgeItem.hide()
        }else{
            mCartBadgeItem.show()
            mCartBadgeItem.setText("$num")
        }
    }

    public fun checkMsgBadgeVisible(isShow: Boolean) {
        if (isShow) {
            mMsgBadgeItem.show()
        }else{
            mMsgBadgeItem.hide()
        }
    }
}