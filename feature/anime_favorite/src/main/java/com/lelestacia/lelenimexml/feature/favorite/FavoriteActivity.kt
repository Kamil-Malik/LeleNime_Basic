package com.lelestacia.lelenimexml.feature.favorite

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lelestacia.lelenimexml.core.model.local.AnimeEntity
import com.lelestacia.lelenimexml.feature.favorite.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private val binding: ActivityFavoriteBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.mToolbar)
        supportActionBar?.title = "Favorite Anime"
        val favoriteAdapter = AnimeAdapter()
        val data  = intent.getBundleExtra("DATA")
        val arr = data?.getParcelableArray("DATA") ?: emptyArray()

        val myLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.rvAnime.apply {
            layoutManager = myLayoutManager
            adapter = favoriteAdapter
            addItemDecoration(DividerItemDecoration(context, myLayoutManager.orientation))
            setHasFixedSize(true)
        }

        favoriteAdapter.submitList(arr.toList() as List<AnimeEntity>)
    }
}