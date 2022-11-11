package com.example.imdbt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.imdbt.R
import com.example.imdbt.databinding.FragmentDetailsMovieBinding


class DetailsMovieFragment : Fragment() {

    private var _binding : FragmentDetailsMovieBinding? = null
    private val binding get()  = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsMovieBinding.inflate(inflater, container, false)
        return binding.root
    }


}