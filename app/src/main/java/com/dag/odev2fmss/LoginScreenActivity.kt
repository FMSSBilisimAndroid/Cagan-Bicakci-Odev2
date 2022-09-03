package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dag.odev2fmss.databinding.ActivityLoginScreenBinding
import com.dag.odev2fmss.model.User
import com.google.android.material.snackbar.Snackbar

class LoginScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreenBinding
    private lateinit var signUpIntent: Intent
    private var currentUser: User? = null

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
        currentUser = null

        /**
         * Searched for a user in userList
         * If any user exist in view model set currentUser to that user in
         */

        for (user in MainActivity.viewModel.userList) {

            if (user.username == usernameInput) {
                currentUser = user
            }

        }

        if (currentUser != null) {
            if (currentUser?.password == passwordInput) {
                showSnackBar(view, "Welcome $usernameInput, good to see you!")
            } else {
                showSnackBar(view, "Password is wrong!")
            }
        } else {
            showSnackBar(view, "User: $usernameInput not found!")
        }

    }
    /**
     * @param view : the view which snackBar show up
     * @param message : the message you want to show
     * You can change [Snackbar.LENGTH_LONG] to set another duration
     **/
    private fun showSnackBar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

}

