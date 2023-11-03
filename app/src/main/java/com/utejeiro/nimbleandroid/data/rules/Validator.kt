package com.utejeiro.nimbleandroid.data.rules

import android.util.Log

object Validator {

    fun validateEmail(email: String): ValidationResult {
        return ValidationResult(
            (!email.isNullOrEmpty())
        )
    }

    fun validatePassword(password: String): ValidationResult {
        return ValidationResult(
            (!password.isNullOrEmpty() && password.length >= 4)
        )
    }

}

data class ValidationResult(
    val status: Boolean = false
)








