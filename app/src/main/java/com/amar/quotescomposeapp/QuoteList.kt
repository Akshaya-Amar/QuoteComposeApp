package com.amar.quotescomposeapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun QuoteList(data: List<Quote>) {
     LazyColumn(modifier = Modifier.fillMaxSize()) {
          items(data) { quote->
               QuoteListItem(quote)
          }
     }
}