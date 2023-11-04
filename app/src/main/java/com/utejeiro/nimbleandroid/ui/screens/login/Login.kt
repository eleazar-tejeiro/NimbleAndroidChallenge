package com.utejeiro.nimbleandroid.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.utejeiro.nimbleandroid.ui.screens.components.MyTextFieldComponent
import com.utejeiro.nimbleandroid.ui.theme.NimbleAndroidChallengeTheme
import com.utejeiro.nimbleandroid.R
import com.utejeiro.nimbleandroid.data.login.LoginUIEvent
import com.utejeiro.nimbleandroid.data.login.LoginViewModel
import com.utejeiro.nimbleandroid.ui.screens.components.ButtonComponent
import com.utejeiro.nimbleandroid.ui.screens.components.PasswordTextFieldComponent

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    Surface(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize()
            .background(color = Color(0xFF000000))
    )  {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds
        )
        Box (
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0x00000000),
                            Color(0xFF000000)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ){
            Column (
                modifier = Modifier
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Image(
                    painter = painterResource(id = R.drawable.logo_white),
                    modifier = Modifier
                        .width(168.dp)
                        .height(40.dp),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )

                Spacer(modifier = Modifier.height(109.dp))

                MyTextFieldComponent(labelValue = stringResource(id = R.string.login),
                    onTextChanged = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )
                Spacer(modifier = Modifier.height(20.dp))

                PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(20.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.login),
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    NimbleAndroidChallengeTheme {
        LoginScreen()
    }
}