@Composable
fun NetflixScreen() {
    Scaffold(
        modifier = Modifier.background(color=Color.Black),
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black, modifier = Modifier
                    .clip(RoundedCornerShape(50.dp)),
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Home, contentDescription = "Localized description")
                    }
                    Spacer(modifier = Modifier.weight(0.5f, true))
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Localized description",
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.5f, true))
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.5f, true))
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Localized description",
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
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
                    painter = painterResource(id = R.drawable.netflix_logo),
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
