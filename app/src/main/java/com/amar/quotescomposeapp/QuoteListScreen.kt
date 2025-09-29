package com.amar.quotescomposeapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuoteListScreen(data: List<Quote>, onClick: (Quote) -> Unit) {
     Column(modifier = Modifier.fillMaxSize()) {
          Text(
               text = "Quotes App",
               modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 16.dp),
               fontSize = 36.sp,
               textAlign = TextAlign.Center
          )
          QuoteList(data, onClick)
     }
}