package com.dag.odev2fmss.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserViewModelFactory(): ViewModelProvider.Factory{

    //user view model instance created
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }

}