package com.monofire.samplemvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.monofire.samplemvvm.R
import com.monofire.samplemvvm.Utilities.InjectorUtils
import com.monofire.samplemvvm.data.Quote
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUI()
    }

    private fun initializeUI() {

        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach {
                stringBuilder.append("$it+\n")
            }
            txt_quote.text = stringBuilder.toString()


        })
        btn_save.setOnClickListener {
            val quote=Quote(editText_quote.text.toString(),editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_author.setText("")
            editText_quote.setText("")

        }
    }
}
