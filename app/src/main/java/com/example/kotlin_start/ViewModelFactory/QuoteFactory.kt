package com.example.kotlin_start.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_start.MyRepository.QuotesRepository
import com.example.kotlin_start.MyViewModels.QuotesViewModel

class QuoteFactory(private val quotesRepository: QuotesRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(quotesRepository) as T
    }
}