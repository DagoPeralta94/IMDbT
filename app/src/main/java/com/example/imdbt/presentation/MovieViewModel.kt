package com.example.imdbt.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieViewModel: ViewModel() {

    val txtUserVM : MutableLiveData<String> = MutableLiveData()
    val txtPasswordVM : MutableLiveData<String> = MutableLiveData()

    fun getCurrentInformation(){
        txtUserVM
        txtPasswordVM
    }

    fun getTxtInformation(
        nameLogin: String,
        passwordLogin: String
    ){
        txtUserVM.value = "Hola ${nameLogin}"
        txtPasswordVM.value = "Tu contra es ${passwordLogin}"
    }

}