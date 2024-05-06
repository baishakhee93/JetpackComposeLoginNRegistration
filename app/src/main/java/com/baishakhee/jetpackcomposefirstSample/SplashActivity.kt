package com.baishakhee.jetpackcomposefirstSample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baishakhee.jetpackcomposefirstSample.ui.theme.JetpackComposeTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.baishakhee.jetpackcompose.R
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()

        enableEdgeToEdge()
        installSplashScreen()

        setContent {
            SplashScreenContent()
        }

        MainScope().launch {
            delay(2000) // Wait for 2 seconds
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }
    }
}
@Composable
fun SplashScreenContent() {
    val scale = remember { Animatable(1f) }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1.5f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting(
              "Welcome to Splash",)
            Image(
                painter = painterResource(id = R.drawable.logo_foreground),
                contentDescription = "Your Image",
                modifier = Modifier
                    .size(150.dp)
                    .graphicsLayer(
                        scaleX = scale.value,
                        scaleY = scale.value
                    ),
                contentScale = ContentScale.Fit
            )
        }
    }
}
/*
@Composable

fun SplashScreenContent() {
    JetpackComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
           Column(Modifier.fillMaxSize(),
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally) {
               Greeting(
                   name = "Welcome to Splash",
                   modifier = Modifier.padding(innerPadding)
               )
               Image(
                   painter = painterResource(id = R.drawable.logo_foreground),
                   contentDescription = "Your Image",
                   modifier = Modifier.size(150.dp),
                   contentScale = ContentScale.Fit
               )
           }

        }
    }
}
*/



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Greeting("Android")
        }
    }
}