package com.lelestacia.lelenimexml.core.model.database.character

import androidx.room.Embedded
import androidx.room.Relation

data class CharacterDetailEntity(
    @Embedded
    val character: CharacterEntity,
    @Relation(
        parentColumn = "characterId",
        entityColumn = "characterId"
    )
    val additionalInformation: CharacterAdditionalInformationEntity
)
