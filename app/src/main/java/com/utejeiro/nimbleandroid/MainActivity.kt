package com.utejeiro.nimbleandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.utejeiro.nimbleandroid.app.PostApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostApp()
        }
    }
}
@Preview
@Composable
fun DefaultPreview(){
    PostApp()
}