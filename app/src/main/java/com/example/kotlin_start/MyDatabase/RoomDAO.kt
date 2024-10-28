package com.example.kotlin_start.MyDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin_start.MyModels.Result

@Dao
interface RoomDAO {

    @Insert
    suspend fun insertQuote(quote : List<Result>)

    @Query("Select * from quote")
    suspend fun getQuote() : List<Result>
}