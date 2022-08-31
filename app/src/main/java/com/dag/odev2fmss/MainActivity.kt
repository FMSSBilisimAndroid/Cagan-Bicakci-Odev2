package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dag.odev2fmss.databinding.ActivityMainBinding
import com.dag.odev2fmss.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var loginIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJoinNow.setOnClickListener{
            onJoinButtonClicked()
        }
    }

    private fun onJoinButtonClicked() {
        loginIntent = Intent(this,LoginScreenActivity::class.java)
        startActivity(loginIntent)
    }
}