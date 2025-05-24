package com.example.starvault.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.starvault.R
import com.example.starvault.ui.theme.poppins

@Composable
fun ContentCards(navigateToDetail: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.width(180.dp).height(180.dp).padding(bottom = 10.dp, start = 5.dp).border(1.dp,
            MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(10.dp)),
        onClick = { navigateToDetail() }
    ) {
        Box(modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.bg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.8f
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
