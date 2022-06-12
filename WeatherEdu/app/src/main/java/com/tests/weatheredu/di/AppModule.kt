package com.tests.weatheredu.di

import android.content.Context
import androidx.room.RoomDatabase
import com.tests.weatheredu.MyApplication
import com.tests.weatheredu.data.local_db.RoomAppDb
import com.tests.weatheredu.data.local_db.UserDao
import com.tests.weatheredu.data.remote_db.Constants
import com.tests.weatheredu.data.remote_db.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

/*    @Provides
    @Singleton
    fun providesApplication(@ApplicationContext app : Context) : MyApplication {
        return app as MyApplication
    }*/

    @Provides
    @Singleton
    fun getAppDatabase(context: Context) : RoomAppDb? {
        return RoomAppDb.getAppDatabase(context)
    }

    @Provides
    @Singleton
    fun getAppDao(appDatabase: RoomAppDb) : UserDao? {
        return appDatabase.userDao()
    }

  /*  @Provides
    fun provideBaseUrl() = Constants.BASE_URL*/

    @Provides
    @Singleton
    fun provideMsg() : String {
        return "Sorry, the service seems to be down at the moment,please try again later."
    }
/*
    @Provides
    @Singleton
    fun getRetroInstance(retrofit: Retrofit) :RetrofitHelper{
        return retrofit.create(RetrofitHelper::class.java)
    }*/

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL :String):RetrofitHelper =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitHelper::class.java)
}