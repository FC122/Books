package com.filipcica.books

import retrofit2.Call
import retrofit2.http.GET

interface FakerEndpoints {
    @GET("/api/v1/books?_quantity=100")
    fun getBooks(): Call<ResponseData>
}