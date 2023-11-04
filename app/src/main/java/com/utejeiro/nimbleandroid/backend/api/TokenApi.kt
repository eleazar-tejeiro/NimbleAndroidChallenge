package com.utejeiro.nimbleandroid.backend.api

import com.utejeiro.nimbleandroid.BuildConfig
import com.utejeiro.nimbleandroid.backend.OAuthToken
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface TokenApi {
    companion object {
        const val GRANT_TYPE = "password"
        const val USERNAME = "eltejeiro@gmail.com"
        const val PASSWORD = "12345678"
        const val CLIENT_ID = BuildConfig.API_ID
        const val CLIENT_SECRET = BuildConfig.API_SECRET
    }

    @FormUrlEncoded
    @POST("/oauth/token")
    fun postCredentials(
        @Field("grant_type") grantType: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String
    ): Call<OAuthToken>
}