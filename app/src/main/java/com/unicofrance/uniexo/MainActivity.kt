package com.unicofrance.uniexo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.unicofrance.uniexo.data.local.database.AppDatabase
import com.unicofrance.uniexo.ui.googleMap.GoogleMapScreen
import com.unicofrance.uniexo.ui.googleMap.GoogleMapViewModel
import com.unicofrance.uniexo.ui.theme.UniExoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val database = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "database"
            ).build()
            UniExoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GoogleMapScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        viewModel = GoogleMapViewModel()
                    )
                }
            }
        }
    }
}