package com.utejeiro.nimbleandroid.repository.api

import com.utejeiro.nimbleandroid.backend.api.SurveyApi
import com.utejeiro.nimbleandroid.model.Survey
import retrofit2.Call
import javax.inject.Inject


class SurveyRepository @Inject constructor(private val surveyApi: SurveyApi) :
    ISurveyRepository {
    override fun getSurveys(): Call<List<Survey>> {
        return surveyApi.getSurveys()
    }

    override fun getSurveys(page: Int, perPage: Int): Call<List<Survey>> {
        return surveyApi.getSurveys(page, perPage)
    }
}