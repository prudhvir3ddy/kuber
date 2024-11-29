package com.prudhvir3ddy.uber.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prudhvir3ddy.uber.components.LocationSuggestions
import com.prudhvir3ddy.uber.components.ServiceSuggestions
import com.prudhvir3ddy.uber.components.UberTopBar
import com.prudhvir3ddy.uber.components.WhereToComposable

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier, topBar = {
        UberTopBar("Uber")
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            WhereToComposable()
            Spacer(modifier = Modifier.padding(8.dp))
            LocationSuggestions()
            ServiceSuggestions()
        }
    }
}

