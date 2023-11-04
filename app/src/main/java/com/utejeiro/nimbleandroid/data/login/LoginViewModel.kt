package com.utejeiro.nimbleandroid.data.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.utejeiro.nimbleandroid.backend.SurveyApiAuthenticator
import com.utejeiro.nimbleandroid.data.rules.Validator
import com.utejeiro.nimbleandroid.repository.api.ITokenRepository
import com.utejeiro.nimbleandroid.repository.api.TokenRepository

class LoginViewModel : ViewModel() {

    private val TAG = LoginViewModel::class.simpleName

    var loginUIState = mutableStateOf(LoginUIState())

    var allValidationsPassed = mutableStateOf(false)

    var loginInProgress = mutableStateOf(false)


    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }

            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }

            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }
        }
        validateLoginUIDataWithRules()
    }

    private fun validateLoginUIDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )


        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )

        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status

    }

    private fun login() {

        loginInProgress.value = true
        val email = loginUIState.value.email
        val password = loginUIState.value.password

//        val tokenRepository =
//        val authenticator = SurveyApiAuthenticator(tokenRepository, oAuthTokenRepository)

    }

}


