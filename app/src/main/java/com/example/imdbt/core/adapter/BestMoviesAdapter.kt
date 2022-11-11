package com.example.imdbt.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbt.R
import com.example.imdbt.data.model.MovieDb

class BestMoviesAdapter(var movieBestList: List<MovieDb>, private val onClickListener:(MovieDb) -> Unit ): RecyclerView.Adapter<BestMoviesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestMoviesHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BestMoviesHolder(layoutInflater.inflate(R.layout.item_best_movies, parent, false))
    }

    override fun onBindViewHolder(holder: BestMoviesHolder, position: Int) {
        val item = movieBestList[position]
        return holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = movieBestList.size
}