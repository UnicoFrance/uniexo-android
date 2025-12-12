package com.unicofrance.uniexo

import android.app.Application
import androidx.room.Room
import com.unicofrance.uniexo.data.local.database.AppDatabase
import com.unicofrance.uniexo.data.repositories.UserRepository

class UniExoApplication : Application() {
    private val database by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java, "database"
        ).build()
    }

    val userRepository by lazy { UserRepository(database.userDao()) }
}