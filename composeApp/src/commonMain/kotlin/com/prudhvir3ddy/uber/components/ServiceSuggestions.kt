package com.prudhvir3ddy.uber.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

data class ServiceMini(
    val title: String,
    val descriptionEmoji: String,
    val imageLink: String,
    val isPromo: Boolean = false,
    val serviceType: ServiceType
)

enum class ServiceType {
    Shuttle,
    Package,
    Trip,
    Rentals,
    Moto,
    Auto,
}

private val servicesMiniList = listOf(
    ServiceMini(
        title = "Shuttle",
        descriptionEmoji = "??",
        imageLink = "https://www.uber-assets.com/image/upload/f_auto,q_auto:eco,c_fill,h_384,w_576/v1731137185/assets/f0/e43a8e-662e-417e-abb6-a7b4c172028e/original/Shuttle.png",
        serviceType = ServiceType.Shuttle
    ),
    ServiceMini(
        title = "Package",
        descriptionEmoji = "📦",
        imageLink = "https://mobile-content.uber.com/launch-experience/connect.png",
        serviceType = ServiceType.Package
    ),
    ServiceMini(
        title = "Trip",
        descriptionEmoji = "🚕",
        imageLink = "https://mobile-content.uber.com/launch-experience/ride.png",
        serviceType = ServiceType.Trip
    ),
    ServiceMini(
        title = "Rentals",
        descriptionEmoji = "🚖",
        imageLink = "https://mobile-content.uber.com/uber_reserve/reserve_clock.png",
        serviceType = ServiceType.Rentals
    ),
)
@Composable
fun ServiceSuggestions(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Suggestions", style = MaterialTheme.typography.titleMedium)
            Text(text = "See all", style = MaterialTheme.typography.labelMedium)
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            servicesMiniList.forEach { service ->
                ServiceMiniItem(service)
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun ServiceMiniItem(service: ServiceMini) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(
            color = MaterialTheme.colorScheme.tertiaryContainer,
            shape = RoundedCornerShape(16.dp)
        ).padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        AsyncImage(
            model = service.imageLink,
            contentDescription = null,
            modifier = Modifier.size(48.dp),
        )
//        Text(text = service.descriptionEmoji, style = MaterialTheme.typography.displayMedium)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = service.title, style = MaterialTheme.typography.labelSmall)
        // Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
    }
}
