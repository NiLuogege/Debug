package com.xianghuanji.plugin_webview.net

import com.xianghuanji.http.base.BaseHttpApi
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

abstract class LuxuryBaseHttpApi : BaseHttpApi(), Interceptor {

    companion object {
        var IMEI = ""
        var userToken = ""

    }


    override fun getFormalBaseUrl(): String {
        return "https://${getFormaUrl()}"
    }

    override fun getTestBaseUrl(): String {
        val envCode = 0
        return if (envCode == 0) {//测试
            getTestBaseUrlByEnv()
        } else {//线上
            formalBaseUrl
        }
    }

    private fun getTestBaseUrlByEnv(): String {
        val testNum =10
        val first = getFormaUrl().indexOf(".")
        return "http://test${testNum}.${getFormaUrl().substring(0, first)}.t.${getFormaUrl().substring(first + 1)}"
    }

    protected abstract fun getFormaUrl(): String

    override fun getInterceptors(): ArrayList<Interceptor> {
        val intors = ArrayList<Interceptor>()
        intors.add(this)
        return intors
    }


    override fun intercept(chain: Interceptor.Chain): Response? {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder
            .addHeader("platform", "saas_android")
            .addHeader("clientFP",
                IMEI
            )
        if (userToken.isNotBlank()) {
            requestBuilder.addHeader("userToken",
                userToken
            )
        }
        return chain.proceed(requestBuilder.build())
    }
}