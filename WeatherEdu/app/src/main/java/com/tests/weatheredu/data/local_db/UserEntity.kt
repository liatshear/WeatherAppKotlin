package com.tests.weatheredu.data.local_db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cityName")
data class UserEntity(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "city") val city: String,
    //@ColumnInfo(name = "temperature") val temp: String

    )