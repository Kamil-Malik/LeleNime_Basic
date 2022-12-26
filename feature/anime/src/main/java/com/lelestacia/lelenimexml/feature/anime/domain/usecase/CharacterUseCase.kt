package com.lelestacia.lelenimexml.feature.anime.domain.usecase

import com.lelestacia.lelenimexml.core.model.CharacterDetail
import com.lelestacia.lelenimexml.core.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterUseCase {
    fun getAnimeCharacterById(id: Int): Flow<List<Character>>
    fun getCharacterInformationByCharacterId(characterId: Int): Flow<CharacterDetail>
}