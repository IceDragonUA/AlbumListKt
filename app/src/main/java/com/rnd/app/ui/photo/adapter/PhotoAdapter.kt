package com.rnd.app.ui.photo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rnd.app.common.base.AdapterItemClickListener
import com.rnd.app.databinding.ViewPhotoListItemBinding
import com.rnd.app.extension.loadFromUrl
import com.rnd.domain.model.Photo
import kotlin.properties.Delegates


/**
 * @author Vladyslav Havrylenko
 * @since 03.10.2020
 */
@SuppressLint("NotifyDataSetChanged")
class PhotoAdapter(private val listener: AdapterItemClickListener<Photo>? = null) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    var items: List<Photo> by Delegates.observable(listOf()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder(
            ViewPhotoListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): Photo = items[position]

    override fun getItemCount(): Int = items.count()

    inner class PhotoViewHolder(private val itemBinding: ViewPhotoListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Photo) {
            itemBinding.apply {
                ivThumb.loadFromUrl(item.thumbnailUrl)
                itemView.setOnClickListener {
                    listener?.onClicked(item)
                }
            }
        }
    }
}