package com.freshworks.giphy.adapters

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.freshworks.giphy.R
import com.freshworks.giphy.databinding.GifItemBinding
import com.freshworks.giphy.repository.model.GiphyModel

class GiphyItemListAdapter(private val callback: (model: GiphyModel, isFavorite: Boolean) -> Unit): ListAdapter<GiphyModel, GiphyItemListAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GifItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, callback)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewRecycled(holder: ViewHolder) {
        holder.recycle()
    }

    class DiffCallback: DiffUtil.ItemCallback<GiphyModel>(){
        override fun areItemsTheSame(oldItem: GiphyModel, newItem: GiphyModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: GiphyModel, newItem: GiphyModel) =
            oldItem.title == newItem.title && oldItem.path == newItem.path && oldItem.isFavorite == newItem.isFavorite
    }

    class ViewHolder(private val binding: GifItemBinding, private val callback: (model: GiphyModel, isFavorite: Boolean) -> Unit)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GiphyModel) {

            binding.apply {
                Glide.with(itemView.context)
                    .load(item.path)
                    .error(ColorDrawable(Color.GREEN))
                    .fallback(ColorDrawable(Color.GREEN))
                    .fitCenter()
                    .into(gifItemContent)

                gifItemTitle.text = item.title
                gifItemFavorite.setImageDrawable(ContextCompat.getDrawable(itemView.context, if(item.isFavorite) R.drawable.ic_favorite else R.drawable.ic_unfavorite))
                gifItemFavorite.setOnClickListener {
                    callback.invoke(item, !item.isFavorite)
                }
            }
        }

        fun recycle() {
            Glide.with(binding.root.context).clear(binding.gifItemContent)
        }
    }
}