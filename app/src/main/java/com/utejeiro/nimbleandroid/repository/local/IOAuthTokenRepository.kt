package com.utejeiro.nimbleandroid.repository.local

import com.utejeiro.nimbleandroid.backend.OAuthToken


interface IOAuthTokenRepository {
    fun getToken(): OAuthToken

    fun saveToken(oAuthToken: OAuthToken)
}