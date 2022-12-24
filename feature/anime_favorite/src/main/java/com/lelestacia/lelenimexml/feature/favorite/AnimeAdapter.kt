package com.lelestacia.lelenimexml.feature.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.lelestacia.lelenimexml.core.model.local.AnimeEntity
import com.lelestacia.lelenimexml.feature.anime.R
import com.lelestacia.lelenimexml.feature.favorite.databinding.ItemListAnimeBinding

class AnimeAdapter() :
    ListAdapter<AnimeEntity, AnimeAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(private val binding: ItemListAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AnimeEntity) {
            binding.apply {
                val context = root.context
                ivCoverAnime.load(item.coverImages) {
                    transformations(RoundedCornersTransformation(15f))
                    build()
                }
                tvTitleAnime.text = item.title
                tvStatusAnime.text = item.status
                tvRatingAnime.text = context
                    .getString(R.string.rating_item_anime, item.score ?: "Unknown")
                tvEpisodeAnime.text = context
                    .getString(R.string.episode_item_anime, item.episodes ?: "Unknown")
                tvStatusAnime.text = context
                    .getString(R.string.status_item_anime, item.status)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { anime ->
            holder.bind(anime)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<AnimeEntity>() {
            override fun areItemsTheSame(oldItem: AnimeEntity, newItem: AnimeEntity): Boolean =
                oldItem.malId == newItem.malId

            override fun areContentsTheSame(oldItem: AnimeEntity, newItem: AnimeEntity): Boolean =
                oldItem == newItem
        }
    }
}