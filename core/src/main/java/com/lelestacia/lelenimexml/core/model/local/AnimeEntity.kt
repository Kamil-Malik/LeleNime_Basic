package com.lelestacia.lelenimexml.core.model.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
@Entity(tableName = "anime_table")
data class AnimeEntity(
    @PrimaryKey(autoGenerate = false)
    val malId: Int,
    val coverImages: String,
    @Embedded
    val trailer: Trailer?,
    val title: String,
    val titleEnglish: String?,
    val titleJapanese: String?,
    val type: String,
    val episodes: Int?,
    val status: String,
    val rating: String,
    val score: Double?,
    val scoredBy: Int?,
    val rank: Int,
    val synopsis: String?,
    val season: String?,
    val year: Int,
    val genres: List<String>,
    val lastViewed: Date,
    @ColumnInfo(defaultValue = "false")
    var isFavorite: Boolean
) : Parcelable {

    @Parcelize
    data class Trailer(
        val youtubeId: String?,
        val url: String?,
        val images: String?
    ) : Parcelable
}
