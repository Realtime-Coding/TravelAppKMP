package com.brikmas.travelapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform