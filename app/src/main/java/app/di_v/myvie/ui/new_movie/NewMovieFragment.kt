package app.di_v.myvie.ui.new_movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.di_v.myvie.R
import app.di_v.myvie.adapters.MovieAdapter
import app.di_v.myvie.ui.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

class NewMovieFragment: Fragment() {
    lateinit var viewModel: MovieViewModel
    lateinit var adapter: MovieAdapter

    companion object {
        fun newInstance() =NewMovieFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movie, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        observeMovie()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel.getNewMovie()
    }

    private fun initUi() {
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        movie_rv.layoutManager = LinearLayoutManager(activity)
        adapter = MovieAdapter()
        movie_rv.adapter = adapter
    }

    private fun observeMovie() {
        viewModel.popularMovieResponse.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.setData(it)
            }
        })
    }
}