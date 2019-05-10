package com.clevmania.moviemageek.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clevmania.moviemageek.R
import com.clevmania.moviemageek.data.model.MovieModel

class MovieAdapter(private val movieList : List<MovieModel>)
    : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MovieViewHolder(view)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.movieThumbnail.setImageResource(movie.thumbnail.toInt())
        holder.movieTitle.text = movie.title
    }

    class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val movieThumbnail = itemView.findViewById<ImageView>(R.id.iv_movie_thumbnail)
        val movieTitle = itemView.findViewById<TextView>(R.id.tv_movie_title)
    }
}