package com.mrshashankbisht.assignmenteka.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM FormEntity")
    fun getAll(): List<FormEntity>

    @Query("SELECT * FROM formentity WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<FormEntity>
    @Insert
    fun insertAll(vararg users: FormEntity)
    @Insert
    fun insertAllOne(users: FormEntity): Long
}