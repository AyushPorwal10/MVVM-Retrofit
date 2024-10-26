package com.example.kotlin_start

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDAO {
    @Query("Select * from quote")
     fun getQuote(): LiveData<List<Quotes>>

    @Insert
    suspend fun insertQuote(quotes: Quotes)

}