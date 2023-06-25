package com.brikmas.travelapp

class AndroidPlatform : Platform {
    override val name: String = "Web"
}

actual fun getPlatform(): Platform = AndroidPlatform()