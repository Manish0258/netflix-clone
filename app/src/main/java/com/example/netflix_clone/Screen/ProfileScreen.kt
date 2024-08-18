package com.example.netflix_clone.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter

data class User(
    val name: String,
    val email: String,
    val profilePictureUrl: String
)
@Composable
fun ProfileScreen(navController: NavHostController) {
    val user = User(
        name = "chinmay sahoo ",
        email = "chinmaysahoo@gmail.com",
        profilePictureUrl = "https://www.gravatar.com/avatar/" +
                "2c7d99fe281ecd3bcd65ab915bac6dd5?s=250"
    )

    ProfilePage(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfilePage(navController: NavHostController) {
    var showLogoutDialog by remember { mutableStateOf(false) }
    val selectedIcon = remember { mutableStateOf(IconType.Home) }
    Scaffold(
        modifier = Modifier.background(color = Color.Black),
        bottomBar = {
            BottomBar(
                selectedIcon = IconType.Person,
                onClickHome = { navController.navigate("home");navController.navigate("TrendingScreen")},
                onClickSearch = { navController.navigate("search") },
                onClickFavorite = { navController.navigate("favorite") },
                onClickPerson = { selectedIcon.value = IconType.Person }
            )
        }
    ){innerpadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text= "Profile ",color=Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(16.dp),
                fontSize = 30.sp
                )
            Spacer(modifier = Modifier.height(32.dp))
//            ProfilePicture(imageUrl = user.profilePictureUrl)

            Spacer(modifier = Modifier.height(16.dp))
//            Text(
//                text = user.name,
//                style = MaterialTheme.typography.bodyMedium,
//                color = Color.White
//            )
            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = user.email,
//                style = MaterialTheme.typography.bodyMedium,
//                color = Color.Gray
//            )
            Spacer(modifier = Modifier.height(24.dp))
            ProfileOptionButton("Edit Profile") {
            }
            ProfileOptionButton("Account Settings") {
            }
            ProfileOptionButton("Help") {
            }
            ProfileOptionButton("Log Out?") {
                showLogoutDialog = true
            }
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
fun ProfilePicture(imageUrl: String) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(Color.Gray)
    ) {
        Image(
            painter = rememberImagePainter(data = imageUrl),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ProfileOptionButton(optionText: String, onClick: () -> Unit) {
    if (optionText == "Log Out?") {
        TextButton(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(100.dp)
        ) {
            Text(text = optionText, color = Color.White)
        }
    } else {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(50.dp)
                .background(color = Color.Black),
            shape = RoundedCornerShape(15.dp)
        )
        {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = optionText, color = Color.White)
            }
        }
    }
}
