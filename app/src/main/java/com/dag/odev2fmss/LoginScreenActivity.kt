package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dag.odev2fmss.databinding.ActivityLoginScreenBinding
import com.dag.odev2fmss.model.User
import com.google.android.material.snackbar.Snackbar

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

        binding.btnLogin.setOnClickListener{

            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            for (user in User.userList){
                if (user.username == username && user.password == password){
                    Snackbar.make(it,"Welcome $username!", Snackbar.LENGTH_INDEFINITE).show()
                }else{
                    Snackbar.make(it,"Username or password is wrong!", Snackbar.LENGTH_LONG).show()
                }
            }
        }

    }
}