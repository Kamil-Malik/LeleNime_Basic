package com.lelestacia.lelenimexml.core.model.remote.character

import com.google.gson.annotations.SerializedName

data class CharacterDetailResponse(
    @SerializedName("mal_id")
    val characterMalId: Int,

    @SerializedName("name")
    val characterName: String,

    @SerializedName("name_kanji")
    val characterKanjiName: String,

    @SerializedName("nicknames")
    val characterNickNames: List<String> = emptyList(),

    @SerializedName("favorites")
    val characterFavoriteCount: Int,

    @SerializedName("about")
    val characterInformation: String?,
)