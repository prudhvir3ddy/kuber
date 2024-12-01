package com.prudhvir3ddy.uber.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.prudhvir3ddy.uber.components.LocationSuggestions
import com.prudhvir3ddy.uber.components.ServiceSuggestions
import com.prudhvir3ddy.uber.components.UberTopBar
import com.prudhvir3ddy.uber.components.WhereToComposable

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier, topBar = {
        UberTopBar("Uber")
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize().verticalScroll(
            rememberScrollState()
        )) {
            WhereToComposable()
            Spacer(modifier = Modifier.height(8.dp))
            LocationSuggestions()
            Spacer(modifier = Modifier.height(16.dp))
            ServiceSuggestions()
            Spacer(modifier = Modifier.height(16.dp))
            FancyCarousels(
                heading = "Commute smarter",
                items = listOf(
                    FancyCarouselItem(
                        title = "Uber Auto",
                        description = "Affordable rides for everyday commutes",
                        imageLink = "https://www.uber-assets.com/image/upload/f_auto,q_auto:eco,c_fill,h_715,w_1072/v1712926828/assets/a3/cf8564-e2a6-418c-b9b0-65dd285c100b/original/3-2-ridesharing-new.jpg"
                    ),
                    FancyCarouselItem(
                        title = "Uber Moto",
                        description = "Quick and affordable bike rides",
                        imageLink = "https://www.uber-assets.com/image/upload/f_auto,q_auto:eco,c_fill,h_638,w_956/v1677712861/assets/35/390041-6c33-425c-b7ee-7258bb7c0817/original/upfront_historic-data_360x240-2x.png"
                    ),
                    FancyCarouselItem(
                        title = "Uber Rentals",
                        description = "Rent a car for a few hours or days",
                        imageLink = "https://www.uber-assets.com/image/upload/f_auto,q_auto:eco,c_fill,h_522,w_927/v1710098930/assets/c9/20ea17-96de-4639-a7fa-96a0b0661214/original/RM_BackseatRiders.jpg"
                    ),
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            FancyCarousels(
                "Save every day", items = listOf(
                    FancyCarouselItem(
                        title = "Uber Pass",
                        description = "Get more with a monthly subscription",
                        imageLink = "https://www.uber-assets.com/image/upload/f_auto,q_auto:eco,c_fill,h_368,w_552/v1680741891/assets/37/1a06c3-90ce-4d5d-9ee8-440dfd1e0231/original/Achieving-new-tier.jpg"
                    ),
                    FancyCarouselItem(
                        title = "Uber Eats Pass",
                        description = "Get unlimited free delivery",
                        imageLink = "https://ubernewsroomapi.10upcdn.com/wp-content/uploads/2024/10/Uber-Teens-10.png"
                    ),
                    FancyCarouselItem(
                        title = "Uber One",
                        description = "Get more with a monthly subscription",
                        imageLink = "https://ubernewsroomapi.10upcdn.com/wp-content/uploads/2024/10/SS_AccessibilityAirport-1080x540.jpg"
                    ),
                )
            )
        }
    }
}


data class FancyCarouselItem(
    val title: String,
    val description: String,
    val imageLink: String,
    val deeplink: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FancyCarousels(
    heading: String,
    modifier: Modifier = Modifier,
    items: List<FancyCarouselItem> = emptyList()
) {

    Column {
        Text(
            text = heading,
            style = MaterialTheme.typography.titleMedium,
        )
        Row(
            modifier = modifier.fillMaxSize().padding(vertical = 8.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            items.forEach { item ->
                Column(modifier = Modifier.width(IntrinsicSize.Min)) {
                    AsyncImage(
                        model = item.imageLink,
                        contentDescription = item.title,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.width(250.dp).height(150.dp).clip(
                            shape = RoundedCornerShape(8.dp)
                        )
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = item.title, style = MaterialTheme.typography.titleSmall)
                    Text(text = item.description, style = MaterialTheme.typography.bodySmall)
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}
