package com.example.kotlin_start.MyViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_start.MyModels.QuoteList
import com.example.kotlin_start.MyRepository.QuotesRepository
import kotlinx.coroutines.launch

class QuotesViewModel(private val quotesRepository: QuotesRepository) : ViewModel() {

    init{
        viewModelScope.launch {
            quotesRepository.getQuotes(1)
        }
    }
    val quotes : LiveData<QuoteList>
        get() = quotesRepository.quotes


}