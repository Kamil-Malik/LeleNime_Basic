package com.lelestacia.lelenimexml.core.model.local.character

import androidx.room.Embedded
import androidx.room.Relation

data class CharacterFullProfileEntity(
    @Embedded
    val character: CharacterEntity,
    @Relation(
        parentColumn = "characterId",
        entityColumn = "characterId"
    )
    val additionalInformation: CharacterAdditionalInformationEntity
)