package com.example.starvault.ui.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.starvault.R
import com.example.starvault.ui.components.IconText
import com.example.starvault.ui.theme.orbitron
import com.example.starvault.ui.theme.poppins


@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            item {
                ImageView()
                ImageSelector()
                Description()
            }
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Earth",
            style = MaterialTheme.typography.headlineSmall,
            fontFamily = orbitron,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primaryContainer
        )
    }
}

@Composable
fun DetailImages(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.width(150.dp).height(150.dp).padding(bottom = 10.dp, start = 5.dp).border(1.dp,
            MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(10.dp)),
    ) {
        Box(modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.bg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.8f
            )
        }
    }
}

@Composable
fun ImageView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(350.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.8f
        )
        TopBar(Modifier.align(Alignment.TopCenter))
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
                    text = stringResource(R.string.adc_center),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

@Composable
fun ImageSelector(modifier: Modifier = Modifier) {
    Text("Other Images", modifier = modifier.padding(15.dp), fontFamily = orbitron, style = MaterialTheme.typography.titleMedium)
    LazyRow(
        modifier = modifier.padding(vertical = 1.dp)
    ) {
        repeat(6) {
            item {
                DetailImages()
            }
        }
    }
}

@Composable
fun Description(modifier: Modifier = Modifier) {
    Text("Description", modifier = modifier.padding(15.dp), fontFamily = orbitron, style = MaterialTheme.typography.titleMedium)
    Text(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        modifier = modifier.padding(horizontal = 15.dp, vertical = 2.dp),
        fontFamily = poppins,
        style = MaterialTheme.typography.bodyMedium
    )
}

