package com.unicofrance.uniexo.ui.googleMap

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GoogleMapViewModel : ViewModel() {
    private val _userLocation = MutableStateFlow<LatLng?>(null)
    val userLocation = _userLocation.asStateFlow()

    fun fetchLocation(context: Context, fusedLocationClient: FusedLocationProviderClient) {
        if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            try {
                fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                    location?.let {
                        val position = LatLng(it.latitude, it.longitude)
                        _userLocation.update { position }
                    }
                }
            } catch (e: SecurityException) {
                Log.e("ERROR", "Permission for location access was revoked: ${e.localizedMessage}")
            }
        } else {
            Log.e("ERROR", "Location permission is not granted.")
        }
    }
}