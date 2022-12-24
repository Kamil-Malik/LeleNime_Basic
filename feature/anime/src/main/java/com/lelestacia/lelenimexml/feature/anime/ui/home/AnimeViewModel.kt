package com.lelestacia.lelenimexml.feature.anime.ui.home

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.lelestacia.lelenimexml.feature.anime.domain.model.Anime
import com.lelestacia.lelenimexml.feature.anime.domain.usecase.AnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeUseCase: AnimeUseCase
) : ViewModel() {

    private val _searchQuery = MutableLiveData("")
    val searchQuery: LiveData<String> get() = _searchQuery

    val getAnimeData: LiveData<PagingData<Anime>> = _searchQuery
        .distinctUntilChanged()
        .switchMap { query ->
            if (query.isEmpty()) animeUseCase
                .getAiringAnime()
                .cachedIn(viewModelScope)
                .asLiveData()
            else animeUseCase
                .getAnimeByTitle(query)
                .cachedIn(viewModelScope)
                .asLiveData()
        }

    fun insertNewSearchQuery(newSearchQuery: String) {
        _searchQuery.value = newSearchQuery
    }

    suspend fun insertOrUpdateAnimeToHistory(anime: Anime) {
        animeUseCase.insertOrUpdateNewAnimeToHistory(anime)
    }
}