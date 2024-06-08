
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.defaultNavigatorSaver
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
import okio.FileSystem
import theme.TravelAppTheme
import ui.component.BottomMenuBar
import ui.component.Menu
import ui.component.menuItems
import ui.screen.CartScreen
import ui.screen.FavoriteScreen
import ui.screen.HomeScreen
import ui.screen.ProfileScreen
import util.AnimateVisibility

@Composable
internal fun App() {
    TravelAppTheme {

        setSingletonImageLoaderFactory { context ->
            getAsyncImageLoader(context)
        }

        val visible by remember { mutableStateOf(true) }

        TabNavigator(HomeScreen) {
            Scaffold(
                content = {
                    CurrentTab()
                },
                bottomBar = {
//                    BottomNavigation {
//                        TabNavigationItem(HomeTab)
//                        TabNavigationItem(FavoritesTab)
//                        TabNavigationItem(ProfileTab)
//                    }
                    AnimateVisibility(
                        visible = visible,
                        modifier = Modifier
                            .wrapContentSize(Alignment.BottomStart)
                    ) {
                        BottomMenuBar(tabs = menuItems) {
                            when (it) {
                                HomeScreen -> LocalNavigator.currentOrThrow.push(HomeScreen)
                                FavoriteScreen -> LocalNavigator.currentOrThrow.push(FavoriteScreen)
                                CartScreen -> LocalNavigator.currentOrThrow.push(CartScreen)
                                ProfileScreen -> LocalNavigator.currentOrThrow.push(ProfileScreen)
                            }
                        }
                    }
                }
            )
        }
        //Navigator(HomeScreen)
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