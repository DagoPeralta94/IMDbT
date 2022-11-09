package com.example.imdbt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imdbt.application.AppConstants
import com.example.imdbt.core.adapter.MovieAdapter
import com.example.imdbt.data.model.MovieDb
import com.example.imdbt.data.model.MovieDbClient
import com.example.imdbt.data.model.MovieDbResult
import com.example.imdbt.data.model.MoviesProvider
import com.example.imdbt.databinding.FragmentSearchMovieBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class SearchMovieFragment : Fragment() {

    private var _binding: FragmentSearchMovieBinding? = null
    private val binding get() = _binding!!
    private var topMovies: List<MovieDbResult> = emptyList()
    lateinit var topMoviesList: List<MovieDb>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            lifecycleScope.launch {
                var topMovies = MovieDbClient.service.listTopRatedMovies(AppConstants.API_KEY)
                topMoviesList = topMovies.results
                withContext(Dispatchers.Main){
                    binding.rcMovies.layoutManager = LinearLayoutManager(binding.rcMovies.context, LinearLayoutManager.VERTICAL, false)
                    binding.rcMovies.adapter = MovieAdapter(topMoviesList)
                    MovieAdapter(topMoviesList).notifyDataSetChanged()
                }
            }
        }


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentSearchMovieBinding.inflate(inflater, container, false)
            return binding.root
            lifecycleScope.launch{


            }

        }
    }