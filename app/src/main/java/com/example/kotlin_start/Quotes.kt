package com.example.kotlin_start

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
class Quotes(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null ,
    val author : String ,
    val quote:String
)