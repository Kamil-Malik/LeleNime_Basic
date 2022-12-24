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

    private val airingAnime = animeUseCase
        .getAiringAnime()
        .cachedIn(viewModelScope)
        .asLiveData()

    val getAnimeData: LiveData<PagingData<Anime>> = _searchQuery
        .switchMap { query ->
            if (query.isEmpty())
                airingAnime
            else {
                animeUseCase
                    .getAnimeByTitle(_searchQuery.value as String)
                    .cachedIn(viewModelScope)
                    .asLiveData()
            }
        }

    fun insertNewSearchQuery(newSearchQuery: String) {
        _searchQuery.value = newSearchQuery
    }

    suspend fun insertOrUpdateAnimeToHistory(anime: Anime) {
        animeUseCase.insertOrUpdateNewAnimeToHistory(anime)
    }
}