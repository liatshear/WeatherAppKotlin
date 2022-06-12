package com.tests.weatheredu.data.local_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [UserEntity::class], version = 2)
abstract class RoomAppDb: RoomDatabase() {


    abstract fun userDao(): UserDao?

    companion object {
        private var INSTANCE: RoomAppDb?= null


        fun getAppDatabase(context: Context): RoomAppDb? {

            // checking if we have/ dont have a database currently
            if(INSTANCE == null ) {
                // if we dont have a database, build one
                INSTANCE = Room.databaseBuilder<RoomAppDb>(
                    context.applicationContext, RoomAppDb::class.java, "AppDBB"
                )
                    // allows us to access database on the mainthread
                    .allowMainThreadQueries()
                    .build()

            }
            return INSTANCE
        }
    }
}
