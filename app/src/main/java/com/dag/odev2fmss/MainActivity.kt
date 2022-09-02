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

    /**
     *  Companion object for view model to access data both login and sign up pages
     */
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

        /**
         *  view model initialized
         */
        val factory = UserViewModelFactory()
        viewModel = ViewModelProvider(this,factory).get(UserViewModel::class.java)

    }

    private fun onJoinButtonClicked() {
        loginIntent = Intent(this,LoginScreenActivity::class.java)
        startActivity(loginIntent)
    }
}