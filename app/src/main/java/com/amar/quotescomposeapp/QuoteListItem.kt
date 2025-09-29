package com.amar.quotescomposeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun QuoteListItem(quote: Quote, onClick: (Quote) -> Unit) {
     Card(
          modifier = Modifier
               .fillMaxWidth()
               .clickable { onClick(quote) }
               .padding(vertical = 8.dp, horizontal = 16.dp),
          elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          shape = RoundedCornerShape(4.dp)
     ) {
          Row(modifier = Modifier.padding(16.dp)) {
               Image(
                    imageVector = Icons.Filled.FormatQuote,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = "Quote",
                    modifier = Modifier
                         .size(40.dp)
                         .rotate(180F)
                         .background(Color.Black)
               )

               Spacer(modifier = Modifier.padding(4.dp))

               Column {
                    Text(
                         text = quote.text ?: "N/A",
                         modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Box(
                         modifier = Modifier
                              .background(Color(0xFFEEEEEE))
                              .fillMaxWidth(.4f)
                              .height(1.dp)
                    )
                    Text(
                         text = quote.author ?: "N/A",
                         modifier = Modifier.padding(top = 4.dp),
                         fontWeight = FontWeight.Thin
                    )
               }
          }
     }
}