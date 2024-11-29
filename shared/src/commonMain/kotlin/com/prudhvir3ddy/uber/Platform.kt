package com.prudhvir3ddy.uber

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform