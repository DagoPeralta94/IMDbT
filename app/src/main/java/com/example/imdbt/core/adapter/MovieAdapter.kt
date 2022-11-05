package com.example.imdbt.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbt.R
import com.example.imdbt.data.model.MovieDb
import com.example.imdbt.data.model.MovieDbResult

class MovieAdapter(var movieBestList: List<MovieDb>): RecyclerView.Adapter<MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieHolder(layoutInflater.inflate(R.layout.item_movies, parent, false))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val item = movieBestList[position]
        return holder.render(item)
    }

    override fun getItemCount(): Int = movieBestList.size
}