package com.example.imdbt.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.imdbt.R
import com.example.imdbt.databinding.FragmentHomeMovieBinding
import com.example.imdbt.databinding.FragmentLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeMovieFragment : Fragment() {

    private var _binding : FragmentHomeMovieBinding? = null
    private val binding get()  = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeMovieBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



}