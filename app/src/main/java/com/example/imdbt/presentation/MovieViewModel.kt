package com.example.imdbt.presentation

import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.imdbt.R
import com.example.imdbt.data.UserProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {

    private var isLogin: Boolean = false

    private val _txtUserVM = MutableLiveData<String>()
    val txtUserVM: MutableLiveData<String> get() = _txtUserVM

    private val _txtPasswordVM = MutableLiveData<String>()
    val txtPasswordVM: MutableLiveData<String> = _txtPasswordVM

    fun isLoginTrue(user1: String, password1: String): Boolean {
        UserProvider.userList.forEach {
            isLogin = return it.user.contains(user1) && it.password.contains(password1)
        }
        return isLogin
    }

}