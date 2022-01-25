package com.filipcica.books

data class ResponseData(
    val status:String,
    val code:String,
    val total:String,
    val data:ArrayList<Book>
)

