package com.utejeiro.nimbleandroid.repository.api

import com.utejeiro.nimbleandroid.backend.OAuthToken
import retrofit2.Call


interface ITokenRepository {
    fun postCredentials(grantType: String,
                        username: String,
                        password: String,
                        clientId: String,
                        clientSecret: String): Call<OAuthToken>
}