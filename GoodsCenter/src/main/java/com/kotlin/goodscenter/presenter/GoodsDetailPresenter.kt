package com.kotlin.goodscenter.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.goodscenter.data.protocol.Goods
import com.kotlin.goodscenter.presenter.view.GoodsDetailView
import com.kotlin.goodscenter.service.GoodsService
import javax.inject.Inject

/*
    商品详情 Presenter
 */
class GoodsDetailPresenter @Inject constructor() : BasePresenter<GoodsDetailView>() {

    @Inject
    lateinit var goodsService: GoodsService

    /*
        获取商品详情
     */
    fun getGoodsDetailList(goodsId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsDetail(goodsId).execute(object : BaseSubscriber<Goods>(mView) {
            override fun onNext(t: Goods) {
                    mView.onGetGoodsDetailResult(t)
            }
        }, lifecycleProvider)

    }

    /*
        加入购物车
     */
//    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
//                           goodsCount: Int, goodsSku: String) {
//        if (!checkNetWork()) {
//            return
//        }
//        mView.showLoading()
//        cartService.addCart(goodsId,goodsDesc,goodsIcon,goodsPrice,
//                goodsCount,goodsSku).excute(object : BaseSubscriber<Int>(mView) {
//            override fun onNext(t: Int) {
//                AppPrefsUtils.putInt(GoodsConstant.SP_CART_SIZE,t)
//                mView.onAddCartResult(t)
//            }
//        }, lifecycleProvider)
//
//    }

}
