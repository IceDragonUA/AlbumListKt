package com.rnd.app.common.base

import android.content.Context
import android.webkit.WebSettings
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.koin.core.KoinComponent
import java.io.IOException

class HeaderInterceptor(private val context: Context) : Interceptor, KoinComponent {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = getRequestWithAccessToken(chain)
        try {
            return chain.proceed(request)
        } catch (e: Exception) {
            throw e
        }
    }

    private fun getRequestWithAccessToken(
        chain: Interceptor.Chain
    ): Request {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .header("User-Agent", WebSettings.getDefaultUserAgent(context))
            .method(original.method(), original.body())
        return requestBuilder.build()
    }
}
