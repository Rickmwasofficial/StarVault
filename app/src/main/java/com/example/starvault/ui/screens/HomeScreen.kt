package com.example.starvault.ui.screens

import Data
import ItemsData
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.IntrinsicSize
import com.example.starvault.ui.components.ContentCards
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.starvault.R
import com.example.starvault.ui.components.ErrorScreen
import com.example.starvault.ui.components.LoadingScreen
import com.example.starvault.ui.theme.orbitron
import com.example.starvault.ui.theme.poppins
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
   navigateToDetail: (String) -> Unit,
   homeViewModel: HomeViewModel,
   modifier: Modifier = Modifier,
) {
    val homeUIState: HomeUIState = homeViewModel.homeUIState
    Surface(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            HomeNavBar()
            when(homeUIState) {
                is HomeUIState.Success -> {
//                    HomeCategories()
                    PullToRefreshBox(
                        isRefreshing = homeUIState.isRefreshing,
                        onRefresh = { homeViewModel.refresh() },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        LazyColumn(
                            modifier = Modifier.padding(top = 10.dp)
                        ) {
                            item {
                                HomeTopFeed(homeUIState.data, navigateToDetail)
                                HomeContent(homeUIState.listData, homeUIState.category1, homeUIState.category2, homeViewModel, navigateToDetail)
                            }
                        }
                    }
                }
                is HomeUIState.Error -> ErrorScreen("Failed to Fetch Images")
                is HomeUIState.Loading -> LoadingScreen("Fetching Data")
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
fun FeedCard(id: String, title: String, description: String, imgLink: String, navigateToDetail: (String) -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.width(340.dp).height(200.dp).padding(end = 10.dp).shadow(
            elevation = 3.dp,
            ambientColor = MaterialTheme.colorScheme.primaryContainer,
            shape = RoundedCornerShape(10.dp),
            spotColor = MaterialTheme.colorScheme.primaryContainer,
            clip = true
        ),
        onClick = { navigateToDetail(id) },
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Box(modifier.fillMaxSize()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imgLink)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.6f,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomStart).padding(15.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                Text(
                    text = title,
                    fontFamily = poppins,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = description,
                    fontFamily = poppins,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3
                )
            }
        }
    }
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun HomeTopFeed(data: List<ItemsData>, navigateToDetail: (String) -> Unit, modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val snapperFlingBehavior = rememberSnapperFlingBehavior(lazyListState = listState)
    LazyRow(
        state = listState,
        flingBehavior = snapperFlingBehavior,
        contentPadding = PaddingValues(horizontal = 15.dp), // Adjust so item can center
        horizontalArrangement = Arrangement.spacedBy(7.5.dp),
        modifier = modifier.fillMaxWidth(),
    ) {
        items(data.size) { num ->
            FeedCard(data[num].data[0].nasaId, data[num].data[0].title.toString(), data[num].data[0].description.toString(), data[num].links?.get(0)?.href.toString(), navigateToDetail)
        }
    }
}

@Composable
fun ContentHeader(title: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            title,
            fontFamily = poppins,
            style = MaterialTheme.typography.titleSmall
        )
        TextButton(onClick = { onClick() }, colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            disabledContentColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.primaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.surface
        )) {
            Text(
                "Shuffle",
                fontFamily = poppins,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Composable
fun HomeContent(data: List<ItemsData>, category1: List<ItemsData>, category2: List<ItemsData>, homeViewModel: HomeViewModel, navigateToDetail: (String) -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        ContentHeader("Latest", { homeViewModel.shuffleListData() })
        LazyRow {
            items(data.size) { num ->
                ContentCards(data[num].data[0].nasaId, data[num].links?.get(0)?.href.toString(), data[num].data[0].title.toString(), navigateToDetail)
            }
        }
        ContentHeader(category1[0].data[0].keywords?.get(0) ?: "Null", { homeViewModel.shuffleCat1Data() })
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            modifier = Modifier.fillMaxWidth().heightIn(max = 550.dp).wrapContentHeight(),
            content = {
                items(category1.size) { num ->
                    if (num <= 5) {
                        ContentCards(category1[num].data[0].nasaId, category1[num].links?.get(0)?.href.toString(), category1[num].data[0].title.toString(), navigateToDetail)
                    }
                }
            }
        )
        ContentHeader(category2[0].data[0].keywords?.get(0) ?: "Null", { homeViewModel.shuffleCat2Data() })
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            modifier = Modifier.fillMaxWidth().heightIn(max = 550.dp).wrapContentHeight(),
            content = {
                items(category2.size) { num ->
                    if (num <= 5) {
                        ContentCards(category2[num].data[0].nasaId, category2[num].links?.get(0)?.href.toString(), category2[num].data[0].title.toString(), navigateToDetail)
                    }
                }
            }
        )
    }
}