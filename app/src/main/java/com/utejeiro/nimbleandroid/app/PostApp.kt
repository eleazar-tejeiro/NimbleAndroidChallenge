package com.utejeiro.nimbleandroid.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.utejeiro.nimbleandroid.data.home.HomeViewModel
import com.utejeiro.nimbleandroid.data.navigation.Router
import com.utejeiro.nimbleandroid.data.navigation.Screen
import com.utejeiro.nimbleandroid.ui.screens.login.LoginScreen

@Composable
fun PostApp(homeViewModel: HomeViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            Router.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = Router.currentScreen) { currentState ->
            when (currentState.value) {

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {

                }
            }
        }

    }
}