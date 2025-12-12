package com.unicofrance.uniexo.ui.googleMap

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.maps.android.compose.GoogleMap

@Composable
fun GoogleMapScreen(
    modifier: Modifier = Modifier,
    viewModel: GoogleMapViewModel
) {
    LocationPermissionRequester(viewModel::fetchLocation)
    GoogleMap(modifier = modifier)
}

@Composable
fun LocationPermissionRequester(fetchLocation: (Context, FusedLocationProviderClient) -> Unit) {
    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }


    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) fetchLocation(context, fusedLocationClient)
        else Log.e("ERROR", "Location permission was denied by the user.")

    }

    LaunchedEffect(Unit) {
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) ->
                fetchLocation(context, fusedLocationClient)


            else -> permissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
}