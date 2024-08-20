package com.example.netflix_clone.Screen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.netflix_clone.Model.Data.Firebase.auth

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val sharedPrefs = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
    var name by remember { mutableStateOf(sharedPrefs.getString("name", "") ?: "") }
    val email by remember { mutableStateOf(sharedPrefs.getString("email", "") ?: "") }
    var showLogoutDialog by remember { mutableStateOf(false) }
    val selectedIcon = remember { mutableStateOf(IconType.Home) }
    Scaffold(
        modifier = Modifier
            .background(color = Color.Black),
        bottomBar = {
            BottomBar(
                selectedIcon = IconType.Person,
                onClickHome = { navController.navigate("home");navController.navigate("TrendingScreen")},
                onClickSearch = { navController.navigate("search") },
                onClickFavorite = { navController.navigate("favorite") },
                onClickPerson = { selectedIcon.value = IconType.Person }
            )
        }
    ) { innerpadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerpadding)
                .background(color = Color.Black),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text= "Profile ",color=Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(20.dp),
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name", color = Color.White) },
                modifier = Modifier.fillMaxWidth().padding(start=6.dp,end=6.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.weight(1f))
            OutlinedTextField(
                value = email,
                onValueChange = {  },
                label = { Text("Email", color = Color.White) },
                modifier = Modifier.fillMaxWidth().padding(start=6.dp,end=6.dp),
                textStyle = TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.weight(1.5f))
            Button(
                onClick = {
                    // Save the updated profile information
                    with(sharedPrefs.edit()) {
                        putString("name", name)
                        putString("email",email)
                        apply()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start=6.dp,end=6.dp)
                    .background(color = Color.Black),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Save Changes", color = Color.White)
                }
            }
            ProfileOptionButton("Account Settings") {}
            ProfileOptionButton("Help") {}
            ProfileOptionButton("Log Out?") { showLogoutDialog = true }
        }
    }
    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = { Text("Log Out", color = Color.White) },
            text = { Text("Are you sure you want to log out?",color=Color.White) },
            containerColor = Color.Black,
            modifier = Modifier.background(color=Color.Transparent),
            confirmButton = {
                Button(
                    onClick = {
                        showLogoutDialog = false
                        // Log out user and navigate to login screen
                        auth.signOut()
                        navController.navigate("netflix_screen")
                    },
                    modifier = Modifier.background(color = Color.Black)
                ) {
                    Text("Yes",color=Color.White, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showLogoutDialog = false
                    }
                ) {
                    Text("No",color=Color.White, fontWeight = FontWeight.Bold)
                }
            }
        )
    }
}
@Composable
fun ProfileOptionButton(optionText: String, onClick: () -> Unit) {
    if (optionText == "Log Out?") {
        TextButton(
            onClick = onClick,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(text = optionText, color = Color.White)
        }
    }
    else {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Color.Black)
                .padding(start=6.dp,end=6.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)


        )
        {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = optionText, color = Color.White)
            }
        }
    }
}