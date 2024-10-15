
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import di.HomeScreenModelProvider
import okio.FileSystem
import theme.TravelAppTheme
import ui.component.BottomMenuBar
import ui.component.tabs
import ui.screen.CartTab
import ui.screen.FavoriteTab
import ui.screen.HomeTab
import ui.screen.GeminiTab
import util.AnimateVisibility

@Composable
internal fun App() {
    TravelAppTheme {

        setSingletonImageLoaderFactory { context ->
            getAsyncImageLoader(context)
        }

        val viewModel = HomeScreenModelProvider.homeScreenModel

        val bottomNavBarVisibility by viewModel.bottomNavBarVisible.collectAsState()

        TabNavigator(HomeTab) {
            Scaffold(
                content = {
                    CurrentTab()
                },
                bottomBar = {
                    AnimateVisibility(
                        visible = bottomNavBarVisibility,
                        modifier = Modifier
                            .wrapContentSize(Alignment.BottomStart)
                    ) {
                        BottomMenuBar(tabs = tabs) {
                            when (it) {
                                HomeTab -> LocalNavigator.currentOrThrow.push(HomeTab)
                                FavoriteTab -> LocalNavigator.currentOrThrow.push(FavoriteTab)
                                CartTab -> LocalNavigator.currentOrThrow.push(CartTab)
                                GeminiTab -> LocalNavigator.currentOrThrow.push(GeminiTab)
                            }
                        }
                    }
                }
            )
        }
    }
}


internal expect fun openUrl(url: String?)

fun getAsyncImageLoader(context: PlatformContext) =
    ImageLoader.Builder(context).memoryCachePolicy(CachePolicy.ENABLED).memoryCache {
        MemoryCache.Builder().maxSizePercent(context, 0.3).strongReferencesEnabled(true).build()
    }.diskCachePolicy(CachePolicy.ENABLED).networkCachePolicy(CachePolicy.ENABLED).diskCache {
        newDiskCache()
    }.crossfade(true).logger(DebugLogger()).build()

fun newDiskCache(): DiskCache {
    return DiskCache.Builder().directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "image_cache")
        .maxSizeBytes(1024L * 1024 * 1024) // 512MB
        .build()
}

expect fun ByteArray.toComposeImageBitmap(): ImageBitmap