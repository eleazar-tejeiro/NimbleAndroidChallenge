package com.utejeiro.nimbleandroid.ui.screens.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.utejeiro.nimbleandroid.ui.theme.NimbleAndroidChallengeTheme

@Composable
fun Home() {
    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Composable
    fun GreetingPreview() {
        NimbleAndroidChallengeTheme {
            Greeting("Android")
        }
    }
}