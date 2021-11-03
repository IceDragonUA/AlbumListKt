package com.rnd.app.extension

import android.webkit.WebSettings
import android.widget.ImageView
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.evaluation.glide.GlideApp

/**
 * @author Vladyslav Havrylenko
 * @since 24.12.2020
 */
fun ImageView.loadFromUrl(url: String) {
    GlideApp.with(this.context.applicationContext)
        .load(
            GlideUrl(
                url,
                LazyHeaders.Builder()
                    .addHeader("User-Agent", WebSettings.getDefaultUserAgent(context))
                    .build()
            )
        )
        .into(this)
}