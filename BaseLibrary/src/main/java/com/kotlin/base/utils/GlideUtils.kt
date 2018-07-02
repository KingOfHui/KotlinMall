package com.kotlin.base.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.kotlin.base.R

/*
    Glide工具类
 */
object GlideUtils {
    fun loadImage(context: Context, url: String, imageView: ImageView) {
        val options: RequestOptions = RequestOptions()
//                .placeholder(R.mipmap.ic_launcher)	//加载成功之前占位图
//                .error(R.mipmap.ic_launcher)	//加载错误之后的错误图
//                .override(400,400)	//指定图片的尺寸
                //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
//                .fitCenter()
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
                .centerCrop()
//                .circleCrop()//指定图片的缩放类型为centerCrop （圆形）
//                .skipMemoryCache(true)	//跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.ALL)	//缓存所有版本的图像
//                .diskCacheStrategy(DiskCacheStrategy.NONE)	//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.DATA)	//只缓存原来分辨率的图片
//                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)	//只缓存最终的图片
        Glide.with(context).load(url).apply(options).into(imageView)
    }

    fun loadImageFitCenter(context: Context, url: String, imageView: ImageView) {
        val options: RequestOptions = RequestOptions().fitCenter()
        Glide.with(context).load(url).apply(options).into(imageView)
    }

    /*
        当fragment或者activity失去焦点或者destroyed的时候，Glide会自动停止加载相关资源，确保资源不会被浪费
     */
    fun loadUrlImage(context: Context, url: String, imageView: ImageView) {
        val options: RequestOptions = RequestOptions()
                .placeholder(R.drawable.default_loading)
                .error(R.drawable.default_loading)
                .centerCrop()
        Glide.with(context).load(url).apply(options).into(
                object : SimpleTarget<Drawable>() {
                    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                        imageView.setImageDrawable(resource)
                    }
                })
    }
}
