package com.example.imdbt.core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.imdbt.MainActivity
import com.example.imdbt.application.AppConstants
import com.example.imdbt.data.model.MovieDbClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uploadData()
        startActivity(Intent(this,MainActivity::class.java))
    }

    private fun uploadData() {
        runBlocking {
            launch(Dispatchers.IO){
                val topMovies = MovieDbClient.service.listTopRatedMovies(AppConstants.API_KEY)
                val body = topMovies.execute().body()
                if (body != null)
                    Log.d("MainActivity", "Movie count: ${body.results.size}")
            }

        }
    }
    private fun startMsg() {
        println("Comenzando corrutina -${Thread.currentThread().name}-")
    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}