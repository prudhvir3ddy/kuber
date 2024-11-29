package com.prudhvir3ddy.uber

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prudhvir3ddy.uber.components.BottomNavigationScreen
import com.prudhvir3ddy.uber.components.UberBottomBar
import com.prudhvir3ddy.uber.components.bottomNavigationItems
import com.prudhvir3ddy.uber.screens.AccountScreen
import com.prudhvir3ddy.uber.screens.ActivityScreen
import com.prudhvir3ddy.uber.screens.HomeScreen
import com.prudhvir3ddy.uber.screens.ServicesScreen
import com.prudhvir3ddy.uber.ui.theme.UberTheme
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    UberTheme {
        val selectedBottomNavigationIndex = remember {
            mutableIntStateOf(0)
        }
        Scaffold(
            bottomBar = {
                UberBottomBar(selectedBottomNavigationIndex.value) { index ->
                    selectedBottomNavigationIndex.value = index
                }
            },
            topBar = {
                UberTopAppBar()
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding).fillMaxSize(),
            ) {
                UberContent(selectedBottomNavigationIndex.value)
            }
        }
    }
}

@Composable
fun UberContent(selectedBottomNavigationIndex: Int) {
    when (bottomNavigationItems[selectedBottomNavigationIndex].screen) {
        BottomNavigationScreen.Home -> {
            HomeScreen(Modifier.padding(16.dp))
        }

        BottomNavigationScreen.Services -> {
            ServicesScreen()
        }

        BottomNavigationScreen.Activity -> {
            ActivityScreen()
        }

        BottomNavigationScreen.Account -> {
            AccountScreen()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UberTopAppBar() {
    TopAppBar(
        title = {
            Text(text = "Uber")
        }
    )
}

