package com.monofire.samplemvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monofire.samplemvvm.data.QuoteRepository

class QuoteViewModelFactory(private val quoteRepository: QuoteRepository):ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}