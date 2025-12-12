package com.unicofrance.uniexo.data.repositories

import com.unicofrance.uniexo.data.local.database.entities.User
import com.unicofrance.uniexo.data.local.database.entities.UserDao

class UserRepository(private val userDao: UserDao) {
    fun getAll() = userDao.getAll()

    suspend fun insert(user: User) = userDao.insert(user)

    suspend fun deleteAll() = userDao.deleteAll()
}