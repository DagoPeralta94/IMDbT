package com.example.imdbt.core.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdbt.application.AppConstants
import com.example.imdbt.data.model.MovieDb
import com.example.imdbt.data.model.MovieDbResult
import com.example.imdbt.databinding.ItemMoviesBinding

class MovieHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemMoviesBinding.bind(view)

    fun render(listModelBestMovies: MovieDb) {
        with(binding) {
            Glide.with(ivMovies.context).load("${AppConstants.BASE_URL_IMAGE}${listModelBestMovies.poster_path}")
                .into(ivMovies)
            tvMovieAge.text = listModelBestMovies.release_date
            tvMovieDescription.text = listModelBestMovies.overview
            tvMovieName.text = listModelBestMovies.title
        }
    }

}