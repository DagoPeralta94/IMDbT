package com.example.imdbt.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.imdbt.R
import com.example.imdbt.data.UserProvider
import com.example.imdbt.databinding.FragmentLoginBinding
import com.example.imdbt.presentation.MovieViewModel


class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? = null
    private val binding get()  = _binding!!
    private lateinit var viewModel : MovieViewModel

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
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getCurrentInformation()
        saveInformation()
        binding.txtRegister.setOnClickListener { goingToRegister() }
        binding.login1.setOnClickListener { goingToNavigation() }

    }

    private fun goingToNavigation() {
        val user0 = binding.txtUser.editText?.text.toString()
        val passw0 = binding.txtPassword.editText?.text.toString()

        var i = 0
        for (users in UserProvider.userList) {

            val user1 = UserProvider.userList[i].user
            val passw1 = UserProvider.userList[i].password

            if (user0 == user1 && passw1 == passw0) {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
                break
            } else {
                Toast.makeText(binding.txtUser.context, "Usuario Incorrecto", Toast.LENGTH_SHORT).show()
                i += 1
            }
        }
    }

    private fun goingToRegister() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    private fun saveInformation() {
        with(binding) {
            viewModel.getTxtInformation(
                "${txtUser.editText?.text}",
                "${txtPassword.editText?.text}"
            )
        }
        viewModel.txtUserVM.observe(viewLifecycleOwner, Observer {
            binding.txtInformation.text = it
        })
    }
}