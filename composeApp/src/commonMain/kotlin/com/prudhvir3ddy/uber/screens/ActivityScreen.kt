package com.prudhvir3ddy.uber.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingFlat
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.prudhvir3ddy.uber.components.ServiceType
import com.prudhvir3ddy.uber.components.UberTopBar

@Composable
fun ActivityScreen(modifier: Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            UberTopBar("Activity")
        }
    ) { innerPadding ->

        LazyColumn(modifier = Modifier.padding(innerPadding)) {

            item {
                Text("Upcoming")
            }

            item {
                NoUpComingTrips(modifier.padding(vertical = 16.dp))
            }

            items(activities.size) { index ->
                val activity = activities[index]
                ActivityItem(activity = activity)
                HorizontalDivider(modifier = Modifier.padding(start = 64.dp))
            }
        }

    }
}

@Composable
fun NoUpComingTrips(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().border(
            1.dp,
            MaterialTheme.colorScheme.secondaryContainer,
            shape = RoundedCornerShape(8.dp)
        ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                "You have no upcoming trips",
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(Modifier.size(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Reserve your trip", style = MaterialTheme.typography.bodySmall)
                Spacer(Modifier.size(4.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.TrendingFlat,
                    contentDescription = "right arrow",
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(Modifier.weight(1f))

        AsyncImage(
            model = "https://mobile-content.uber.com/uber_reserve/reserve_clock.png",
            contentDescription = "No upcoming trips",
            modifier = Modifier.size(64.dp).padding(start = 16.dp, end = 8.dp)
        )
    }

}

@Composable
fun ActivityItem(activity: Activity) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ActivityImage(activity.displayImage)
        Spacer(Modifier.padding(8.dp))
        ActivityDetails(activity)
        Spacer(Modifier.weight(1f))
        if (activity.allowRebook) {
            RebookButton()
        }
    }
}

@Composable
fun RebookButton() {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier.border(
            color = MaterialTheme.colorScheme.secondaryContainer,
            shape = RoundedCornerShape(16.dp),
            width = 1.dp
        ).padding(
            horizontal = 8.dp, vertical = 8.dp
        )
    ) {
        Icon(
            imageVector = Icons.Default.Replay,
            contentDescription = "Rebook",
            modifier = Modifier.size(16.dp)
        )
        Text("Rebook", style = MaterialTheme.typography.labelSmall)
    }
}


@Composable
fun ActivityDetails(activity: Activity) {
    Column {
        Text(text = activity.displayAddress)
        Text(text = activity.timeStamp, style = MaterialTheme.typography.bodySmall)
        Text(
            text = "${activity.currency}${activity.amount}",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun ActivityImage(imageData: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = imageData,
        contentDescription = "Activity Image",
        modifier = modifier.size(56.dp).border(
            color = MaterialTheme.colorScheme.surfaceContainer,
            shape = RoundedCornerShape(8.dp),
            width = 1.dp
        )
    )
}


data class Activity(
    val id: Long,
    val displayAddress: String,
    val timeStamp: String,
    val amount: Double,
    val currency: String,
    val status: String,
    val type: ServiceType,
    val displayImage: String,
    val allowRebook: Boolean = true,
)

val activities = listOf(
    Activity(
        id = 1,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Auto,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/TukTuk_Green_v1.png"
    ),
    Activity(
        id = 2,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Shuttle,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/HCV_v1.png"
    ),
    Activity(
        id = 3,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Moto,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/Uber_Moto_India1.png"
    ),
    Activity(
        id = 4,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Trip,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/Hatchback.png"
    ),
    Activity(
        id = 5,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Auto,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/TukTuk_Green_v1.png"
    ),
    Activity(
        id = 6,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Package,
        displayImage = "https://mobile-content.uber.com/launch-experience/connect.png"
    ),
    Activity(
        id = 1,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Auto,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/TukTuk_Green_v1.png"
    ),
    Activity(
        id = 2,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Shuttle,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/HCV_v1.png"
    ),
    Activity(
        id = 3,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Moto,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/Uber_Moto_India1.png"
    ),
    Activity(
        id = 4,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Trip,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/Hatchback.png"
    ),
    Activity(
        id = 5,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Auto,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/TukTuk_Green_v1.png"
    ),
    Activity(
        id = 6,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Package,
        displayImage = "https://mobile-content.uber.com/launch-experience/connect.png"
    ),
    Activity(
        id = 1,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Auto,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/TukTuk_Green_v1.png"
    ),
    Activity(
        id = 2,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Shuttle,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/HCV_v1.png"
    ),
    Activity(
        id = 3,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Moto,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/Uber_Moto_India1.png"
    ),
    Activity(
        id = 4,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Trip,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/Hatchback.png"
    ),
    Activity(
        id = 5,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Auto,
        displayImage = "https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/TukTuk_Green_v1.png"
    ),
    Activity(
        id = 6,
        displayAddress = "1234, 1st Street",
        timeStamp = "2 hours ago",
        amount = 12.0,
        currency = "$",
        status = "Completed",
        type = ServiceType.Package,
        displayImage = "https://mobile-content.uber.com/launch-experience/connect.png"
    ),
)

/**
 * https://d1a3f4spazzrp4.cloudfront.net/car-types/haloProductImages/v1.1/Moto_v1.png
 */
