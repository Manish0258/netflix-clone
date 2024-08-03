package com.example.netflix_clone.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflix_clone.R

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.background(color = Color.Black),
        bottomBar = {
            BottomBar(
                modifier = Modifier,
                onClickHome = { /* do something */ },
                onClickSearch = { /* do something */ },
                onClickFavorite = { /* do something */ },
                onClickPerson = { /* do something */ }
            )
        }


    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(paddingValues)
                .background(color=Color.Black)
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
                TextButton(onClick = { /*TODO*/ }) {
                    Text("Trending", color = Color.White,fontSize = 18.sp, style = MaterialTheme.typography.bodySmall)
                }
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = { /*TODO*/ }) {
                    Text("Movies", color = Color.White,fontSize = 18.sp, style = MaterialTheme.typography.bodySmall)
                }
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = { /*TODO*/ }) {
                    Text("Up Coming", color = Color.White,fontSize = 18.sp, style = MaterialTheme.typography.bodySmall)
                }

            }
        }
    }
}
@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    onClickHome: () -> Unit = {},
    onClickSearch: () -> Unit = {},
    onClickFavorite: () -> Unit = {},
    onClickPerson: () -> Unit = {}
) {
    BottomAppBar(
        containerColor = Color.Black,
        actions = {
            IconButton(onClick = onClickHome) {
                Icon(Icons.Filled.Home, contentDescription = "Localized description")
            }
            Spacer(modifier = Modifier.weight(0.5f, true))
            IconButton(onClick = onClickSearch) {
                Icon(Icons.Filled.Search, contentDescription = "Localized description")
            }
            Spacer(modifier = Modifier.weight(0.5f, true))
            IconButton(onClick = onClickFavorite) {
                Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
            }
            Spacer(modifier = Modifier.weight(0.5f, true))
            IconButton(onClick = onClickPerson) {
                Icon(Icons.Filled.Person, contentDescription = "Localized description")
            }
        }
    )
}