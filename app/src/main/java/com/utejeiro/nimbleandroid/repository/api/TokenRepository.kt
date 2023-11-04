package com.utejeiro.nimbleandroid.repository.api

import com.utejeiro.nimbleandroid.backend.OAuthToken
import com.utejeiro.nimbleandroid.backend.api.TokenApi
import retrofit2.Call


class TokenRepository(private val tokenApi: TokenApi) :
    ITokenRepository {
    override fun postCredentials(grantType: String,
                                 username: String,
                                 password: String,
                                 clientId: String,
                                 clientSecret: String): Call<OAuthToken> {
        return tokenApi.postCredentials(grantType, username, password, clientId, clientSecret)
    }
}