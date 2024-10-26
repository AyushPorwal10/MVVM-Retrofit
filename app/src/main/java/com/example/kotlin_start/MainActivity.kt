package com.example.kotlin_start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.room.Database
import androidx.room.Room
import com.example.kotlin_start.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    var idIncr = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = QuoteDatabase.getDatabaseObj(this.applicationContext).getDao()

        val repository = QuoteRepository(dao)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)



        mainViewModel.getQuotes().observe(this, Observer { quotes ->
            if (quotes.isNotEmpty()) {
                // Display the latest quote
                binding.quotes = quotes.last()

            }
})


binding.addQuoteBtn.setOnClickListener {
    idIncr++
    val quotes = Quotes(idIncr,"Author","Quote")
    mainViewModel.insertQuote(quotes)
}
}

}