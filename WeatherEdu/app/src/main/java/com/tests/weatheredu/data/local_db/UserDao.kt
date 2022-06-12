package com.tests.weatheredu.data.local_db

import androidx.room.*

@Dao
interface UserDao {


    @Query("SELECT * FROM cityName ORDER BY id DESC")
    fun getAllUserInfo(): List<UserEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity?)

    @Delete
    fun deleteUser(user: UserEntity?)

    @Update
    fun updateUser(user: UserEntity?)



}