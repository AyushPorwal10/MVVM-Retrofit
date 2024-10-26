package com.example.kotlin_start

import androidx.lifecycle.LiveData

class QuoteRepository(private val dao : QuoteDAO) {

    fun getQuotes() : LiveData<List<Quotes>>{
        return dao.getQuote()
    }
   suspend fun insertQuote(quotes: Quotes){
        dao.insertQuote(quotes)
    }
}