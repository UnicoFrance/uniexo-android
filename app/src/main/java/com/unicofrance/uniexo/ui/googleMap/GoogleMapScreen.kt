package com.unicofrance.uniexo.ui.googleMap

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.GoogleMap
import com.unicofrance.uniexo.ui.lib.SvgIcon

@Composable
fun GoogleMapScreen(
    modifier: Modifier = Modifier,
    viewModel: GoogleMapViewModel
) {
    GoogleMap(modifier = modifier)
}