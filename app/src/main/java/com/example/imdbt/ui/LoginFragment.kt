package com.example.imdbt.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
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
        binding.login1.setOnClickListener {
            if (onConnection()) {
                goingToNavigation()
            } else {
                Toast.makeText(
                    binding.login1.context,
                    "Sin Conexión a Internet",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    private fun onConnection(): Boolean {
        // register activity with the connectivity manager service
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
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