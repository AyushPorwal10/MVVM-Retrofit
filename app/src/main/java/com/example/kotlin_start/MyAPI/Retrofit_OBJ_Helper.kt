package com.example.kotlin_start.MyAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_OBJ_Helper {

    val BASE_URL = "https://quotable.io/"
    var RETROFIT_OBJ :Retrofit? =  null
    fun getInstance(): Retrofit {
        if(RETROFIT_OBJ == null){
            RETROFIT_OBJ = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // this is used to convert JSON object to java or kotlin object
            .build();
        }
        return RETROFIT_OBJ!!
    }
}