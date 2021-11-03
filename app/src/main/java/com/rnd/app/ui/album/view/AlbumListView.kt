package com.rnd.app.ui.album.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.rnd.app.R
import com.rnd.app.common.base.AdapterItemClickListener
import com.rnd.app.ui.album.adapter.AlbumAdapter
import com.rnd.domain.model.Album
import kotlinx.android.synthetic.main.view_album_list.view.*


/**
 * @author Vladyslav Havrylenko
 * @since 27.01.2021
 */
class AlbumListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), AdapterItemClickListener<Album> {

    private var listener: AdapterItemClickListener<Album>? = null

    init {
        inflate(context, R.layout.view_album_list, this)
        albumList.adapter = AlbumAdapter(this)
        albumList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        albumList.setHasFixedSize(true)
        albumList.itemAnimator = null
    }

    fun setListener(listener: AdapterItemClickListener<Album>) {
        this.listener = listener
    }

    fun setItems(list: List<Album>) {
        (albumList.adapter as? AlbumAdapter)?.items = list
    }

    override fun onClicked(item: Album) {
        listener?.onClicked(item)
    }
}