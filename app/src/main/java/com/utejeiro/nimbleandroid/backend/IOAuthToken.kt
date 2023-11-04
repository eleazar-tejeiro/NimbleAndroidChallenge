package com.utejeiro.nimbleandroid.backend

/**
 * Interface used to hold authorization for a REST api
 */
interface IOAuthToken {
    fun getAuthorization(): String
}