package com.rnd.app.ui.photo.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.rnd.app.R
import com.rnd.app.common.base.AdapterItemClickListener
import com.rnd.app.ui.photo.adapter.PhotoAdapter
import com.rnd.domain.model.Photo
import kotlinx.android.synthetic.main.view_photo_list.view.*


/**
 * @author Vladyslav Havrylenko
 * @since 27.01.2021
 */
class PhotoListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), AdapterItemClickListener<Photo> {

    private var listener: AdapterItemClickListener<Photo>? = null

    init {
        inflate(context, R.layout.view_photo_list, this)
        photoList.adapter = PhotoAdapter(this)
        photoList.layoutManager = GridLayoutManager(context, 2)
        photoList.setHasFixedSize(true)
        photoList.itemAnimator = null
    }

    fun setListener(listener: AdapterItemClickListener<Photo>) {
        this.listener = listener
    }

    fun setItems(list: List<Photo>) {
        (photoList.adapter as? PhotoAdapter)?.items = list
    }

    override fun onClicked(item: Photo) {
        listener?.onClicked(item)
    }
}