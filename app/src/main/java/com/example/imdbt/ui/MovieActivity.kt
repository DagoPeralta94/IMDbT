package com.example.imdbt.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.imdbt.R
import com.example.imdbt.databinding.ActivityMovieBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNavigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item->
            when (item.itemId) {
                R.id.homeMovieFragment -> {
                    Toast.makeText(binding.root.context, "HOME", Toast.LENGTH_SHORT).show()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.searchMovieFragment -> {
                    Toast.makeText(binding.root.context, "SEARCH", Toast.LENGTH_SHORT).show()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.playMovieFragment -> {
                    Toast.makeText(binding.root.context, "PLAY", Toast.LENGTH_SHORT).show()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profileMovieFragment -> {
                    Toast.makeText(binding.root.context, "PROFILE", Toast.LENGTH_SHORT).show()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

    }
}