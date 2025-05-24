package com.example.starvault.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.starvault.ui.components.ContentCards
import com.example.starvault.ui.theme.orbitron

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            SearchSection("")
            Text("Other Albums", modifier = modifier.padding(start = 20.dp), fontFamily = orbitron, style = MaterialTheme.typography.titleMedium)
            LazyRow(
                modifier.padding(start = 10.dp)
            ) {
                repeat(12) {
                    item {
                        ContentCards({  })
                    }
                }
            }
            Text("Search Results", modifier = modifier.padding(start = 20.dp), fontFamily = orbitron, style = MaterialTheme.typography.titleMedium)
            LazyVerticalGrid(
                columns = GridCells.Adaptive(160.dp),
                modifier = Modifier.fillMaxWidth().height(550.dp).padding(start = 10.dp),
                content = {
                    repeat(16) {
                        item {
                            ContentCards({  })
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun SearchSection(searchString: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 18.dp, end = 10.dp, bottom = 10.dp, top = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(40.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(
                    color = MaterialTheme.colorScheme.surfaceContainer,
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.CenterStart,
        ) {
            if (searchString == "") {
                Text(
                    text = "Explore the universe",
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                )
            }
            BasicTextField(
                value = "",
                onValueChange = {  },
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.secondary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp)
            )
        }
//        ButtonWithIcon(Icons.Rounded.Search, { homeViewModel.searchItems(searchString, context) }, tint = MaterialTheme.colorScheme.onSurface, bgColor = colorResource(R.color.btn))
    }
}
