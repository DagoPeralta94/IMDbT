package com.example.imdbt.ui

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.imdbt.R
import com.example.imdbt.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.regex.Pattern


class RegisterFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        binding.btRegister.setOnClickListener {

            with(binding) {

                val mEmail = txtEmail.text.toString()
                val mPassword = txtPassword.text.toString()
                val mRepeatPassword = txtPasswordVerify.text.toString()

                val passwordRegex = Pattern.compile(
                    "^" +
                            "(?=.*[-@#$%^&+=])" +     // Al menos 1 carácter especial
                            ".{6,}" +                // Al menos 4 caracteres
                            "$"
                )

                if (mEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()) {
                    Toast.makeText(
                        btRegister.context, "Ingrese un email valido.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (mPassword.isEmpty() || !passwordRegex.matcher(mPassword).matches()) {
                    Toast.makeText(
                        btRegister.context, "La contraseña es debil.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (mPassword != mRepeatPassword) {
                    Toast.makeText(
                        btRegister.context, "Confirma la contraseña.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    createAccount(mEmail, mPassword)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            if (currentUser.isEmailVerified) {
                goingToHome()
            } else {
                goingToVerifyEmail()
            }
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    goingToVerifyEmail()
                } else {
                    Toast.makeText(
                        binding.btRegister.context, "No se pudo crear la cuenta. Vuelva a intertarlo",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
    private fun goingToHome() {
        findNavController().navigate(R.id.action_registerFragment_to_movie_graph)
    }

    private fun goingToVerifyEmail(){
        findNavController().navigate(R.id.action_registerFragment_to_verifyEmailFragment)
    }
}


