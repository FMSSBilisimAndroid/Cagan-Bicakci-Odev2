package com.dag.odev2fmss.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dag.odev2fmss.model.User

class UserViewModel : ViewModel() {

    //created a live data and user model list to store user data from sign up
    var userData = MutableLiveData<ArrayList<User>>()
    var userList = arrayListOf<User>()

    fun add(user: User){
        userList.add(user)
        userData.value = userList
    }
}