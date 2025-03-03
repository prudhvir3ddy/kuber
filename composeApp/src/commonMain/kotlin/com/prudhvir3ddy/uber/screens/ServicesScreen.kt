package com.prudhvir3ddy.uber.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.prudhvir3ddy.uber.components.UberTopBar

@Composable
fun ServicesScreen(modifier: Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            UberTopBar("Services")
        }
    ) { }
}
