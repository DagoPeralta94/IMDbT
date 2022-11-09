package com.example.imdbt.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbt.R
import com.example.imdbt.data.model.MovieDb

class HomeMovieAdapter(var movieHomeList: List<MovieDb>): RecyclerView.Adapter<HomeMovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMovieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HomeMovieHolder(layoutInflater.inflate(R.layout.item_home_movie, parent, false))
    }

    override fun onBindViewHolder(holder: HomeMovieHolder, position: Int) {
        val item = movieHomeList[position]
        return holder.render(item)
    }

    override fun getItemCount(): Int = movieHomeList.size

}

