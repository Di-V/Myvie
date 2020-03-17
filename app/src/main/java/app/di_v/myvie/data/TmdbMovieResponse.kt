package app.di_v.myvie.data

import app.di_v.myvie.data.entities.TmdbMovie
import com.squareup.moshi.Json

data class TmdbMovieResponse (
    @field:Json(name = "page")
    val page: Int,
    @field:Json(name = "total_results")
    val totalResults: Int,
    @field:Json(name = "total_pages")
    val totalPages: Int,
    @field:Json(name = "results")
    val results: List<TmdbMovie>?
)
