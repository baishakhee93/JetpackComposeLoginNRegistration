package com.baishakhee.jetpackcomposefirstSample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.baishakhee.jetpackcomposefirstSample.ui.theme.JetpackComposeTheme

class RegistrationActivity : ComponentActivity() {
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
fun RegistrationScreenContent(navController: NavHostController) {

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    JetpackComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
            ) {
                item {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.size(200.dp, 20.dp)
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
                            Greeting("Welcome for Regitration Screen")
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.size(200.dp, 10.dp)
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
                        MobileNumberText()
                    }
                    MobileNumberTextField(
                        userName = userName,
                        onUserNameChange = { userName = it }
                    )
                    Row(
                        horizontalArrangement = Arrangement.Start
                    ) {
                        EmailIdText()
                    }
                    EmailIdTextField(
                        userName = userName,
                        onUserNameChange = { userName = it }
                    )
                    Row(
                        horizontalArrangement = Arrangement.Start
                    ) {
                        AddressText()
                    }
                    AddressTextField(
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
                        horizontalArrangement = Arrangement.Start
                    ) {
                        GenderText()
                    }
                    GenderSelection { gender ->
                        selectedGender = gender
                    }

                    RegitrationButton(navController)

                    Row(
                        horizontalArrangement = Arrangement.End
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            ExistUserText(navController)
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.size(200.dp, 30.dp)
                    ) {
                        // Empty row, you can place elements here if needed
                    }

                }
            }
        }
    }
}
