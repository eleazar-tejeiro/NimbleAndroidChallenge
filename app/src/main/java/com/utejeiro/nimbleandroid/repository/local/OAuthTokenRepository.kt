package com.utejeiro.nimbleandroid.repository.local

import android.content.SharedPreferences
import com.utejeiro.nimbleandroid.backend.OAuthToken
import javax.inject.Inject


class OAuthTokenRepository @Inject constructor(private val sharedPreferences: SharedPreferences) :
    IOAuthTokenRepository {
    override fun getToken(): OAuthToken {
        val accessToken = sharedPreferences.getString(OAuthToken.ACCESS_TOKEN, "")
        val tokenType = sharedPreferences.getString(OAuthToken.TOKEN_TYPE, "")
        return if (accessToken != null && tokenType != null) {
            OAuthToken(
                accessToken,
                tokenType
            )
        } else {
            OAuthToken("", "")
        }
    }

    override fun saveToken(oAuthToken: OAuthToken) {
        sharedPreferences
            .edit()
            .putString(OAuthToken.ACCESS_TOKEN, oAuthToken.accessToken)
            .putString(OAuthToken.TOKEN_TYPE, oAuthToken.tokenType)
            .apply()
    }
}