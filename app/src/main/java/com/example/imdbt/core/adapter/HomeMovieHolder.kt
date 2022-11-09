package com.example.imdbt.core.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdbt.application.AppConstants
import com.example.imdbt.data.model.MovieDb
import com.example.imdbt.databinding.ItemHomeMovieBinding


class HomeMovieHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemHomeMovieBinding.bind(view)

    fun render(listHomeMovies: MovieDb) {
        with(binding) {
            Glide.with(ivPlayHome.context)
                .load("${AppConstants.BASE_URL_IMAGE}${listHomeMovies.poster_path}")
                .into(ivPortadaHomeMovie)
            Glide.with(ivPlayHome.context)
                .load("${AppConstants.BASE_URL_IMAGE}${listHomeMovies.backdrop_path}")
                .into(ivPortadaFragment)
            txTitleMoviePortada.text = listHomeMovies.title

        }
    }
}