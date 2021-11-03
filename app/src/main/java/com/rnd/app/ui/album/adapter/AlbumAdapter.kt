package com.rnd.app.ui.album.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rnd.app.databinding.ViewAlbumListItemBinding
import com.rnd.domain.model.Album
import kotlin.properties.Delegates


/**
 * @author Vladyslav Havrylenko
 * @since 03.10.2020
 */
@SuppressLint("NotifyDataSetChanged")
class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    var items: List<Album> by Delegates.observable(listOf()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder =
        AlbumViewHolder(ViewAlbumListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): Album = items[position]

    override fun getItemCount(): Int = items.count()

    inner class AlbumViewHolder(private val itemBinding: ViewAlbumListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Album) {
            itemBinding.apply {
                tvTitle.text = item.title
            }
        }
    }
}