package com.example.kotlin_start

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Quotes::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun getDao():QuoteDAO

    companion object{
        private var INSTANCE : QuoteDatabase? = null

        fun getDatabaseObj(context : Context) : QuoteDatabase{

            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext , QuoteDatabase::class.java , "quote_database")
                        .build()
                }

            }
            return INSTANCE!!
        }
    }
}