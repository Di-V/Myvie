package app.di_v.myvie.ui.movie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import app.di_v.myvie.data.entities.TmdbMovie
import app.di_v.myvie.repository.MovieRepository
import app.di_v.myvie.service.ApiFactory
import app.di_v.myvie.service.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel (application: Application) : AndroidViewModel(application) {

    private val movieService: MovieService
    private val repository: MovieRepository
    private var _popularMovie = MutableLiveData<List<TmdbMovie>>()
    val popularMovieResponse: LiveData<List<TmdbMovie>>
        get() = _popularMovie


    init {
        movieService = ApiFactory.tmdbApi
        repository = MovieRepository(movieService)
    }

    fun getPopularMovie() = viewModelScope.launch(Dispatchers.IO) {
        val result = repository.loadPopularMovie()
        _popularMovie.postValue(result.value)
    }

    fun getNewMovie() = viewModelScope.launch(Dispatchers.IO) {
        val result = repository.loadNewMovie()
        _popularMovie.postValue(result.value)
    }
}