package com.example.kotlin_start.MyDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlin_start.MyModels.Result

@Database(entities = [Result::class], version = 1)
abstract class RoomDB : RoomDatabase(){
    abstract fun quoteDao() : RoomDAO

    companion object{
        private var ROOMINSTANCE :RoomDB? = null

        fun getInstance(context : Context) : RoomDB{
            synchronized(this){
                if(ROOMINSTANCE == null){
                    ROOMINSTANCE = Room.databaseBuilder(context , RoomDB::class.java , "quoteDB").build()
                }
            }

            return ROOMINSTANCE!!
        }
    }
}