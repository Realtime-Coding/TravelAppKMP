package com.brikmas.travelapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import androidx.compose.ui.window.ComposeUIViewController
import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.component.setupDefaultComponents
import okio.Path.Companion.toPath
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask
import platform.UIKit.UIViewController

actual fun getPlatformName(): String = "iOS"
fun MainViewController(): UIViewController = ComposeUIViewController {
    CompositionLocalProvider(
        LocalImageLoader provides remember { generateImageLoader() },
    ) {
        Column {
            // To skip upper part of screen.
            Box(
                modifier = Modifier
                    .height(40.dp)
            )
            App()
        }
    }
}

private fun generateImageLoader(): ImageLoader {
     return ImageLoader {
         components {
             setupDefaultComponents()
         }
         interceptor {
             memoryCacheConfig {
                 maxSizeBytes(32 * 1024 * 1024) // 32MB
             }
             diskCacheConfig {
                 directory(getCacheDir().toPath().resolve("image_cache"))
                 maxSizeBytes(512L * 1024 * 1024) // 512MB
             }
         }
     }
}

 private fun getCacheDir(): String {
     return NSSearchPathForDirectoriesInDomains(
         NSCachesDirectory,
         NSUserDomainMask,
         true,
     ).first() as String
 }

