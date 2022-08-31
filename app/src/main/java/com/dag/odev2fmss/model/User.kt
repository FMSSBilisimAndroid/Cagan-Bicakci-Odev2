package com.dag.odev2fmss.model

data class User(var email: String, var username: String, var password: String){

    companion object{
        var userList: MutableList<User> = mutableListOf<User>()
    }
}
