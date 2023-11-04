package com.utejeiro.nimbleandroid.backend

import com.utejeiro.nimbleandroid.backend.api.SurveyApi
import com.utejeiro.nimbleandroid.backend.api.TokenApi
import com.utejeiro.nimbleandroid.repository.api.ITokenRepository
import com.utejeiro.nimbleandroid.repository.local.IOAuthTokenRepository
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class SurveyApiAuthenticator @Inject constructor(
    private val tokenRepository: ITokenRepository,
    private val oauthTokenRepository: IOAuthTokenRepository,
    private val username: String,
    private val password: String
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        val token = tokenRepository
            .postCredentials(
                TokenApi.GRANT_TYPE,
                username,
                password,
                TokenApi.CLIENT_ID,
                TokenApi.CLIENT_SECRET
            )
            .execute()
            .body()

        return if (token != null) {
            oauthTokenRepository.saveToken(OAuthToken(token.accessToken, token.tokenType))

            response
                .request()
                .newBuilder()
                .header(
                    SurveyApi.AUTHORIZATION,
                    token.getAuthorization()
                ).build()
        } else {
            null
        }
    }
}