package com.lelestacia.lelenimexml.feature.anime.domain.usecase

import androidx.paging.PagingData
import com.lelestacia.lelenimexml.core.model.local.AnimeEntity
import com.lelestacia.lelenimexml.feature.anime.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeUseCase {
    fun getAiringAnime(): Flow<PagingData<Anime>>
    fun getAnimeByTitle(query: String): Flow<PagingData<Anime>>
    suspend fun getAnimeByAnimeId(animeId: Int): AnimeEntity?


    suspend fun getAnimeByMalID(animeId: Int): Flow<Anime>



    fun getAnimeHistory(): Flow<PagingData<Anime>>
    suspend fun insertOrUpdateNewAnimeToHistory(anime: Anime)
    suspend fun updateAnimeFavorite(malID: Int)
}