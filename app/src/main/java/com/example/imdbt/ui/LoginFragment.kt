package com.example.imdbt.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.example.imdbt.R
import com.example.imdbt.application.AppConstants
import com.example.imdbt.data.model.MovieDbClient
import com.example.imdbt.databinding.FragmentLoginBinding
import com.example.imdbt.presentation.MovieViewModel
import kotlin.concurrent.thread


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MovieViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get()
        initObservers()
        binding.txtRegister.setOnClickListener { goingToRegister() }
        binding.login1.setOnClickListener { goingToNavigation() }

    }


    private fun initObservers() {
        viewModel.txtUserVM.observe(viewLifecycleOwner,
            Observer { userOb ->
                var texto = binding.txtUser.text.toString()
                texto = userOb
            })
        viewModel.txtPasswordVM.observe(viewLifecycleOwner, Observer { passwordOb ->
            var passObserver = binding.txtPassword.text.toString()
            passObserver = passwordOb
        })
    }

    private fun goingToNavigation() {
        val user = binding.txtUser.text.toString()
        val password = binding.txtPassword.text.toString()
        if (viewModel.isLoginTrue(user, password)) {
            startActivity(Intent(binding.login1.context, MovieActivity::class.java))
        } else {
            Toast.makeText(
                binding.login1.context,
                "Usuario o contraseña Incorrecta",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun goingToRegister() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

}