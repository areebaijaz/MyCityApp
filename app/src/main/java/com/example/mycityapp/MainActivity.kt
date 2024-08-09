package com.example.mycityapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycityapp.ui.theme.CityApp
import com.example.mycityapp.ui.theme.MyCityAppTheme

data class BottomNavigationItem(
    val title: String,
    val selected: ImageVector,
    val unselected: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val items = listOf(
                BottomNavigationItem(
                    title = "Home",
                    selected = Icons.Filled.Home,
                    unselected = Icons.Outlined.Home,
                    hasNews = false,
                ),
                BottomNavigationItem(
                    title = "Chat",
                    selected = Icons.Filled.Email,
                    unselected = Icons.Outlined.Email,
                    hasNews = false,
                    badgeCount = 45
                ),
                BottomNavigationItem(
                    title = "Settings",
                    selected = Icons.Filled.Settings,
                    unselected = Icons.Outlined.Settings,
                    hasNews = true,
                ),
            )
            MyCityAppTheme {
                var SelectedEachItemIndexed by rememberSaveable {
                    mutableStateOf(0)
                }
                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            items.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = SelectedEachItemIndexed == index,
                                    onClick = { SelectedEachItemIndexed = index },
                                    label = {
                                        Text(text = item.title)
                                    },
                                    icon = {
                                        BadgedBox(badge = {
                                            if (item.badgeCount != null) {
                                                Badge { Text(text = item.badgeCount.toString()) }
                                            } else if (item.hasNews) {
                                                Badge()
                                            }
                                        }) {
                                            Icon(
                                                imageVector = if (index == SelectedEachItemIndexed) item.selected
                                                else item.unselected,
                                                contentDescription = item.title
                                            )
                                        }

                                    })
                            }

                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)) {
                    }
                    CityApp()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BarPreview() {
    MyCityAppTheme {
        CityApp()
    }
}