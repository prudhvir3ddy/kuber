package com.prudhvir3ddy.uber

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Uber",
    ) {
        App()
    }
}