package com.utejeiro.nimbleandroid.data.home


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val TAG = HomeViewModel::class.simpleName

    val isUserLoggedIn: MutableLiveData<Boolean> = MutableLiveData()

    fun logout() {



    }

    fun checkForActiveSession() {

    }


    val emailId: MutableLiveData<String> = MutableLiveData()

    fun getUserData() {

    }

}