package com.example.kotlin_start.MyRepository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_start.MyAPI.Quotes_Service
import com.example.kotlin_start.MyDatabase.RoomDB
import com.example.kotlin_start.MyModels.QuoteList
import com.example.kotlin_start.Utils.NetworkUtil


// This repository class is interacting with API and ROOM DATABASE

class QuotesRepository(
    private val quotesService: Quotes_Service,
    private val roomDB: RoomDB,
    private val applicationContext: Context
){


    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes : LiveData<QuoteList>
        get() = quotesLiveData

    suspend fun getQuotes( page : Int){

        //this is to check if network is available or not

        if(NetworkUtil.assumeItCheckNetwork(applicationContext)){
            val result = quotesService.getQuotes(page)
            if(result.body() != null){
                // if we get data from API we will be storing in Room Databse
                roomDB.quoteDao().insertQuote(result.body()!!.results)
                quotesLiveData.postValue(result.body())
            }
        }
        else{
            val quotes = roomDB.quoteDao().getQuote()
            val quoteList = QuoteList(1, 2, 2, quotes , 1, 1)
            quotesLiveData.postValue(quoteList)
        }

    }



}