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
import com.utejeiro.nimbleandroid.ui.screens.components.MyTextFieldComponent
import com.utejeiro.nimbleandroid.ui.theme.NimbleAndroidChallengeTheme
import com.utejeiro.nimbleandroid.R
import com.utejeiro.nimbleandroid.ui.screens.components.ButtonComponent
import com.utejeiro.nimbleandroid.ui.screens.components.PasswordTextFieldComponent

@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .padding(0.dp)
            .width(375.dp)
            .height(812.dp)
            .background(color = Color(0xFF000000))
    )  {
        Image(
            painter = painterResource(id = R.drawable.background_full),
            contentDescription = "image description",
            contentScale = ContentScale.FillHeight
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
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Image(
                    painter = painterResource(id = R.drawable.logo_white),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )

                Spacer(modifier = Modifier.height(109.dp))

                MyTextFieldComponent(labelValue = stringResource(id = R.string.login),
                    painterResource(id = R.drawable.message),
                    onTextChanged = {},
                    errorStatus = false
                )
                PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password),
                    painterResource(id = R.drawable.lock),
                    onTextSelected = {},
                    errorStatus = false
                )

                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.login),
                    onButtonClicked = {
                    },
                    isEnabled = false
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