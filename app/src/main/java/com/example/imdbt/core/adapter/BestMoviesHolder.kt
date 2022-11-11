package com.example.imdbt.core.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdbt.application.AppConstants
import com.example.imdbt.data.model.MovieDb
import com.example.imdbt.databinding.ItemBestMoviesBinding

class BestMoviesHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemBestMoviesBinding.bind(view)

    fun render(listBestMovies: MovieDb, onClickListener:(MovieDb) -> Unit) {
        with(binding){
            Glide.with(ivPortadaSelect.context)
                .load("${AppConstants.BASE_URL_IMAGE}${listBestMovies.poster_path}")
                .into(ivPortadaSelect)
            txScore.text = listBestMovies.vote_average.toString()
            txTitleMovieSelect.text = listBestMovies.title
            itemView.setOnClickListener { onClickListener(listBestMovies) }
        }
    }

}