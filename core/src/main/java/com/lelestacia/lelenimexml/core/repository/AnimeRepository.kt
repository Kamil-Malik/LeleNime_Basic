package com.lelestacia.lelenimexml.core.repository

import androidx.paging.PagingData
import com.lelestacia.lelenimexml.core.model.local.AnimeEntity
import com.lelestacia.lelenimexml.core.model.remote.anime.AnimeResponse
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    fun seasonAnimePagingData(): Flow<PagingData<AnimeResponse>>
    fun searchAnimeByTitle(query: String): Flow<PagingData<AnimeResponse>>
    suspend fun getNewestAnimeDataByAnimeId(animeId: Int): Flow<AnimeEntity>
    suspend fun getAnimeByAnimeId(animeId: Int): AnimeEntity?
    fun getFavoriteAnime(): List<AnimeEntity>
    fun getAnimeHistory(): Flow<PagingData<AnimeEntity>>
    suspend fun insertAnimeToHistory(animeEntity: AnimeEntity)
    suspend fun updateAnimeFavorite(malID: Int)
}