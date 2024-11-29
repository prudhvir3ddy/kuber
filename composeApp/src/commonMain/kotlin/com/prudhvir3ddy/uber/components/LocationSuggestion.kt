package com.prudhvir3ddy.uber.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

data class LocationSuggestion(
    val name: String,
    val address: String,
    val icon: ImageVector,
    val locationType: LocationType
)

enum class LocationType {
    Home,
    Work,
    Saved,
    Recent,
}


private val locationSuggestions = listOf(
    LocationSuggestion(
        name = "Home",
        address = "1234 Home St",
        icon = Icons.Filled.Home,
        locationType = LocationType.Home
    ),
    LocationSuggestion(
        name = "Work",
        address = "5678 Work St",
        icon = Icons.Filled.Work,
        locationType = LocationType.Work
    ),
    LocationSuggestion(
        name = "Mama's House",
        address = "Smondo Gachibowli",
        icon = Icons.Filled.Star,
        locationType = LocationType.Saved
    ),
    LocationSuggestion(
        name = "Nexus Hyderabad Mall",
        address = "Nexus Mall, K P H B Phase 9, Kukatpally, Hyderabad, Telangana 500072",
        icon = Icons.Filled.Schedule,
        locationType = LocationType.Recent
    )
)

@Composable
fun LocationSuggestions() {
    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            locationSuggestions.filter { it.locationType == LocationType.Home || it.locationType == LocationType.Work }
                .take(2)
                .forEach { locationSuggestion ->
                    LocationSuggestionItem(locationSuggestion)
                }
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        locationSuggestions.filter { it.locationType == LocationType.Saved || it.locationType == LocationType.Recent }
            .take(2)
            .forEach { locationSuggestion ->
                LocationSuggestionItem(locationSuggestion)
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            }
    }
}

@Composable
fun LocationSuggestionItem(locationSuggestion: LocationSuggestion) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = locationSuggestion.icon, contentDescription = locationSuggestion.name)
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(text = locationSuggestion.name)
            Text(text = locationSuggestion.address, overflow = TextOverflow.Ellipsis, maxLines = 1)
        }
    }
}
