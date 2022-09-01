package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dag.odev2fmss.databinding.ActivityMainBinding
import com.dag.odev2fmss.viewmodel.UserViewModel
import com.dag.odev2fmss.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var loginIntent: Intent

    //We create a companion object for view to access from all the classes both login and sign up pages
    companion object {
        lateinit var viewModel: UserViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJoinNow.setOnClickListener{
            onJoinButtonClicked()
        }

        //we initialized the view model we created.
        val factory = UserViewModelFactory()
        viewModel = ViewModelProvider(this,factory).get(UserViewModel::class.java)

    }

    private fun onJoinButtonClicked() {
        loginIntent = Intent(this,LoginScreenActivity::class.java)
        startActivity(loginIntent)
    }
}