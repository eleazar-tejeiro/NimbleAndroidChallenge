//package com.utejeiro.nimbleandroid.repository
//
//import androidx.lifecycle.MutableLiveData
//import androidx.paging.DataSource
//import com.utejeiro.nimbleandroid.model.Survey
//import com.utejeiro.nimbleandroid.repository.api.ISurveyRepository
//import javax.inject.Inject
//
//
//class SurveyDataSourceFactory @Inject constructor(
//    private val surveyRepository: ISurveyRepository
//) : DataSource.Factory<Int, Survey>() {
//
//    val surveyDataSourceLiveData = MutableLiveData<SurveyDataSource>()
//
//    override fun create(): DataSource<Int, Survey> {
//        val newsDataSource = SurveyDataSource(surveyRepository)
//        surveyDataSourceLiveData.postValue(newsDataSource)
//        return newsDataSource
//    }
//}