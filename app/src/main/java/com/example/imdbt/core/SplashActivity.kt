package com.example.imdbt.core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.imdbt.MainActivity
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
                startMsg()
                delay(15000)
            }

        }
    }
    fun startMsg() {
        println("Comenzando corrutina -${Thread.currentThread().name}-")
    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}