package com.prudhvir3ddy.uber.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Today
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WhereToComposable(modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth().background(
            shape = RoundedCornerShape(32.dp),
            color = MaterialTheme.colorScheme.tertiaryContainer
        ).padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
        )
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "Where to?",
        )
        Spacer(modifier = Modifier.weight(1f))
        LaterChip()
    }
}

@Composable
private fun LaterChip() {
    Row(
        modifier = Modifier.background(
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(32.dp)
        ).padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Today,
            contentDescription = "Later",
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = "Later",
        )
    }
}
