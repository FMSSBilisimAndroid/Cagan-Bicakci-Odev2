package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dag.odev2fmss.databinding.ActivityLoginScreenBinding

class LoginScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginScreenBinding
    private lateinit var signUpIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signUpIntent = Intent(this, SignUpScreenActivity::class.java)

        binding.linkCreateAccount.setOnClickListener{
            startActivity(signUpIntent)
        }

        binding.btnBack.setOnClickListener{
            this.finish()
        }

    }
}