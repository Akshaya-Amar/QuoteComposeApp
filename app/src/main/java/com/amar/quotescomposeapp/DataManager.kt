package com.amar.quotescomposeapp

import androidx.compose.runtime.mutableStateOf

object DataManager {

     var currentPage =  mutableStateOf(Pages.LISTING)
     var currentQuote: Quote? = null

     fun switchPage(quote: Quote?) {
          if (currentPage.value == Pages.LISTING) {
               currentPage.value = Pages.DETAIL
               currentQuote = quote
          } else {
               currentPage.value = Pages.LISTING
          }
     }
}