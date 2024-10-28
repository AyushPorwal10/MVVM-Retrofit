package com.example.kotlin_start

import android.app.Application
import com.example.kotlin_start.MyAPI.Quotes_Service
import com.example.kotlin_start.MyAPI.Retrofit_OBJ_Helper
import com.example.kotlin_start.MyDatabase.RoomDB
import com.example.kotlin_start.MyRepository.QuotesRepository

class MyApplication: Application() {
    lateinit var quotesRepository: QuotesRepository
    override fun onCreate() {
        super.onCreate()
        initializer()
    }
    fun initializer(){
        val quotesService = Retrofit_OBJ_Helper.getInstance().create(Quotes_Service::class.java)
        val roomDb : RoomDB = RoomDB.getInstance(applicationContext)
         QuotesRepository(quotesService ,roomDb , applicationContext)
    }
}