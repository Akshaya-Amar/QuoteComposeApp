package com.amar.quotescomposeapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : ComponentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContent {
//               QuoteListItem()
//               QuoteDetail()
//               DisplayItems()
               val data = getQuotes(this)
               GenerateScreen(data)
          }
     }
}

@Composable
fun GenerateScreen(data: List<Quote>) {
     QuoteListScreen(data)
}

@Preview(showSystemUi = true)
@Composable
private fun GenerateScreenPreview() {
     GenerateScreen(
          listOf(
               Quote("You must be the change you wish to see in the world.", "Mahatma Gandhi"),
               Quote(
                    "Spread love everywhere you go. Let no one ever come to you without leaving happier.",
                    "Mother Teresa"
               )
          )
     )
}

private fun getQuotes(context: Context): List<Quote> {
     val json = context.assets.open("quotes.json")
          .bufferedReader()
          .use { it.readText() }

     val gson = Gson()
     val listType = object : TypeToken<List<Quote>>() {}.type
     return gson.fromJson(json, listType)
}

@Composable
fun DisplayItems(modifier: Modifier = Modifier) {
     val context = LocalContext.current
     LazyColumn(modifier = Modifier.fillMaxSize()) {
          items(getSampleItems()) { item ->
               SampleItem(item) {
                    Toast.makeText(context, item.name, Toast.LENGTH_LONG).show()
               }
          }
     }
}

@Composable
fun SampleItem(sample: Sample, onClick: () -> Unit) {
     Card(
          modifier = Modifier
               .fillMaxWidth()
               .clickable { onClick() }
               .padding(vertical = 8.dp, horizontal = 16.dp),
          elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          shape = RoundedCornerShape(4.dp)
     ) {
          Row(
               modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
               verticalAlignment = Alignment.CenterVertically
          ) {
               Text(
                    text = sample.name,
                    modifier = Modifier.weight(1f),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
               )

               Spacer(modifier = Modifier.width(8.dp))

               Text(
                    text = sample.age.toString(),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
               )
          }
     }
}

/*@Preview(showBackground = true)
@Composable
private fun SampleItemsPreview() {
     DisplayItems()
}*/

private fun getSampleItems(): List<Sample> {
     /*return listOf(
          Sample("Akshaya", 33),
          Sample("Amar", 58)
     )*/
     return List(100) { index ->
          Sample("Person ${index + 1}", (18..60).random())
     }
}


/*
@Preview(showBackground = true)
@Composable
private fun QuoteListItemPreview() {
     QuoteListItem()
}*/

@Composable
fun QuoteDetail() {
     Box(
          contentAlignment = Alignment.Center,
          modifier = Modifier.fillMaxSize()
     ) {
          Card(
               modifier = Modifier.padding(32.dp),
               elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
               colors = CardDefaults.cardColors(containerColor = Color.White),
               shape = RoundedCornerShape(4.dp)
          ) {
               Column(modifier = Modifier.padding(16.dp, 24.dp)) {
                    Image(
                         imageVector = Icons.Filled.FormatQuote,
                         contentDescription = "Quote",
                         modifier = Modifier
                              .size(80.dp)
                              .rotate(180F)
                    )
                    Text(
                         text = "Time is the most valuable thing a man can spend",
                         fontSize = 24.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                         text = "Theophrastus",
                         style = MaterialTheme.typography.bodyLarge
                    )
               }
          }
     }
}

//@Preview(showSystemUi = true)
/*
@Preview(showBackground = true)
@Composable
private fun QuoteDetailPreview() {
     QuoteDetail()
}*/
