package com.utejeiro.nimbleandroid.repository.api

import com.utejeiro.nimbleandroid.model.Survey
import retrofit2.Call


interface ISurveyRepository {
    fun getSurveys(): Call<List<Survey>>

    fun getSurveys(page: Int, perPage: Int): Call<List<Survey>>
}