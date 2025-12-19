package com.unicofrance.uniexo.ui.lib

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder

@Composable
fun SvgIcon(
    url: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Image(
        painter = rememberAsyncImagePainter(
            model = url,
            imageLoader = ImageLoader.Builder(context)
                .components {
                    add(SvgDecoder.Factory())
                }
                .build()
        ),
        contentDescription = null,
        modifier = modifier
    )
}