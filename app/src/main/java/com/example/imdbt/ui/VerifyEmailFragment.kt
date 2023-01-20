package com.example.imdbt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.imdbt.R
import com.example.imdbt.databinding.FragmentVerifyEmailBinding

class VerifyEmailFragment : Fragment() {
    
    private var _binding : FragmentVerifyEmailBinding? = null
    private val binding get()  = _binding!!
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signOutImageView.setOnClickListener {
            findNavController().navigate(R.id.action_verifyEmailFragment_to_loginFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVerifyEmailBinding.inflate(inflater, container, false)
                return binding.root
    }

}