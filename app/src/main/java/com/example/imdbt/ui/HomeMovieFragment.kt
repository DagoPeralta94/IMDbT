package com.example.imdbt.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imdbt.R
import com.example.imdbt.application.AppConstants
import com.example.imdbt.core.adapter.BestMoviesAdapter
import com.example.imdbt.core.adapter.HomeMovieAdapter
import com.example.imdbt.core.adapter.MovieAdapter
import com.example.imdbt.data.model.MovieDb
import com.example.imdbt.data.model.MovieDbClient
import com.example.imdbt.data.model.MovieDbResult
import com.example.imdbt.databinding.FragmentHomeMovieBinding
import com.example.imdbt.databinding.FragmentLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeMovieFragment : Fragment() {

    private var _binding: FragmentHomeMovieBinding? = null
    private val binding get() = _binding!!
    lateinit var topMoviesList: List<MovieDb>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                launchData()
            }
            withContext(Dispatchers.Main) {
                launchRecyclerViewMain()
                launchRecyclerViewBestMovies()
            }
        }
    }

    private fun launchRecyclerViewBestMovies() {
        with(binding) {
            rvBestSelections.layoutManager = LinearLayoutManager(
                rvBestSelections.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rvBestSelections.adapter = BestMoviesAdapter(topMoviesList)
            BestMoviesAdapter(topMoviesList).notifyDataSetChanged()
        }
    }

    private fun launchRecyclerViewMain() {
        with(binding) {
            rvPortadaMovie.layoutManager = LinearLayoutManager(
                rvPortadaMovie.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rvPortadaMovie.adapter = HomeMovieAdapter(topMoviesList)
            MovieAdapter(topMoviesList).notifyDataSetChanged()
        }
    }

    private suspend fun launchData() {
        var topMovies = MovieDbClient.service.listTopRatedMovies(AppConstants.API_KEY)
        topMoviesList = topMovies.results
    }


}