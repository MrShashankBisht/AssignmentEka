package com.mrshashankbisht.assignmenteka.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FormEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}