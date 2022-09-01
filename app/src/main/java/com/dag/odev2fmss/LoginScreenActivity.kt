package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dag.odev2fmss.databinding.ActivityLoginScreenBinding
import com.google.android.material.snackbar.Snackbar

class LoginScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding
    private lateinit var signUpIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signUpIntent = Intent(this, SignUpScreenActivity::class.java)

        binding.linkCreateAccount.setOnClickListener {
            startActivity(signUpIntent)
        }

        binding.btnBack.setOnClickListener {
            //to finish current activity to go back
            this.finish()
        }

        binding.btnLogin.setOnClickListener {

            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            //we set this variable to a user4 that register if its not an error message show up
            var currentUser = ""

            for (user in MainActivity.viewModel.userList) {
                currentUser = user.username
                if (user.username == username && user.password == password) {
                    Snackbar.make(it, "Welcome $username, good to see you!", Snackbar.LENGTH_LONG).show()
                } else {
                    Snackbar.make(it, "Username or password is wrong!", Snackbar.LENGTH_LONG).show()
                }
            }

            if(currentUser.isEmpty()) {
                Snackbar.make(it, "You should sign up first!", Snackbar.LENGTH_LONG).show()
            }

        }

    }
}