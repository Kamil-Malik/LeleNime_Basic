package com.lelestacia.lelenimexml.feature.anime.domain.util

import com.lelestacia.lelenimexml.core.model.CharacterDetail
import com.lelestacia.lelenimexml.core.model.Character
import com.lelestacia.lelenimexml.core.model.local.character.CharacterDetailEntity
import com.lelestacia.lelenimexml.core.model.local.character.CharacterEntity

object CharacterMapper {

    fun entityToCharacter(characterEntity: CharacterEntity): Character {
        return Character(
            characterMalId = characterEntity.characterId,
            images = characterEntity.characterImage,
            name = characterEntity.characterName,
            role = characterEntity.role,
            favoriteBy = characterEntity.favoriteBy
        )
    }

    fun fullProfileEntityToFullProfile(fullProfile: CharacterDetailEntity)
            : CharacterDetail =
        CharacterDetail(
            characterMalId = fullProfile.character.characterId,
            name = fullProfile.character.characterName,
            characterNickNames = fullProfile.additionalInformation.characterNickNames,
            characterKanjiName = fullProfile.additionalInformation.characterKanjiName,
            images = fullProfile.character.characterImage,
            role = fullProfile.character.role,
            favoriteBy = fullProfile.character.favoriteBy,
            characterInformation = fullProfile.additionalInformation.characterInformation
        )
}