package com.unicofrance.uniexo.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.unicofrance.uniexo.data.local.database.entities.User
import com.unicofrance.uniexo.data.local.database.entities.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}