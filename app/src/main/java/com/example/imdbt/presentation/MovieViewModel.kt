package com.example.imdbt.presentation

import android.view.MenuItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imdbt.R
import com.example.imdbt.data.UserProvider
import com.example.imdbt.ui.HomeMovieFragment
import com.example.imdbt.ui.PlayMovieFragment
import com.example.imdbt.ui.ProfileMovieFragment
import com.example.imdbt.ui.SearchMovieFragment

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