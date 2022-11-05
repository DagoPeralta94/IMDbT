package com.example.imdbt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imdbt.core.adapter.MovieAdapter
import com.example.imdbt.data.model.MovieDb
import com.example.imdbt.data.model.MoviesProvider
import com.example.imdbt.databinding.FragmentSearchMovieBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SearchMovieFragment : Fragment() {

    private var _binding: FragmentSearchMovieBinding? = null
    private val binding get() = _binding!!

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            lifecycleScope.launch{
                binding.rcMovies.layoutManager = LinearLayoutManager(binding.rcMovies.context, LinearLayoutManager.VERTICAL, false)
                binding.rcMovies.adapter = MovieAdapter(MoviesProvider.movieListBest)
            }
        }


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentSearchMovieBinding.inflate(inflater, container, false)
            return binding.root

        }
    }