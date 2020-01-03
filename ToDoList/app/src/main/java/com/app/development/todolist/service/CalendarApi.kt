package com.app.development.todolist.service

import android.content.Context
import com.app.development.todolist.database.CalendarDao
import com.app.development.todolist.database.CalendarRoomDatabase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class CalendarApi(context: Context) {

    private val context: Context? = context
    private var calendarDao: CalendarDao

    init {
        val database = CalendarRoomDatabase.getDatabase(context)
        calendarDao = database!!.calendarDao()

    }

    companion object{
        private const val baseUrl = "https://www.googleapis.com/calendar/v3/users/me/"

        fun createApi(): CalendarApiService{
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()

            val calendarApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return calendarApi.create(CalendarApiService::class.java)
        }
    }
}