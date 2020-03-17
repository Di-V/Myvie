package app.di_v.myvie.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tmdb_movie")
data class TmdbMovie(
    @PrimaryKey
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "popularity")
    val popularity: Double,
    @field:Json(name = "vote_count")
    val vote_count: Int,
    @field:Json(name = "video")
    val video: Boolean,
    @field:Json(name = "poster_path")
    val posterPath: String?,
    @field:Json(name = "adult")
    val adult: Boolean,
    @field:Json(name = "backdrop_path")
    val backdropPath: String,
    @field:Json(name = "original_language")
    val originalLanguage: String,
    @field:Json(name = "original_title")
    val originalTitle: String,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "vote_average")
    val voteAverage: Double,
    @field:Json(name = "overview")
    val overview: String,
    @field:Json(name = "release_date")
    val releaseDate: String
): Parcelable