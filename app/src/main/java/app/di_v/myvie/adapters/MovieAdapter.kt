package app.di_v.myvie.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.di_v.myvie.R
import app.di_v.myvie.data.entities.TmdbMovie
import app.di_v.myvie.util.tmdbImageUrl
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var list: List<TmdbMovie>? = null

    override fun getItemCount() =list?.size ?: 0

    internal fun setData(data: List<TmdbMovie>) {
        list = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val url: String = tmdbImageUrl + (list?.get(position)?.posterPath ?: "")
        Glide.with(holder.itemView.context)
            .load(url)
            .into(holder.poster)
        holder.movieName.text = list!![position].title
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView = itemView.findViewById(R.id.item_rv_poster)
        val movieName: TextView = itemView.findViewById(R.id.item_rv_movie_name)
    }
}