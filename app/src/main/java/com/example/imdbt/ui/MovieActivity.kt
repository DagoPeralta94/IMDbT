package com.example.imdbt.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbt.R
import com.example.imdbt.application.AppConstants
import com.example.imdbt.core.adapter.MovieAdapter
import com.example.imdbt.data.model.MovieDb
import com.example.imdbt.data.model.MovieDbClient
import com.example.imdbt.databinding.ActivityMovieBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.*

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    private lateinit var topMovies: List<MovieDb>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeMovieFragment())
        updateData()


        binding.buttonNavigation.setOnItemSelectedListener { item->
            when (item.itemId) {
                R.id.homeMovieFragment -> replaceFragment(HomeMovieFragment())
                R.id.searchMovieFragment -> replaceFragment(SearchMovieFragment())
                R.id.playMovieFragment -> replaceFragment(PlayMovieFragment())
                R.id.profileMovieFragment -> replaceFragment(ProfileMovieFragment())
            }
            true
        }

    }
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_container,fragment)
        fragmentTransaction.commit()


    }

    private fun updateData() {
        lifecycleScope.launch {
            var topMovies = MovieDbClient.service.listTopRatedMovies(AppConstants.API_KEY)
            var i = 0
            var movieList: MutableList<String> = mutableListOf()
            while (i < topMovies.results.size) {
                movieList.add(topMovies.results[i].title)
                println(movieList)
                i += 1
            }
        }
    }

}