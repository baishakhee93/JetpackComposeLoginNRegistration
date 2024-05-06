package com.baishakhee.jetpackcomposefirstSample

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

object MainDestinations {
    const val LOGIN_ROUTE = "login"
    const val REGISTRATION_ROUTE = "registration"
    const val HOME_ROUTE = "home"
    const val SETTING = "setting"

}


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MainDestinations.LOGIN_ROUTE) {
        composable(MainDestinations.LOGIN_ROUTE) {
            LoginScreenContent(navController = navController)
        }
        composable(MainDestinations.REGISTRATION_ROUTE) {
            RegistrationScreenContent(navController = navController)
        }
        composable(MainDestinations.HOME_ROUTE) {
            HomeScreen(navController = navController)
        }

    }
}
