package com.dag.odev2fmss
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dag.odev2fmss.databinding.ActivitySignUpScreenBinding
import com.dag.odev2fmss.error.CredentialError
import com.dag.odev2fmss.model.User
import com.google.android.material.snackbar.Snackbar
import android.util.Log


class SignUpScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpScreenBinding
    private lateinit var credentialErrorType: CredentialError

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         *  finish(): Current Activity is propagated back to previous Activity
         */
        binding.btnBack.setOnClickListener{
            this.finish()
        }

        binding.btnSignUp.setOnClickListener{
            onSignUpClicked(it)
        }
    }

    private fun onSignUpClicked(view: View) {

        val emailInput = binding.etCreateEmail.text.toString()
        val usernameInput = binding.etCreateUsername.text.toString()
        val passwordInput = binding.etCreatePassword.text.toString()

        if (isValidEmail(emailInput) && isValidPassword(passwordInput) && isValidUserName(usernameInput)){

            val user = User(
                email = emailInput,
                username = usernameInput,
                password = passwordInput
            )

            MainActivity.viewModel.add(user)

            showSnackBar(view,"User: ${user.username} created! You can login now!")

            clearAllEditTexts()

        }else{
            when(credentialErrorType){
                CredentialError.EMAIL ->  showSnackBar(view, "Enter a valid email!")
                CredentialError.USERNAME -> showSnackBar(view, "Username can not be empty!")
                CredentialError.PASSWORD -> showSnackBar(view, "Password should be at least 6 characters!")
                else -> return
            }
        }

        Log.i("User Data", MainActivity.viewModel.userList.toString())
    }

    private fun isValidEmail(email: CharSequence?): Boolean {
        return if(!email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            credentialErrorType = CredentialError.NONE
            true
        }else{
            credentialErrorType = CredentialError.EMAIL
            false
        }
    }

    private fun isValidPassword(password: CharSequence?): Boolean {
        return if(!password.isNullOrEmpty() && (password.length >= 6)){
            credentialErrorType = CredentialError.NONE
            true
        }else{
            credentialErrorType = CredentialError.PASSWORD
            false
        }
    }

    private fun isValidUserName(username: CharSequence?): Boolean{
        return if(!username.isNullOrEmpty()){
            credentialErrorType = CredentialError.NONE
            true
        }else{
            credentialErrorType = CredentialError.USERNAME
            false
        }
    }

    private fun clearAllEditTexts(){
        binding.etCreateEmail.text.clear()
        binding.etCreateUsername.text.clear()
        binding.etCreatePassword.text.clear()
    }

    private fun showSnackBar(view: View, message: String){
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }
}