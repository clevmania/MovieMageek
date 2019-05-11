package com.clevmania.moviemageek

import android.widget.ImageView
import com.clevmania.moviemageek.data.model.MovieModel

interface MovieItemClickListener {
    fun onMovieItemClicked(movie: MovieModel, imageThumbnail : ImageView)
}