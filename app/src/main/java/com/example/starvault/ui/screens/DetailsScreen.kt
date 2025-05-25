package com.example.starvault.ui.screens

import ItemsData
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.starvault.R
import com.example.starvault.ui.components.ErrorScreen
import com.example.starvault.ui.components.IconText
import com.example.starvault.ui.components.LoadingScreen
import com.example.starvault.ui.theme.orbitron
import com.example.starvault.ui.theme.poppins


@Composable
fun DetailScreen(imgId: String,
                 modifier: Modifier = Modifier,
                 detailViewModel: DetailViewModel = viewModel()
) {
    val detailUIState = detailViewModel.detailUIState
    LaunchedEffect(imgId) {
        detailViewModel.getData(imgId)
    }

    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        when(detailUIState) {
            is DetailUIState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    item {
                        ImageView(detailUIState.data)
                    }
                    item {
                        ImageSelector(detailUIState.data)
                    }
                    item {
                        Description(detailUIState.data)
                    }
                }
            }
            is DetailUIState.Error -> ErrorScreen("Failed to Fetch Data")
            is DetailUIState.Loading -> LoadingScreen("Fetching Data")
        }
    }
}

@Composable
fun TopBar(text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineSmall,
            fontFamily = orbitron,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primaryContainer
        )
    }
}

@Composable
fun DetailImages(link: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.width(150.dp).height(150.dp).padding(bottom = 10.dp, start = 10.dp).border(1.dp,
            MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(10.dp)),
    ) {
        Box(modifier.fillMaxSize()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(link)
                    .error(R.drawable.bg)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.6f,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun ImageView(data: List<ItemsData>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(350.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data[0].links?.get(0)?.href)
                .error(R.drawable.bg)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.6f,
            modifier = Modifier.fillMaxSize()
        )
        TopBar(data[0].data[0].title.toString(), Modifier.align(Alignment.TopCenter))
        Box(Modifier
            .align(Alignment.BottomEnd)
            .padding(10.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = stringResource(R.string.adc_center),
                    tint = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.size(26.dp)
                )
                Text(
                    text = data[0].data[0].center.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

@Composable
fun ImageSelector(data: List<ItemsData>, modifier: Modifier = Modifier) {
    Text("Other Images", modifier = modifier.padding(15.dp), fontFamily = orbitron, style = MaterialTheme.typography.titleMedium)
    LazyRow(
        modifier = modifier.padding(vertical = 1.dp)
    ) {
        items(data[0].links!!.size) { num ->
            DetailImages(data[0].links!![num].href )
        }
    }
}

@Composable
fun Description(data: List<ItemsData>, modifier: Modifier = Modifier) {
    Text("Description", modifier = modifier.padding(15.dp), fontFamily = orbitron, style = MaterialTheme.typography.titleMedium)
    Text(
        data[0].data[0].description.toString(),
        modifier = modifier.padding(horizontal = 15.dp, vertical = 2.dp),
        fontFamily = poppins,
        style = MaterialTheme.typography.bodyMedium
    )
}

