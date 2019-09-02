package com.monofire.samplemvvm.ui

import androidx.lifecycle.ViewModel
import com.monofire.samplemvvm.data.Quote
import com.monofire.samplemvvm.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {
    fun getQuotes()=quoteRepository.getQuotes()
    fun addQuote(quote: Quote)=quoteRepository.addQuote(quote)
}