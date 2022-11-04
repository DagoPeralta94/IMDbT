package com.example.imdbt.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imdbt.R
import com.example.imdbt.application.AppConstants
import com.example.imdbt.data.model.MovieDbClient
import com.example.imdbt.databinding.FragmentSearchMovieBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SearchMovieFragment : Fragment() {

    private var _binding: FragmentSearchMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        runBlocking(Dispatchers.IO){
            updateData()
        }
    }

    private fun updateData() {
                val topMovies = MovieDbClient.service.listTopRatedMovies(AppConstants.API_KEY)
                val body = topMovies.execute().body()
                if (body != null)
                    Log.d("MainActivity", "Movie count: ${body.results.size}")
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchMovieBinding.inflate(inflater, container, false)
        return binding.root

    }

}