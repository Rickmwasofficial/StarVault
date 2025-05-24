package com.example.starvault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.starvault.ui.components.IconText
import com.example.starvault.ui.screens.BookMarkScreen
import com.example.starvault.ui.screens.DetailScreen
import com.example.starvault.ui.screens.HomeScreen
import com.example.starvault.ui.screens.HomeUIState
import com.example.starvault.ui.screens.HomeViewModel
import com.example.starvault.ui.screens.SearchScreen
import com.example.starvault.ui.theme.StarVaultTheme
import kotlinx.serialization.Serializable

@Serializable
object Home
@Serializable
object Search
@Serializable
object Bookmark
@Serializable
object Detail

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            StarVaultTheme {
                val navHostController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.surface,
                    bottomBar = {
                        BottomAppBar(
                            modifier = Modifier.fillMaxWidth().height(110.dp),
                            containerColor = MaterialTheme.colorScheme.surface,
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                IconText(R.drawable.planet_24dp_e3e3e3_fill0_wght400_grad0_opsz24, R.string.home, { navHostController.navigate(Home) }, Modifier.weight(1f))
                                IconText(R.drawable.search_24dp_e3e3e3_fill0_wght400_grad0_opsz24, R.string.search, { navHostController.navigate(Search) }, Modifier.weight(1f))
                                IconText(R.drawable.bookmark_24dp_e3e3e3_fill0_wght400_grad0_opsz24, R.string.bookmarks, { navHostController.navigate(Bookmark) }, Modifier.weight(1f))
                            }
                        }
                    }
                ) { innerPadding ->
                    AppNavHost(navHostController = navHostController, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppNavHost(navHostController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navHostController,
        startDestination = Home,
        modifier = modifier
    ) {
        composable<Home> {
            HomeScreen(
                navigateToDetail = { navHostController.navigate(Detail) }
            )
        }
        composable<Search> {
            SearchScreen()
        }
        composable<Bookmark> {
            BookMarkScreen()
        }
        composable<Detail> {
            DetailScreen()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StarVaultTheme {
        AppNavHost(rememberNavController())
    }
}