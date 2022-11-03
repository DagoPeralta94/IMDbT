package com.example.imdbt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.example.imdbt.R
import com.example.imdbt.data.UserProvider
import com.example.imdbt.databinding.FragmentLoginBinding
import com.example.imdbt.presentation.MovieViewModel
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MovieViewModel
    private val user = binding.txtUser.text.toString()
    private val password = binding.txtPassword.text.toString()

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
        if(viewModel.isLoginTrue(user, password)){
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }else{
            Toast.makeText(binding.login1.context, "Usuario o contraseña Incorrecta", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goingToRegister() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

}