package com.prudhvir3ddy.uber.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.DriveEta
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Route
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Support
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.prudhvir3ddy.uber.components.UberTopBar

@Composable
fun AccountScreen(modifier: Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    UberTopBar("Prudhvi reddy")
                    RatingBadge()
                }
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Account",
                    modifier = Modifier.padding(16.dp).size(48.dp).border(
                        2.dp,
                        MaterialTheme.colorScheme.inverseOnSurface,
                        CircleShape
                    ).padding(8.dp)
                )
            }
        }
    ) { innerPadding ->

        Column(modifier = modifier.padding(innerPadding).verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.padding(8.dp))
            TopSection()
            Promos()

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), thickness = 2.dp)

            AllSections()
        }
    }
}

@Composable
fun AllSections() {
    val sections = listOf(
        SectionItem(
            imageVector = Icons.Default.Settings,
            title = "Settings"
        ),
        SectionItem(
            imageVector = Icons.AutoMirrored.Filled.Message,
            title = "Messages"
        ),
        SectionItem(
            imageVector = Icons.Default.CardGiftcard,
            title = "Send a gift"
        ),
        SectionItem(
            imageVector = Icons.Default.DriveEta,
            title = "Earn by driving or delivering"
        ),
        SectionItem(
            imageVector = Icons.Default.Route,
            title = "Shuttle Routes"
        ),
        SectionItem(
            imageVector = Icons.Default.People,
            title = "Refer Premier and unlock deals"
        ),
        SectionItem(
            imageVector = Icons.Default.Person,
            title = "Manage Uber account"
        ),
        SectionItem(
            imageVector = Icons.Default.Info,
            title = "Legal"
        ),
    )
    sections.forEach {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = it.imageVector,
                contentDescription = it.title,
                modifier = Modifier.padding(16.dp).size(16.dp)
            )
            Text(
                text = it.title,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

data class PromoItem(
    val imageLink: String,
    val title: String,
    val description: String = ""
)

@Composable
fun Promos() {
    val promos = listOf(
        PromoItem(
            imageLink = "https://www.uber-assets.com/image/upload/f_auto,q_auto:eco,c_fill,h_715,w_1072/v1716848206/assets/d6/3d4751-d101-4894-b818-39305052b83f/original/New-promo-codes-page-images-%281%29.png",
            title = "You have multiple Promos",
            description = "We'll automatically apply the one that saves you the most"
        ),
        PromoItem(
            imageLink = "https://www.uber-assets.com/image/upload/f_auto,q_auto:eco,c_fill,h_368,w_552/v1666820385/assets/4b/c7a2f9-d364-475c-b2e8-eff1c74ead56/original/Rides-gift-card.png",
            title = "Save with Uber one",
            description = "Get rewards for 1 month at 74% off"
        ),
    )

    promos.forEach {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp).background(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = RoundedCornerShape(16.dp)
                ).padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(0.8f)) {
                    Text(text = it.title, style = MaterialTheme.typography.titleMedium)
                    Text(text = it.description, style = MaterialTheme.typography.bodySmall)
                }
                AsyncImage(
                    model = it.imageLink,
                    contentDescription = "Promo",
                    modifier = Modifier.weight(0.2f).size(48.dp)
                )
            }
        }
    }
}

data class SectionItem(
    val imageVector: ImageVector,
    val title: String,
)

@Composable
fun TopSection() {
    val topSectionItems = listOf(
        SectionItem(
            imageVector = Icons.Default.Support,
            title = "Help"
        ),
        SectionItem(
            imageVector = Icons.Default.Wallet,
            title = "Wallet"
        ),
        SectionItem(
            imageVector = Icons.Default.Receipt,
            title = "Activity"
        ),
    )
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        topSectionItems.forEach {
            Column(
                modifier = Modifier.padding(8.dp).background(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = RoundedCornerShape(16.dp)
                ).padding(16.dp).weight(1f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = it.imageVector,
                    contentDescription = it.title,
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    text = it.title,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(8.dp)
                )
            }

        }
    }
}

@Composable
fun RatingBadge() {
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .offset(y = (-16).dp)
            .background(color = MaterialTheme.colorScheme.tertiaryContainer, RectangleShape)
            .padding(horizontal = 4.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Rating",
            modifier = Modifier.size(16.dp)
        )
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = "4.91",
            style = MaterialTheme.typography.labelSmall
        )
    }
}
