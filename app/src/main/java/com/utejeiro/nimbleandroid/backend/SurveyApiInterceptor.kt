package com.utejeiro.nimbleandroid.backend

import com.utejeiro.nimbleandroid.backend.api.SurveyApi
import com.utejeiro.nimbleandroid.repository.local.IOAuthTokenRepository
import okhttp3.Interceptor
import okhttp3.Response


class SurveyApiInterceptor(private val oauthTokenRepository: IOAuthTokenRepository) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val oAuthToken: OAuthToken = oauthTokenRepository.getToken()

        val newRequest = chain
            .request()
            .newBuilder()
            .header(
                SurveyApi.AUTHORIZATION,
                oAuthToken.getAuthorization()
            ).build()
        return chain.proceed(newRequest)
    }
}