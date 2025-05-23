package com.example.starvault.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.starvault.R
import com.example.starvault.ui.theme.orbitron
import com.example.starvault.ui.theme.poppins
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            HomeNavBar()
            HomeCategories()
            LazyColumn {
                item {
                    HomeTopFeed()
                    HomeContent()
                }
            }
        }
    }
}

@Composable
fun HomeNavBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(top = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.titleLarge,
            fontFamily = orbitron
        )
    }
}

@Composable
fun CategoryBtn(onClick: () -> Unit, text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { onClick() },
        modifier = modifier.border(1.dp, MaterialTheme.colorScheme.primaryContainer,
            RoundedCornerShape(10.dp)
        ).height(35.dp).padding(horizontal = 3.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            disabledContentColor = MaterialTheme.colorScheme.onSurface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            disabledContainerColor = MaterialTheme.colorScheme.surface
        ),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        Text(
            text,
            fontFamily = poppins
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeCategories(modifier: Modifier = Modifier) {
    val categories = listOf("All", "Stars", "Comets", "Solar System", "Planets", "Moon")
    LazyRow(
        modifier = modifier.padding(horizontal = 10.dp, vertical = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(categories.size) { item ->
            CategoryBtn({  }, categories[item], Modifier.padding(2.dp))
        }
    }
}

@Composable
fun FeedCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.width(340.dp).height(200.dp).padding(end = 10.dp).shadow(
            elevation = 3.dp,
            ambientColor = MaterialTheme.colorScheme.primaryContainer,
            shape = RoundedCornerShape(10.dp),
            spotColor = MaterialTheme.colorScheme.primaryContainer,
            clip = true
        ),
    ) {
        Box(modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.bg),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomStart).padding(15.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                Text(
                    text = "Planets of the solar system",
                    fontFamily = poppins,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Lorem Ipsum dolor sit amet, consetetur sadipscing elitr, sed edium nonumy eirmod tempor invidunt",
                    fontFamily = poppins,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun HomeTopFeed(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val snapperFlingBehavior = rememberSnapperFlingBehavior(lazyListState = listState)
    LazyRow(
        state = listState,
        flingBehavior = snapperFlingBehavior,
        contentPadding = PaddingValues(horizontal = 15.dp), // Adjust so item can center
        horizontalArrangement = Arrangement.spacedBy(7.5.dp),
        modifier = modifier.fillMaxWidth(),
    ) {
        repeat(8) {
            item {
                FeedCard()
            }
        }
    }
}

@Composable
fun ContentHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Popular Images",
            fontFamily = poppins,
            style = MaterialTheme.typography.titleMedium
        )
        TextButton(onClick = {  }, colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            disabledContentColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.primaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.surface
        )) {
            Text(
                "See More",
                fontFamily = poppins,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        ContentHeader()
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            modifier = Modifier.fillMaxWidth().height(600.dp),
            content = {
                repeat(14) {
                    item {
                        Card(
                            modifier = modifier.width(180.dp).height(180.dp).padding(bottom = 10.dp, start = 5.dp).border(1.dp,
                                MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(10.dp)),
                        ) {
                            Box(modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(R.drawable.bg),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                                Column(
                                    modifier = Modifier.fillMaxWidth().align(Alignment.BottomStart).padding(5.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(7.dp)
                                ) {
                                    Text(
                                        text = "Planets of the solar system",
                                        fontFamily = poppins,
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}