package com.dag.odev2fmss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dag.odev2fmss.databinding.ActivitySignUpScreenBinding
import com.dag.odev2fmss.model.User
import com.google.android.material.snackbar.Snackbar

class SignUpScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener{
            this.finish()
        }

        binding.btnSignUp.setOnClickListener{
            val email = binding.etCreateEmail.text.toString()
            val username = binding.etCreateUsername.text.toString()
            val password = binding.etCreatePassword.text.toString()

            val user = User(email = email, username = username, password = password)

            User.userList.add(user)

            Snackbar.make(it,
                "User: ${user.username} created! You can login now!",
                Snackbar.LENGTH_SHORT)
                .show()

        }
    }
}