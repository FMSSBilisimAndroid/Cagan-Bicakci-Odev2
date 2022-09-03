package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        /**
         * finish(): Current Activity is propagated back to previous Activity
         */
        binding.btnBack.setOnClickListener {
            this.finish()
        }

        binding.btnLogin.setOnClickListener {
            onLoginButtonClicked(it)
        }

    }

    private fun onLoginButtonClicked(view: View) {

        val usernameInput = binding.etUsername.text.toString()
        val passwordInput = binding.etPassword.text.toString()

        /**
         * Searched for a user in userList
         * If user exist in view model set isUserExist to true otherwise it false
         */
        var isUserExist = false

        for (user in MainActivity.viewModel.userList) {
            if (user.username == usernameInput && user.password == passwordInput) {
                isUserExist = true
                Snackbar.make(view, "Welcome $usernameInput, good to see you!", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view, "Username or password is wrong!", Snackbar.LENGTH_LONG).show()
            }
        }

        if(!isUserExist) {
            Snackbar.make(view, "You should sign up first!", Snackbar.LENGTH_LONG).show()
        }
    }
}