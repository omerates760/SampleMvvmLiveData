package com.monofire.samplemvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quoteslist= mutableListOf<Quote>()
    private val quotes=MutableLiveData<List<Quote>>()

    init {
        quotes.value=quoteslist
    }
     fun addQuote(quote:Quote){
        quoteslist.add(quote)
        quotes.value=quoteslist
    }
    fun getQuotes()=quotes as LiveData<List<Quote>>
}