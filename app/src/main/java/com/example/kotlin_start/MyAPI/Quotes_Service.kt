package com.example.kotlin_start.MyAPI

import com.example.kotlin_start.MyModels.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Quotes_Service {

    // this is end point
    @GET("/quotes")


    // we are adding Query Parameter
    suspend fun getQuotes(@Query("page")page : Int) : Response<QuoteList>

    //       BASE_URL +   "/quotes?page= (here we pass either 1 or 2 ...)"
}