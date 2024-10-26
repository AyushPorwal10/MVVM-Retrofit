package com.example.kotlin_start

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() : LiveData<List<Quotes>> {
       return quoteRepository.getQuotes()
    }
     fun insertQuote(quotes: Quotes){
         viewModelScope.launch ( Dispatchers.IO){
             quoteRepository.insertQuote(quotes)
         }

    }
}