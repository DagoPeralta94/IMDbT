package com.example.imdbt.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        replaceFragment(HomeMovieFragment())

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
}