package com.baishakhee.jetpackcomposefirstSample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import androidx.navigation.compose.rememberNavController
import com.baishakhee.jetpackcomposefirstSample.ui.theme.JetpackComposeTheme
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavGraph(navController = navController)
        }

    }
}


@Composable
fun LoginScreenContent(navController: NavController) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    JetpackComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.size(200.dp, 100.dp)
                ) {
                    // Empty row, you can place elements here if needed
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting("Welcome To Login Screen")
                    }
                }
                Row(
                        horizontalArrangement = Arrangement.Start,
                modifier = Modifier.size(200.dp, 50.dp)
                ) {
                // Empty row, you can place elements here if needed
            }

                Row(
                    horizontalArrangement = Arrangement.Start
                ) {
                    UserNameText()
                }
                UserNameTextField(
                    userName = userName,
                    onUserNameChange = { userName = it }
                )
                Row(
                    horizontalArrangement = Arrangement.Start
                ) {
                    PasswordText()
                }
                PasswordTextField(
                    password = password,
                    onPasswordChange = { password = it }
                )

                Row(
                    horizontalArrangement = Arrangement.End
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                         ForgotText()
                    }
                }
                LoginButton(onLoginClick = {
                    // Navigate to MainActivity when the login button is clicked
                    navController.navigate(MainDestinations.HOME_ROUTE)
                })
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.End
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                         NewUserText(navController)
                    }
                }

            }
        }
    }
}





