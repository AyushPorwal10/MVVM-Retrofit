package com.example.kotlin_start.MyModels

import androidx.room.Entity
import androidx.room.PrimaryKey


// THIS IS MODEL CLASS THAT WE USE FOR API RESPONSE BUT HERE WE ALSO USING IT AS ENTITY FOR ROOM DATABASE


@Entity(tableName = "quote")
class Result(
    @PrimaryKey(autoGenerate = true)
    val quoteId : Int,

    val _id : String ,
    val author : String ,
    val authorSLug : String ,
    val content : String ,
    val dateAdded : String ,
    val dateModified : String ,
    val length  : Int ,

)