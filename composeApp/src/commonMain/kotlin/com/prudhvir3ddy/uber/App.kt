package com.prudhvir3ddy.uber

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding).fillMaxSize().padding(horizontal = 16.dp)
            ) {
                UberContent(
                    selectedBottomNavigationIndex = selectedBottomNavigationIndex.value,
                )
            }
        }
    }
}

@Composable
fun UberContent(selectedBottomNavigationIndex: Int, modifier: Modifier = Modifier) {
    when (bottomNavigationItems[selectedBottomNavigationIndex].screen) {
        BottomNavigationScreen.Home -> {
            HomeScreen(modifier)
        }

        BottomNavigationScreen.Services -> {
            ServicesScreen(modifier)
        }

        BottomNavigationScreen.Activity -> {
            ActivityScreen(modifier)
        }

        BottomNavigationScreen.Account -> {
            AccountScreen(modifier)
        }
    }
}

