package com.example.netflix_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.netflix_clone.Screen.FavoriteScreen
import com.example.netflix_clone.Screen.HomeScreen
import com.example.netflix_clone.Screen.MoviesScreen
import com.example.netflix_clone.Screen.NetflixLoginPage
import com.example.netflix_clone.Screen.NetflixScreen
import com.example.netflix_clone.Screen.NetflixSignUpPage
import com.example.netflix_clone.Screen.ProfileScreen
import com.example.netflix_clone.Screen.SearchScreen
import com.example.netflix_clone.Screen.SeriesScreen
import com.example.netflix_clone.Screen.TrendingScreen
import com.example.netflix_clone.Screen.YoutubePlayer
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "netflix_screen") {
        composable("netflix_screen") {
            NetflixScreen(navController = navController)
        }
        composable("netflix_login") {
            NetflixLoginPage(navController = navController)
        }
        composable("netflix_signup") {
            NetflixSignUpPage(navController = navController)
        }
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("favorite") {
            FavoriteScreen(navController=navController)
        }
        composable("search") {
            SearchScreen()
        }
        composable("TrendingScreen") {
            TrendingScreen(navController = navController)
        }
        composable("MovieScreen") {
            MoviesScreen(navController = navController)
        }
        composable("Seriesscreen") {
            SeriesScreen(navController = navController)
        }
        composable("Profile") {
            ProfileScreen(navController = navController)
        }
        composable("youtube/{id}") { backStackEntry ->
            YoutubePlayer(youtubeVideoId = backStackEntry.arguments?.getString("id") ?: "")
        }
    }
}