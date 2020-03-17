package app.di_v.myvie.repository

import androidx.lifecycle.MutableLiveData
import app.di_v.myvie.data.entities.TmdbMovie
import app.di_v.myvie.service.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(
    private val movieService: MovieService
) {

    suspend fun loadPopularMovie() = withContext(Dispatchers.IO) {
        val liveData = MutableLiveData<List<TmdbMovie>>()
        val response = movieService.getPopularMovie()

        if (response.isSuccessful) {
            val movie = response.body()
            if (movie != null) {
                liveData.postValue(movie.results)
            }
        }
        liveData
    }

    suspend fun loadNewMovie() = withContext(Dispatchers.IO) {
        val liveData = MutableLiveData<List<TmdbMovie>>()
        val response = movieService.getNowPlaying()

        if (response.isSuccessful) {
            val movie = response.body()
            if (movie != null) {
                liveData.postValue(movie.results)
            }
        }
        liveData
    }
}