package com.prudhvir3ddy.uber.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.prudhvir3ddy.uber.components.WhereToComposable

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        WhereToComposable()
    }
}