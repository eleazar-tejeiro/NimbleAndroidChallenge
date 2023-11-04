package com.utejeiro.nimbleandroid.backend.api

import com.utejeiro.nimbleandroid.model.Survey
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SurveyApi {
    companion object {
        const val BASE_URL = "https://survey-api.nimblehq.co/api/v1"
        const val PAGE_SIZE = 10
        const val AUTHORIZATION = "Authorization"
    }

    @GET("/surveys")
    fun getSurveys(): Call<List<Survey>>

    @GET("/surveys")
    fun getSurveys(@Query("page") page: Int, @Query("per_page") perPage: Int): Call<List<Survey>>
}
