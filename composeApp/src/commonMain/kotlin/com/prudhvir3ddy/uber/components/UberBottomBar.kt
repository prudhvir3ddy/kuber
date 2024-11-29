package com.prudhvir3ddy.uber.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val description: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val screen: BottomNavigationScreen
)

enum class BottomNavigationScreen {
    Home,
    Services,
    Activity,
    Account
}

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        title = "Home",
        description = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Filled.Home,
        screen = BottomNavigationScreen.Home
    ),
    BottomNavigationItem(
        title = "Services",
        description = "Services",
        selectedIcon = Icons.Filled.Apps,
        unselectedIcon = Icons.Filled.Apps,
        screen = BottomNavigationScreen.Services
    ),
    BottomNavigationItem(
        title = "Activity",
        description = "Activity",
        selectedIcon = Icons.Filled.Receipt,
        unselectedIcon = Icons.Filled.Receipt,
        screen = BottomNavigationScreen.Activity
    ),
    BottomNavigationItem(
        title = "Account",
        description = "Account",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Filled.Person,
        screen = BottomNavigationScreen.Account
    ),
)

@Composable
fun UberBottomBar(selectedBottomNavigationIndex: Int, onNavItemSelected: (Int) -> Unit) {
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        bottomNavigationItems.forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(
                selected = index == selectedBottomNavigationIndex,
                icon = {
                    if (selectedBottomNavigationIndex == index) {
                        Icon(
                            imageVector = bottomNavigationItem.selectedIcon,
                            contentDescription = bottomNavigationItem.description
                        )
                    } else {
                        Icon(
                            imageVector = bottomNavigationItem.unselectedIcon,
                            contentDescription = bottomNavigationItem.description
                        )
                    }
                },
                label = {
                    Text(bottomNavigationItem.title)
                },
                onClick = {
                    onNavItemSelected(index)
                }
            )
        }
    }
}