package app.di_v.myvie.service

import app.di_v.myvie.data.TmdbMovieResponse
import app.di_v.myvie.data.entities.TmdbMovie
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    // Получить список популярных фильмов
    @GET("/3/movie/popular")
    suspend fun getPopularMovie(): Response<TmdbMovieResponse>

    // Получить информацию о фильме по id.
    @GET("/3/movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int): Response<TmdbMovie>

    // Получить картинку для фильма
    @GET("/3/movie/{movie_id}/images")
    suspend fun getImageMovie(@Path("movie_id") id: Int): Response<TmdbMovie>

    // Получите ключевые слова, которые были добавлены в фильм.
    @GET("/3/movie/{movie_id}/keywords")
    suspend fun getKeywords(@Path("movie_id") id: Int): Response<Int>

    // Получите видео, которые были добавлены в фильм.
    @GET("/3/movie/{movie_id}/videos")
    suspend fun getVideo(@Path("movie_id") id: Int): Response<Int>

    // Получите список рекомендуемых фильмов для фильма.
    @GET("/3/movie/{movie_id}/recommendations")
    suspend fun getRecommendations(@Path("movie_id") id: Int): Response<Int>

    // Получите отзывы пользователей о фильме.
    @GET("/3/movie/{movie_id}/reviews")
    suspend fun getReviews(@Path("movie_id") id: Int): Response<Int>

    // Получите список фильмов в кинотеатрах.
    @GET("/3/movie/now_playing")
    suspend fun getNowPlaying(): Response<TmdbMovieResponse>
}