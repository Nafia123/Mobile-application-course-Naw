package com.app.development.todolist.database

import android.content.Context
import androidx.room.*
import com.app.development.todolist.model.ToDo
import com.app.development.todolist.model.ToDoList


@Database(entities = [ToDoList::class], version = 3,exportSchema = false)
@TypeConverters(Converters::class)
abstract class CalendarRoomDatabase : RoomDatabase(){

    abstract fun toDoDao(): ToDoDao

    companion object{
        private const val DATABASE_NAME = "CALENDAR_DATABASE"

        @Volatile
        private var INSTANCE : CalendarRoomDatabase? = null

        fun getDatabase(context: Context): CalendarRoomDatabase?{
            if(INSTANCE == null){
                synchronized(CalendarRoomDatabase::class.java){
                    if(INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            CalendarRoomDatabase::class.java, DATABASE_NAME
                        ).fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}