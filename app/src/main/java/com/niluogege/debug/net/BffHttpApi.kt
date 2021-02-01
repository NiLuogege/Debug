package com.niluogege.debug.net

import com.xianghuanji.plugin_webview.net.LuxuryBaseHttpApi

/**
 * @FileName TestHttpApi
 * @Description
 * @Author wangwei
 * @Date 2020/9/22
 */
open class BffHttpApi : LuxuryBaseHttpApi() {

    companion object {
        val instance: BffHttpApi by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            BffHttpApi()
        }
    }

    override fun getFormaUrl(): String {
        return "bff-s.xianghuanji.com"
    }
}