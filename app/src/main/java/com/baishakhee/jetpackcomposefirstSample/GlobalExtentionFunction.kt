package com.baishakhee.jetpackcomposefirstSample

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

// Text

@Composable
fun Greeting2(title: String) {
    Text(
        text = "$title",
        color = colorResource(id = R.color.green),

        )

}

@Composable
fun Greeting(title: String) {
    Text(
        text = "$title",
        color = colorResource(id = R.color.green),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )

}

@Composable
fun UserNameText() {
    Text(
        text = "User Name",
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp)
            .wrapContentWidth(Alignment.Start),
        color = colorResource(id = R.color.black),
    )
}

@Composable
fun PasswordText() {
    Text(
        text = "Password",
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp)
            .wrapContentWidth(Alignment.Start),
        color = colorResource(id = R.color.black),
    )
}


@Composable
fun MobileNumberText() {
    Text(
        text = "Mobile Number",
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp)
            .wrapContentWidth(Alignment.Start),
        color = colorResource(id = R.color.black),
    )
}

@Composable
fun EmailIdText() {
    Text(
        text = "Email Id",
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp)
            .wrapContentWidth(Alignment.Start),
        color = colorResource(id = R.color.black),
    )
}

@Composable
fun AddressText() {
    Text(
        text = "Addresss",
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp)
            .wrapContentWidth(Alignment.Start),
        color = colorResource(id = R.color.black),
    )
}
// TextField

@Composable
fun UserNameTextField(userName: String, onUserNameChange: (String) -> Unit) {
    TextField(
        value = userName,
        onValueChange = onUserNameChange,
        placeholder = { Text(text = "Username") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),

        )
}

@Composable
fun PasswordTextField(password: String, onPasswordChange: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = onPasswordChange,
        placeholder = { Text(text = "Password") },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}


@Composable
fun MobileNumberTextField(userName: String, onUserNameChange: (String) -> Unit) {
    TextField(
        value = userName,
        onValueChange = onUserNameChange,
        placeholder = { Text(text = "Mobile Number") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),

        )
}
@Composable
fun EmailIdTextField(userName: String, onUserNameChange: (String) -> Unit) {
    TextField(
        value = userName,
        onValueChange = onUserNameChange,
        placeholder = { Text(text = "Email ID") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),

        )
}
@Composable
fun AddressTextField(userName: String, onUserNameChange: (String) -> Unit) {
    TextField(
        value = userName,
        onValueChange = onUserNameChange,
        placeholder = { Text(text = "Address") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),

        )
}

@Composable
fun LoginButton(activity: ComponentActivity) {
    val startMainActivity = activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        // Handle the result here if needed
    }

    Button(
        onClick = {
            // Perform login action here
            // If login is successful, start the MainActivity
            startMainActivity.launch(Intent(activity, MainActivity::class.java))
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = "Login", fontSize = 18.sp)
    }
}
/*@Composable
fun LoginButton(onLoginClick: () -> Unit) {
    Button(
        onClick = {
 },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = "Login", fontSize = 18.sp)
    }
}*/

@Composable
fun LoginButton(onLoginClick: () -> Unit) {
    Button(
        onClick = onLoginClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = "Login", fontSize = 18.sp)
    }
}

@Composable
fun RegitrationButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(MainDestinations.HOME_ROUTE)
 },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = "Regitration", fontSize = 18.sp)
    }
}

@Composable
fun NewUserText(navController: NavController) {
    Text(
        text = "New User ? Create Account",
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp)
            .wrapContentWidth(Alignment.End)
            .clickable { navController.navigate(MainDestinations.REGISTRATION_ROUTE) },
        color = Color(R.color.red),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End
    )
}

@Composable
fun ExistUserText(navController: NavController) {
    Text(
        text = "Exist User ? Login",
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp)
            .wrapContentWidth(Alignment.End)
            .clickable { navController.navigate(MainDestinations.LOGIN_ROUTE) },
        color = colorResource(id = R.color.red),// Use colorResource instead of Color
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End // Optionally, you can specify the text alignment

    )
}

@Composable
fun ForgotText() {
    Text(
        text = "Forgot Password ? ",
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp)
            .wrapContentWidth(Alignment.End),
        color = colorResource(id = R.color.red),// Use colorResource instead of Color
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End // Optionally, you can specify the text alignment

    )



}
@Composable
fun GenderText() {
    Text(
        text = "Gender",
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp)
            .wrapContentWidth(Alignment.Start),
        color = colorResource(id = R.color.black),// Use colorResource instead of Color
        textAlign = TextAlign.Start // Optionally, you can specify the text alignment

    )



}
@Composable
fun GenderSelection(onGenderSelected: (String) -> Unit) {
    var selectedGender by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {


        RadioButton(
            selected = selectedGender == "Male",
            onClick = { selectedGender = "Male"; onGenderSelected("Male") },
            modifier = Modifier.padding(end = 8.dp)
        )
        Text("Male", modifier = Modifier.clickable { selectedGender = "Male"; onGenderSelected("Male") })

        RadioButton(
            selected = selectedGender == "Female",
            onClick = { selectedGender = "Female"; onGenderSelected("Female") },
            modifier = Modifier.padding(start = 16.dp, end = 8.dp)
        )
        Text("Female", modifier = Modifier.clickable { selectedGender = "Female"; onGenderSelected("Female") })
    }
}



@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun HomeScreenContent(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(20) { index ->
            Text("Item $index")
        }
    }
}

@Composable
fun AccountScreenContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Account Screen Content")
    }
}

@Composable
fun SettingsScreenContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Settings Screen Content")
    }
}
@Composable
fun NotificationScreenContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Notification Screen Content")
    }
}@Composable
fun FavoriteScreenContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Favorite Screen Content")
    }
}

