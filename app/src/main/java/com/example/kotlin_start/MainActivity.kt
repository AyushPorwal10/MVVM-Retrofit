package com.example.kotlin_start


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_start.MyAPI.Quotes_Service
import com.example.kotlin_start.MyAPI.Retrofit_OBJ_Helper
import com.example.kotlin_start.MyModels.QuoteList
import com.example.kotlin_start.MyRepository.QuotesRepository
import com.example.kotlin_start.MyViewModels.QuotesViewModel
import com.example.kotlin_start.ViewModelFactory.QuoteFactory



class MainActivity : AppCompatActivity() {
    lateinit var  quotesViewModel: QuotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val repository = (application as MyApplication).quotesRepository

        quotesViewModel = ViewModelProvider(this , QuoteFactory(repository)).get(QuotesViewModel::class.java)

        quotesViewModel.quotes.observe(this , Observer {
            Log.d("Testing",it.results.toString())
        })
    }

}