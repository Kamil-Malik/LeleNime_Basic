package com.lelestacia.lelenimexml.feature_anime.domain.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lelestacia.lelenimexml.core.domain.remote.JikanAPI
import com.lelestacia.lelenimexml.feature_anime.domain.model.AnimeCard

class SeasonAnimePaging(
    private val apiService: JikanAPI
) : PagingSource<Int, AnimeCard>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeCard> {
        return try {
            val apiResponse = apiService.getCurrentSeason(params.key ?: 1)
            println(apiResponse.pagination)
            println(apiResponse.data)
            LoadResult.Page(
                data = apiResponse.data.map {
                    it.toAnimeCard()
                },
                prevKey =
                if (apiResponse.pagination.currentPage == 1) null
                else apiResponse.pagination.currentPage.minus(1),
                nextKey =
                if (apiResponse.pagination.hasNextPage) apiResponse.pagination.currentPage.plus(1)
                else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, AnimeCard>): Int? {
        return state.anchorPosition
    }
}