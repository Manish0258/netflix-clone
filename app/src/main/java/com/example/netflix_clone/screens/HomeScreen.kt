@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("NETFLIX", color = Color.Red) },
                Modifier.background(color=Color.Black)
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black, modifier = Modifier.clip(RoundedCornerShape(5.dp)),
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Home, contentDescription = "Localized description")
                    }
                    Spacer(modifier = Modifier.weight(1f, true))
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Localized description",
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f, true))
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f, true))
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
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text("Trending", color = Color.White,fontSize = 18.sp, style = MaterialTheme.typography.bodySmall)
                }
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = { /*TODO*/ }) {
                    Text("Movies", color = Color.White,fontSize = 18.sp, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodySmall)
                }
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = { /*TODO*/ }) {
                    Text("Up Coming", color = Color.White,fontSize = 18.sp, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodySmall)
                }

            }
        }
    }
}
