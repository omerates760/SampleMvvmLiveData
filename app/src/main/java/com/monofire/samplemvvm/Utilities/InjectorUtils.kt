package com.monofire.samplemvvm.Utilities

import com.monofire.samplemvvm.data.FakeDatabase
import com.monofire.samplemvvm.data.QuoteRepository
import com.monofire.samplemvvm.ui.QuoteViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory():QuoteViewModelFactory{
        val quoteRepository=QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuoteViewModelFactory(quoteRepository)
    }
}