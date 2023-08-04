package com.brikmas.travelapp.util

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.asImageBitmap
import com.seiko.imageloader.model.ImageEvent
import com.seiko.imageloader.model.ImageRequest
import com.seiko.imageloader.model.ImageResult
import com.seiko.imageloader.rememberImageAction
import com.seiko.imageloader.rememberImageActionPainter

val BOTTOM_NAV_SPACE = 90.dp

@Composable
fun ImageItem(
    data: Any,
    playAnime: Boolean = true,
    corner: Dp = 10.dp,
    modifier: Modifier = Modifier
) {
    Box(contentAlignment = Alignment.Center) {
        val request = remember(data, playAnime) {
            ImageRequest {
                data(data)
                options {
                    playAnimate = playAnime
                }
            }
        }
        val action by rememberImageAction(request)
        val painter = rememberImageActionPainter(action)
        println("Image -> $data")
        when (val current = action) {
            is ImageEvent.StartWithDisk -> {
                println("ImageEvent.StartWithDisk -> called")
            }

            is ImageEvent.StartWithFetch -> {
                println("ImageEvent.StartWithFetch -> called")
            }

            is ImageEvent.StartWithMemory -> {
                println("ImageEvent.StartWithMemory -> called")
                CircularProgressIndicator()
            }

            is ImageEvent.Progress -> {
                println("ImageEvent.Progress -> ${current.progress}")
            }

            is ImageResult.Source -> {
                println("ImageResult.Source -> called")
            }

            is ImageResult.Bitmap -> {
                println("ImageResult.Bitmap -> called")
                Image(
                    bitmap = current.bitmap.asImageBitmap(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(corner)),
                )
            }

            is ImageResult.Image -> {
                println("ImageResult.Image -> called")
            }

            is ImageResult.Painter -> {
                println("ImageResult.Painter -> called")
            }

            is ImageResult.Error -> {
                println("ImageResult.Error -> " + current.error.message)
            }

            else -> {
                println("None")
            }
        }
    }
}

@Composable
fun AnimateVisibility(
    visible: Boolean = true,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = visible,
        enter = fadeIn(animationSpec = tween(1000)) +
                expandVertically(
                    animationSpec = tween(1500)
                ),
        exit = fadeOut(animationSpec = tween(1000)) +
                shrinkVertically(
                    animationSpec = tween(1500)
                )
    ) {
        content.invoke()
    }
}