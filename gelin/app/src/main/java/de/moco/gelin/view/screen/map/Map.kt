package de.moco.gelin.view.screen.map

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun NextGroceryStoreMap(){
    val germany = LatLng(51.0276, 7.5638)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(germany, 10f)
    }
    val locationPermissionState = rememberPermissionState(
        permission = Manifest.permission.ACCESS_FINE_LOCATION,
    )
    if (locationPermissionState.status.isGranted) {
        Text("Location permission Granted")
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = germany),
                title = "Deutschland",
                snippet = "Current Location"
            )
        }
    } else {
        Column {
            val textToShow = if (locationPermissionState.status.shouldShowRationale) {
                "The location is important for this app. Please grant the permission."
            } else {
                "Location permission required for this feature to be available. " +
                        "Please grant the permission"
            }
            Text(textToShow)
            Button(onClick = { locationPermissionState.launchPermissionRequest() }) {
                Text("Request permission")
            }
        }
    }
}

fun getLocation(){
}