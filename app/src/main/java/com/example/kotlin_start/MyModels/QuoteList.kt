package com.example.kotlin_start.MyModels

import androidx.room.Entity



class QuoteList(
    val count : Int,
    val lastItemIndex : Int,
    val page :Int,
    val results : List<Result>,
    val totalCount : Int,
    val totalPages : Int
)