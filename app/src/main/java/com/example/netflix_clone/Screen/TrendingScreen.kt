package com.example.netflix_clone.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.netflix_clone.Model.Data.Movie
import com.example.netflix_clone.Model.Data.TrendingScreenData
import com.example.netflix_clone.R

@Composable
fun TrendingScreen(navController: NavHostController) {
    val selectedIcon = remember { mutableStateOf(IconType.Home) }
    Scaffold(
        modifier = Modifier.background(color = Color.Black),
        bottomBar = {
            BottomBar(
                selectedIcon = selectedIcon.value,
                onClickHome = { selectedIcon.value = IconType.Home;navController.navigate("TrendingScreen") },
                onClickSearch = { navController.navigate("search") },
                onClickFavorite = { navController.navigate("favorite") },
                onClickPerson = { navController.navigate("Profile") }
            )
        }


    ) { innerpadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(innerpadding)
                .background(color = Color.Black)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(70.dp)
                    .background(color = Color.Black),
                horizontalArrangement = Arrangement.Absolute.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.netflix_logo2),
                    contentDescription = "Image",
                    modifier= Modifier
                        .size(width = 200.dp, height = 65.dp)
                        .background(color = Color.Black)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(0.5f))
                val onClickTrending = { navController.navigate("TrendingScreen") }
                val onClickMovies = { navController.navigate("MovieScreen") }
                val onClickSeries = { navController.navigate("SeriesScreen") }
                TextButton(onClick = onClickTrending) {
                    Text("Trending", color = Color.Red,fontSize = 18.sp, style = MaterialTheme.typography.bodyMedium)
                }
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = onClickMovies) {
                    Text("Movies", color = Color.White,fontSize = 18.sp, style = MaterialTheme.typography.bodyMedium)
                }
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = onClickSeries) {
                    Text("Series", color = Color.White,fontSize = 18.sp, style = MaterialTheme.typography.bodyMedium)
                }
                Spacer(modifier = Modifier.weight(0.5f))
            }
            ScrollItems(navController)
        }
    }
}
@Composable
fun Card(movies: Movie, navController: NavHostController) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .background(color = Color.Black)
            .clickable{navController.navigate("youtube/${movies.id}")},
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(color = Color.Gray)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movies.image)
                    .allowHardware(false) // disable hardware acceleration to reduce memory usage
                    .build(),
                contentDescription = movies.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(6.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = movies.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black,
                    maxLines = 1
                )
                Text(
                    text = movies.genre,
                    fontSize = 12.sp,
                    color = Color.Black,
                    maxLines = 1
                )
                Text(
                    text = "Rating: ${movies.rating}",
                    fontSize = 10.sp,
                    color = Color.Black
                )
            }
        }
    }
}
@Composable
fun Trending_Now(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row {
            Text(
                text = "Trending Now",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Movie cards row
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 10.dp),

            ) {
            items(TrendingScreenData.trendingnow) { movie->
                Card(movies = movie, navController = navController)
            }
        }
    }
}
@Composable
fun Recommended(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row {
            Text(
                text = "Recomended for you ",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(65.dp))
            TextButton(
                onClick = { /* Handle view all click */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "View all >", color = Color.Red)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Movie cards row
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 10.dp),
        ) {
            items(TrendingScreenData.recommended) {movie->
                Card(movies = movie, navController = navController)
            }
        }
    }
}
@Composable
fun Watch_it_Again(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row {
            Text(
                text = "Watch it Again",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(115.dp))
            TextButton(
                onClick = { /* Handle view all click */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "View all >", color = Color.Red)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
            items( items=TrendingScreenData.watch_it,
                key = {
                    it.id
                }) { movie->
                Card(movies = movie, navController = navController)
            }
        }
    }
}

@Composable
fun ScrollItems(navController: NavHostController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Trending_Now(navController)
        Recommended(navController)
        Watch_it_Again(navController)
    }
}
